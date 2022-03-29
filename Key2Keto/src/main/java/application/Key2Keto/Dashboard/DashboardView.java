package application.Key2Keto.Dashboard;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.Arrays;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Interfaces.ViewInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class DashboardView extends Pane implements ViewInterface {
	private VBox view;
	private VBox recipeInformationBox;
	private VBox goalInformationBox;
	private HBox upperHalf;
	private HBox lowerHalf;

	private Label userName;
	private Label dietType;
	private Label breakfastRecipe;
	private Label lunchRecipe;
	private Label dinnerRecipe;
	private Label snackRecipe;
	private Label weeklyGoalsLabel;
	private ArrayList<CheckBox> goalList;
	private Label todaysRecipeTitle;
	private Label goalLabel;
	private LineChart<String, Number> waterChart;
	private LineChart<String, Number> sleepChart;

	public DashboardView(Account user) {
		DashboardViewLogic.setDashboard(user);
		populateSleepChart();
		populateWaterChart();
		initializeVariables();
		populateChildren();
		stylizeElements();
		populateDaysRecipes();
		populateWeeksGoals();
		this.getChildren().add(view);
	}

	@Override
	public void initializeVariables() {
		this.view = new VBox();
		this.recipeInformationBox = new VBox();
		this.goalInformationBox = new VBox();
		this.upperHalf = new HBox();
		this.lowerHalf = new HBox();
		this.userName = new Label(DashboardViewLogic.getDashboard().getUserAccount().getFirstName() + " "
				+ DashboardViewLogic.getDashboard().getUserAccount().getLastName() + "'s Key2Keto Overview");
		this.dietType = new Label(
				"Selected Diet Type: " + DashboardViewLogic.getDashboard().getUserAccount().getDietType());
		this.todaysRecipeTitle = new Label("TODAY'S RECIPES");
		this.breakfastRecipe = new Label("Chosen Breakfast: Nothing Chosen");
		this.lunchRecipe = new Label("Chosen Lunch: Nothing Chosen");
		this.dinnerRecipe = new Label("Chosen Dinner: Nothing Chosen");
		this.snackRecipe = new Label("Chosen Snack: Nothing Chosen");
		this.weeklyGoalsLabel = new Label("GOALS FOR THE DAY");
		this.goalList = new ArrayList<CheckBox>();
		this.goalLabel = new Label(
				"You do not have any goals set for today! " + "\nClick the Tracker tab and set today's goals!");
	}

	@Override
	public void populateChildren() {
		this.recipeInformationBox.getChildren().addAll(this.todaysRecipeTitle, this.dietType, this.breakfastRecipe,
				this.lunchRecipe, this.dinnerRecipe, this.snackRecipe);
		this.goalInformationBox.getChildren().addAll(this.weeklyGoalsLabel, this.goalLabel);
		this.upperHalf.getChildren().addAll(this.recipeInformationBox, this.goalInformationBox);
		this.lowerHalf.getChildren().addAll(this.waterChart, this.sleepChart);
		this.view.getChildren().addAll(this.userName, this.upperHalf, this.lowerHalf);
	}

	private void populateDaysRecipes() {

		this.breakfastRecipe.setText(DashboardViewLogic.populateDaysRecipe(0));
		this.lunchRecipe.setText(DashboardViewLogic.populateDaysRecipe(1));
		this.dinnerRecipe.setText(DashboardViewLogic.populateDaysRecipe(2));
		this.snackRecipe.setText(DashboardViewLogic.populateDaysRecipe(3));
	}

	private void populateSleepChart() {
		this.sleepChart = null;
		CategoryAxis xaxis = new CategoryAxis();
		NumberAxis yaxis = new NumberAxis(0, 14, 2);
		
		xaxis.setLabel("Day of Week");
		yaxis.setLabel("Hours of Sleep");

		this.sleepChart = new LineChart<String, Number>(xaxis, yaxis);
		this.sleepChart.setTitle("Sleep Overview");

		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("Weekly Hours of Sleep");
		
		for(int i = 0; i < 7; i++) {
			series.getData().add(new Data<String, Number>(DashboardViewLogic.getDashboard().getUserAccount(
					).getTrackers().get(i).dayOfWeek, DashboardViewLogic.getDashboard().getUserAccount()
					.getTrackers().get(i).getHoursOfSleep()));
		}
		
		this.sleepChart.getData().add(series);
		this.sleepChart.setLegendVisible(false);
		this.sleepChart.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
	}

	private void populateWaterChart() {
		this.waterChart = null;
		CategoryAxis xaxis = new CategoryAxis();
		NumberAxis yaxis = new NumberAxis(0, 128, 8);
		
		xaxis.setLabel("Day of Week");
		yaxis.setLabel("Ounces of Water");
		
		this.waterChart = new LineChart<String, Number>(xaxis, yaxis);
		this.waterChart.setTitle("Water Consumption");
		
		XYChart.Series<String, Number> series = new Series<String, Number>();
		series.setName("Daily Ounces of Water Consumed");
		
		for(int i = 0; i < 7; i++) {
			series.getData().add(new Data<String, Number>(DashboardViewLogic.getDashboard().getUserAccount(
					).getTrackers().get(i).dayOfWeek, DashboardViewLogic.getDashboard().getUserAccount()
					.getTrackers().get(i).getWaterIntake()));
		}
		
		this.waterChart.getData().add(series);
		this.waterChart.setLegendVisible(false);
		this.waterChart.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
	}

	private void populateWeeksGoals() {
		this.goalList.clear();
		this.goalInformationBox.getChildren().clear();
		this.goalInformationBox.getChildren().addAll(this.weeklyGoalsLabel, this.goalLabel);
		if (DashboardViewLogic.getDashboard().getUserAccount().getTrackers()
				.get(DashboardViewLogic.getDashboard().getCurrentDayInt()).getGoals().size() > 0) {
			
			this.goalLabel.setVisible(false);

			for (int i = 0; i < this.goalList.size(); i++) {
				this.goalInformationBox.getChildren().remove(this.goalList.get(i));
			}

			for (int i = 0; i < DashboardViewLogic.getDashboard().getUserAccount().getTrackers()
					.get(DashboardViewLogic.getDashboard().getCurrentDayInt()).getGoals().size(); i++) {
				CheckBox box = new CheckBox();
				box.setText(DashboardViewLogic.getDashboard().getUserAccount().getTrackers()
						.get(DashboardViewLogic.getDashboard().getCurrentDayInt()).getGoals().get(i));
				goalList.add(box);
				VBox.setMargin(this.goalList.get(i), new Insets(0, 0, 0, 10));
				this.goalList.get(i).setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
			}

			for (int i = 0; i < this.goalList.size(); i++) {
				this.goalInformationBox.getChildren().add(this.goalList.get(i));
			}
		} else {
			this.goalLabel.setVisible(true);
		}
		adjustFontSize();
		assignSetOnActions();
	}

	public void updateUI() {
		this.userName.setText(DashboardViewLogic.getDashboard().getUserAccount().getFirstName() + " "
				+ DashboardViewLogic.getDashboard().getUserAccount().getLastName() + "'s Key2Keto Overview");
		
		this.upperHalf.getChildren().clear();
		this.lowerHalf.getChildren().clear();
		this.recipeInformationBox.getChildren().clear();
		
		populateDaysRecipes();
		populateSleepChart();
		populateWaterChart();
		populateWeeksGoals();
		this.recipeInformationBox.getChildren().addAll(this.todaysRecipeTitle, this.dietType, this.breakfastRecipe,
				this.lunchRecipe, this.dinnerRecipe, this.snackRecipe);
		this.upperHalf.getChildren().addAll(this.recipeInformationBox, this.goalInformationBox);
		this.lowerHalf.getChildren().addAll(this.waterChart, this.sleepChart);

	}
	private void adjustFontSize() {
		if (DashboardViewLogic.getDashboard().getUserAccount().getTrackers()
				.get(DashboardViewLogic.getDashboard().getCurrentDayInt()).getGoals().size() > 4) {
			for (int i = 0; i < this.goalList.size(); i++) {
				this.goalList.get(i).setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
			}
		}
	}

	@Override
	public void stylizeElements() {
		this.view.setPrefSize(980, 500);
		
		this.userName.setPrefWidth(980);
		this.userName.setAlignment(Pos.CENTER);
		this.userName.setId("UsernameField");
		this.dietType.setId("DashboardInfoLabels");
		
		this.todaysRecipeTitle.setPrefWidth(490);
		this.todaysRecipeTitle.setId("DashboardLabels");
		this.todaysRecipeTitle.setAlignment(Pos.CENTER);

		this.weeklyGoalsLabel.setPrefWidth(490);
		this.weeklyGoalsLabel.setId("DashboardLabels");
		this.weeklyGoalsLabel.setAlignment(Pos.CENTER);

		this.waterChart.setPrefHeight(315);
		this.sleepChart.setPrefHeight(315);
		this.waterChart.setPrefWidth(489);
		this.sleepChart.setPrefWidth(490);

		this.recipeInformationBox.setPrefWidth(490);
		VBox.setMargin(this.todaysRecipeTitle, new Insets(5, 0, 5, 0));
		VBox.setMargin(this.breakfastRecipe, new Insets(0, 0, 0, 5));
		VBox.setMargin(this.lunchRecipe, new Insets(0, 0, 0, 5));
		VBox.setMargin(this.dinnerRecipe, new Insets(0, 0, 0, 5));
		VBox.setMargin(this.snackRecipe, new Insets(0, 0, 0, 5));
		VBox.setMargin(this.dietType, new Insets(0, 0, 0, 5));
		
		this.breakfastRecipe.setId("DashboardInfoLabels");
		this.lunchRecipe.setId("DashboardInfoLabels");
		this.dinnerRecipe.setId("DashboardInfoLabels");
		this.snackRecipe.setId("DashboardInfoLabels");

		this.goalInformationBox.setPrefWidth(490);
		VBox.setMargin(this.weeklyGoalsLabel, new Insets(5, 0, 5, 0));
		this.goalLabel.setPrefWidth(490);
		this.goalLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.goalLabel.setAlignment(Pos.CENTER);
		this.goalLabel.setId("DashboardInfoLabels");
		
		this.upperHalf.setPrefSize(980, 155);
		this.upperHalf.setId("DashUpper");
		this.lowerHalf.setPrefSize(980, 315);
	}

	@Override
	public void assignSetOnActions() {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("GOAL COMPLETE! AWESOME JOB!!");
		a.setTitle(null);
		a.setGraphic(null);
		a.setHeaderText(null);
		if (this.goalList.size() > 0) {
			for (int i = 0; i < this.goalList.size(); i++) {
				this.goalList.get(i).setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						if (e.getSource() instanceof CheckBox) {
							CheckBox box = (CheckBox) e.getSource();
							if (box.isSelected()) {
								a.show();
							}
						}
						if (DashboardViewLogic.allGoalsCompleted(DashboardView.this.goalList)) {
							a.setContentText("ALL GOALS COMPLETED! AWESOME JOB!!");
							a.show();
						}
					}
				});
			}
		}
	}

	/*-------------------  METHODS USED FOR TESTING -------------------------*/
	protected Dashboard getDashboardForTest() {
		return DashboardViewLogic.getDashboard();
	}

	protected ArrayList<CheckBox> getCheckBoxToTest() {
		ArrayList<CheckBox> chBxToTest = new ArrayList<CheckBox>();

		for (int i = 0; i < this.goalList.size(); i++) {
			chBxToTest.addAll(new ArrayList<CheckBox>(Arrays.asList(this.goalList.get(i))));
		}
		return this.goalList;
	}

	protected ArrayList<Label> getLabelsToTest() {
		ArrayList<Label> labelsToTest = new ArrayList<Label>();

		labelsToTest.addAll(new ArrayList<Label>(
				Arrays.asList(this.breakfastRecipe, this.lunchRecipe, this.dinnerRecipe, this.snackRecipe)));

		return labelsToTest;
	}

	protected void addGoalTest(String goal, int day) {

	}
}