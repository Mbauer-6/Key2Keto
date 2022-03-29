package application.Key2Keto.Recipes;

import java.util.ArrayList;
import java.util.Arrays;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Interfaces.ViewInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class RecipeView extends Pane implements ViewInterface {
	private VBox view;
	private HBox categoryTabs;
	private Button sundayButton;
	private Button mondayButton;
	private Button tuesdayButton;
	private Button wednesdayButton;
	private Button thursdayButton;
	private Button fridayButton;
	private Button saturdayButton;
	private StackPane daysOfWeek;
	private DayOfWeekView days[];
	private DayOfWeekView testDay;

	public RecipeView(Account userAccount) {
		RecipeViewLogic.setUserAccount(userAccount);
		String file = "./src/main/java/application/Key2Keto/Recipes/"
				+ getDietTypeString(RecipeViewLogic.getUserAccount().getDietType()) + "Keto.txt";
		RecipeViewLogic.setFileReader(file);
		initializeVariables();
		populateDaysOfWeek();
		populateChildren();
		stylizeElements();
		assignSetOnActions();

		this.getChildren().add(view);
	}

	private String getDietTypeString(String str) {
		String[] type = str.split(" ");
		return type[0];
	}

	@Override
	public void populateChildren() {
		categoryTabs.getChildren().addAll(sundayButton, mondayButton, tuesdayButton, wednesdayButton, thursdayButton,
				fridayButton, saturdayButton);
		daysOfWeek.getChildren().addAll(days[0], days[1], days[2], days[3], days[4], days[5], days[6]);
		view.getChildren().addAll(categoryTabs, daysOfWeek);
	}

	@Override
	public void stylizeElements() {
		this.setWidth(980);
		this.setHeight(500);
		view.setPrefHeight(500);
		view.setPrefWidth(980);
		this.categoryTabs.setPrefSize(600, 50);
		this.categoryTabs.setSpacing(12);
		this.sundayButton.setPrefSize(129, 45);
		this.mondayButton.setPrefSize(129, 45);
		this.tuesdayButton.setPrefSize(129, 45);
		this.wednesdayButton.setPrefSize(129, 45);
		this.thursdayButton.setPrefSize(129, 45);
		this.fridayButton.setPrefSize(129, 45);
		this.saturdayButton.setPrefSize(129, 45);
		this.daysOfWeek.setPrefSize(600, 440);
		daysOfWeek.setVisible(false);
	}

	private void setButtonCLickedColor(int num) {
		Button temp[] = new Button[7];
		temp[0] = this.sundayButton;
		temp[1] = this.mondayButton;
		temp[2] = this.tuesdayButton;
		temp[3] = this.wednesdayButton;
		temp[4] = this.thursdayButton;
		temp[5] = this.fridayButton;
		temp[6] = this.saturdayButton;

		for(int i = 0; i < 7; i++) {
			if(num == i) {
				temp[i].setId("DayOfWeekClicked");
			}else {
				temp[i].setId("DayOfWeekNotClicked");
			}
		}
	}

	private void populateDaysOfWeek() {		
		days[0] = new DayOfWeekView(RecipeViewLogic.getFileReader().getRecipeList(), "Sunday", RecipeViewLogic.getUserAccount(),0);
		days[1] = new DayOfWeekView(RecipeViewLogic.getFileReader().getRecipeList(), "Monday", RecipeViewLogic.getUserAccount(),1);
		days[2] = new DayOfWeekView(RecipeViewLogic.getFileReader().getRecipeList(), "Tuesday", RecipeViewLogic.getUserAccount(),2);
		days[3] = new DayOfWeekView(RecipeViewLogic.getFileReader().getRecipeList(), "Wednesday", RecipeViewLogic.getUserAccount(),3);
		days[4] = new DayOfWeekView(RecipeViewLogic.getFileReader().getRecipeList(), "Thursday", RecipeViewLogic.getUserAccount(),4);
		days[5] = new DayOfWeekView(RecipeViewLogic.getFileReader().getRecipeList(), "Friday", RecipeViewLogic.getUserAccount(),5);
		days[6] = new DayOfWeekView(RecipeViewLogic.getFileReader().getRecipeList(), "Saturday", RecipeViewLogic.getUserAccount(),6);
	}

	protected void setDayStack(int num) {
		for (int i = 0; i < 7; i++) {
			if (num == i) {
				days[i].setViewOrder(-1);
				setViewForTest(days[i]);
			} else {
				days[i].setViewOrder(0);
			}
		}
	}

	@Override
	public void initializeVariables() {
		this.view = new VBox();
		this.categoryTabs = new HBox();
		this.sundayButton = new Button("SUNDAY");
		this.mondayButton = new Button("MONDAY");
		this.tuesdayButton = new Button("TUESDAY");
		this.wednesdayButton = new Button("WEDNESDAY");
		this.thursdayButton = new Button("THURSDAY");
		this.fridayButton = new Button("FRIDAY");
		this.saturdayButton = new Button("SATURDAY");
		this.daysOfWeek = new StackPane();
		this.days = new DayOfWeekView[7];

	}

	@Override
	public void assignSetOnActions() {
		sundayButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setButtonCLickedColor(0);
				daysOfWeek.setVisible(true);
				setDayStack(0);
			}
		});
		mondayButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setButtonCLickedColor(1);
				daysOfWeek.setVisible(true);
				setDayStack(1);
			}
		});
		tuesdayButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setButtonCLickedColor(2);
				daysOfWeek.setVisible(true);
				setDayStack(2);
			}
		});
		wednesdayButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setButtonCLickedColor(3);
				daysOfWeek.setVisible(true);
				setDayStack(3);
			}
		});
		thursdayButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setButtonCLickedColor(4);
				daysOfWeek.setVisible(true);
				setDayStack(4);
			}
		});
		fridayButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setButtonCLickedColor(5);
				daysOfWeek.setVisible(true);
				setDayStack(5);
			}
		});
		saturdayButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setButtonCLickedColor(6);
				daysOfWeek.setVisible(true);
				setDayStack(6);
			}
		});

	}

	/* --------- METHODS BELOW FOR TESTING ---------- */
	public DayOfWeekView[] getdays() {
		return this.days;
	}

	protected ArrayList<Button> getButtonsToTest() {
		ArrayList<Button> buttonsToTest = new ArrayList<Button>();

		buttonsToTest
				.addAll(new ArrayList<Button>(Arrays.asList(this.sundayButton, this.mondayButton, this.tuesdayButton,
						this.wednesdayButton, this.thursdayButton, this.fridayButton, this.saturdayButton)));

		return buttonsToTest;
	}

	protected DayOfWeekView getViewForTest() {
		return this.testDay;
	}

	protected void setViewForTest(DayOfWeekView day) {
		this.testDay = day;
	}

}