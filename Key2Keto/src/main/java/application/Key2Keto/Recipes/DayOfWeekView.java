package application.Key2Keto.Recipes;

import java.util.ArrayList;
import java.util.Arrays;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Interfaces.ViewInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DayOfWeekView extends Pane implements ViewInterface {
	private String name;
	private RecipeDetailView recipeDetailView;
	private int day = 0;
	private boolean flag = false;
	private VBox wholeView;
	private VBox selectedRecipes;
	private VBox recipeDetails;
	private HBox bottomRecipeInfo;
	private HBox categorySelection;
	private HBox breakfastInfo;
	private HBox lunchInfo;
	private HBox dinnerInfo;
	private HBox snackInfo;
	private HBox addRecipeDropdown;
	private VBox confirmationBox;

	// selected recipe names
	private Label breakfastRecipeName;
	private Label lunchRecipeName;
	private Label dinnerRecipeName;
	private Label snackRecipeName;
	private Label daysRecipesLabel;
	// ComboBox variables
	private ComboBox<String> comboBox;
	private Button addRecipeButton;

	// category Buttons
	private Button overViewButton;
	private Button breakfastButton;
	private Button entreesButton;
	private Button snacksButton;

	// delete recipe Buttons
	private Button deleteBreakfastButton;
	private Button deleteLunchButton;
	private Button deleteDinnerButton;
	private Button deleteSnackButton;

	// confirm Recipes Button
	private Button confirmRecipeSelection;
	private Label confirmLabel;
	private StackPane confirm;

	public DayOfWeekView(RecipeList recipeList, String name, Account user, int day) {
		this.name = name;
		this.day = day;

		DayOfWeekLogic.setUserAccount(user);
		DayOfWeekLogic.addRecipeListToClass(recipeList);
		initializeVariables();
		stylizeElements();
		populateChildren();
		setDefaultVisibilities();
		assignSetOnActions();
	}

	public String getName() {
		return this.name;
	}

	public RecipeDetailView getDetailView() {
		return this.recipeDetailView;
	}

	private void setButtonCLickedColor(int num) {
		Button temp[] = new Button[4];
		temp[0] = this.overViewButton;
		temp[1] = this.breakfastButton;
		temp[2] = this.entreesButton;
		temp[3] = this.snacksButton;

		for(int i = 0; i < 4; i++) {
			if(num == i) {
				temp[i].setId("DayOfWeekClicked");
			}else {
				temp[i].setId("DayOfWeekNotClicked");
			}
		}
	}

	private void disPlayViewsRecipes(int day) {
		
		this.breakfastRecipeName.setVisible(true);
		this.lunchRecipeName.setVisible(true);
		this.dinnerRecipeName.setVisible(true);
		this.snackRecipeName.setVisible(true);
		this.deleteBreakfastButton.setVisible(true);
		this.deleteLunchButton.setVisible(true);
		this.deleteDinnerButton.setVisible(true);
		this.deleteSnackButton.setVisible(true);
	}

	@Override
	public void populateChildren() {
		this.confirmationBox.getChildren().addAll(this.confirmLabel, this.confirmRecipeSelection);
		this.confirm.getChildren().addAll(this.confirmationBox, this.recipeDetails);
		// adding catgoryButtons tabs
		this.categorySelection.getChildren().addAll(this.overViewButton, this.breakfastButton, this.entreesButton,
				this.snacksButton);
		// adding recipe names and delete buttons to selectedRecipes section
		this.breakfastInfo.getChildren().addAll(this.breakfastRecipeName, this.deleteBreakfastButton);
		this.lunchInfo.getChildren().addAll(this.lunchRecipeName, this.deleteLunchButton);
		this.dinnerInfo.getChildren().addAll(this.dinnerRecipeName, this.deleteDinnerButton);
		this.snackInfo.getChildren().addAll(this.snackRecipeName, this.deleteSnackButton);
		this.selectedRecipes.getChildren().addAll(this.daysRecipesLabel, this.breakfastInfo, this.lunchInfo,
				this.dinnerInfo, this.snackInfo);
		// adding selected recipes and recipe details
		this.bottomRecipeInfo.getChildren().addAll(this.selectedRecipes, this.confirm);
		// adding ComboBox and Add button to addRecipeDropDown section
		this.addRecipeDropdown.getChildren().addAll(this.comboBox, this.addRecipeButton);
		// add all components to the view
		this.wholeView.getChildren().addAll(this.categorySelection, this.addRecipeDropdown, this.bottomRecipeInfo);
		// add the view to the class
		this.getChildren().add(wholeView);
	}

	@Override
	public void stylizeElements() {
		//wholeView styling
		this.wholeView.setPrefSize(980, 500);
		VBox.setMargin(selectedRecipes, new Insets(0, 10, 0, 10));
		
		//this.categorySelection
		this.categorySelection.setPrefSize(980, 75);
		this.categorySelection.setAlignment(Pos.CENTER);
		this.categorySelection.setId("RecipeCategoryBox");
		HBox.setMargin(overViewButton, new Insets(10, 5, 10, 0));
		HBox.setMargin(breakfastButton, new Insets(10, 5, 10, 5));
		HBox.setMargin(entreesButton, new Insets(10, 5, 10, 5));
		HBox.setMargin(snacksButton, new Insets(10, 5, 10, 5));
		
		this.overViewButton.setPrefSize(125, 50);
		this.breakfastButton.setPrefSize(125, 50);
		this.entreesButton.setPrefSize(125, 50);
		this.snacksButton.setPrefSize(125, 50);
		
		this.selectedRecipes.setPrefSize(480, 385);
		this.selectedRecipes.setAlignment(Pos.CENTER);
		
		this.daysRecipesLabel.setPrefSize(500, 75);
		this.daysRecipesLabel.setId("RecipeCategoryBox");
		this.daysRecipesLabel.setAlignment(Pos.CENTER);
		
		this.breakfastInfo.setPrefSize(500, 75);
		HBox.setMargin(this.breakfastRecipeName, new Insets(10, 5, 10, 5));
		HBox.setMargin(this.deleteBreakfastButton, new Insets(15, 5, 10, 5));
		this.breakfastInfo.setId("DarkRows");
		
		this.lunchInfo.setPrefSize(500, 75);
		this.lunchInfo.setId("LightRows");
		HBox.setMargin(this.lunchRecipeName, new Insets(10, 5, 10, 5));
		HBox.setMargin(this.deleteLunchButton, new Insets(15, 5, 10, 5));
		
		this.dinnerInfo.setPrefSize(500, 75);
		this.dinnerInfo.setId("DarkRows");
		HBox.setMargin(this.dinnerRecipeName, new Insets(10, 5, 10, 5));
		HBox.setMargin(this.deleteDinnerButton, new Insets(15, 5, 10, 5));
		
		this.snackInfo.setPrefSize(500, 75);
		this.snackInfo.setId("LightRows");
		HBox.setMargin(this.snackRecipeName, new Insets(10, 5, 10, 5));
		HBox.setMargin(this.deleteSnackButton, new Insets(15, 5, 10, 5));
		
		this.breakfastRecipeName.setPrefSize(350, 65);
		this.breakfastRecipeName.setFont(Font.font(16));
		this.deleteBreakfastButton.setPrefSize(75, 40);
		this.deleteBreakfastButton.setId("DeleteButtons");
		
		this.lunchRecipeName.setPrefSize(350, 65);
		this.lunchRecipeName.setFont(Font.font(16));
		this.deleteLunchButton.setPrefSize(75, 40);
		this.deleteLunchButton.setId("DeleteButtons");
		
		this.dinnerRecipeName.setPrefSize(350, 65);
		this.dinnerRecipeName.setFont(Font.font(16));
		this.deleteDinnerButton.setPrefSize(75, 40);
		this.deleteDinnerButton.setId("DeleteButtons");
		
		this.snackRecipeName.setPrefSize(350, 65);
		this.snackRecipeName.setFont(Font.font(16));
		this.deleteSnackButton.setPrefSize(75, 40);
		this.deleteSnackButton.setId("DeleteButtons");
		
		this.addRecipeDropdown.setPrefSize(980, 35);
		this.addRecipeDropdown.setAlignment(Pos.CENTER);
		this.addRecipeDropdown.setId("RecipeCategoryBox");
		HBox.setMargin(this.comboBox, new Insets(5, 5, 5, 5));
		HBox.setMargin(this.addRecipeButton, new Insets(5, 5, 5, 5));
		
		this.comboBox.setPrefSize(420, 35);
		this.comboBox.setPromptText("--- Select a Recipe ---");
		this.comboBox.setEditable(true);
		this.addRecipeButton.setPrefSize(75, 35);
		
		this.bottomRecipeInfo.setPrefSize(490, 400);
		this.confirm.setPrefSize(490, 400);
		StackPane.setMargin(this.confirmationBox, new Insets(10, 10, 10, 10));
		this.confirm.setAlignment(Pos.CENTER);
		this.confirmLabel.setPrefSize(480, 100);
		this.confirmLabel.setWrapText(true);
		this.confirmLabel.setAlignment(Pos.CENTER);
		this.confirmationBox.setAlignment(Pos.CENTER);
		this.confirmationBox.setId("WholeMainPane");
		this.confirmRecipeSelection.setPrefSize(100, 50);
		this.confirmRecipeSelection.setAlignment(Pos.CENTER);
	}

	private void setDefaultVisibilities() {
		if (DayOfWeekLogic.getDaysRecipes(this.day).size() > 0) {
			this.breakfastRecipeName.setVisible(true);
			this.lunchRecipeName.setVisible(true);
			this.dinnerRecipeName.setVisible(true);
			this.snackRecipeName.setVisible(true);
		} else {
			this.breakfastRecipeName.setVisible(false);
			this.deleteBreakfastButton.setVisible(false);
			this.lunchRecipeName.setVisible(false);
			this.deleteLunchButton.setVisible(false);
			this.dinnerRecipeName.setVisible(false);
			this.deleteDinnerButton.setVisible(false);
			this.snackRecipeName.setVisible(false);
			this.deleteSnackButton.setVisible(false);
		}
		this.comboBox.setVisible(false);
		this.addRecipeButton.setVisible(false);
		flag = true;
	}

	@Override
	public void initializeVariables() {
		this.wholeView = new VBox();
		this.selectedRecipes = new VBox();
		this.recipeDetails = new VBox();
		this.confirm = new StackPane();
		this.confirmationBox = new VBox();
		this.confirmLabel = new Label("Click Confirm to add the " + "Chosen Recipes to your Dashboard");
		this.confirmRecipeSelection = new Button("CONFIRM");
		this.bottomRecipeInfo = new HBox();
		this.categorySelection = new HBox();
		this.breakfastInfo = new HBox();
		this.lunchInfo = new HBox();
		this.dinnerInfo = new HBox();
		this.snackInfo = new HBox();
		this.addRecipeDropdown = new HBox();
		this.breakfastRecipeName = new Label("No Breakfast Chosen");
		this.lunchRecipeName = new Label("No Lunch Chosen");
		this.dinnerRecipeName = new Label("No Dinner Chosen");
		this.snackRecipeName = new Label("No Snack Chosen");
		this.daysRecipesLabel = new Label("CHOSEN RECIPES");
		this.comboBox = new ComboBox<String>();
		this.overViewButton = new Button("OVERVIEW");
		this.breakfastButton = new Button("BREAKFAST");
		this.entreesButton = new Button("ENTREES");
		this.snacksButton = new Button("SNACKS");
		this.addRecipeButton = new Button("ADD");
		this.deleteBreakfastButton = new Button("DELETE");
		this.deleteLunchButton = new Button("DELETE");
		this.deleteDinnerButton = new Button("DELETE");
		this.deleteSnackButton = new Button("DELETE");
	}

	protected void populateComboBox(int num) {
		if (flag) {
			this.comboBox.setVisible(true);
			this.addRecipeButton.setVisible(true);
		} else {
			flag = false;
		}

		comboBox.getItems().clear();
		
		switch (num) {
		case 0:
			comboBox.getItems().addAll(DayOfWeekLogic.getBreakfastRecipes());
			comboBox.setVisible(true);
			break;
		case 1:
			comboBox.getItems().addAll(DayOfWeekLogic.getEntreeRecipes());
			comboBox.setVisible(true);
			break;
		case 2:
			comboBox.getItems().addAll(DayOfWeekLogic.getSnackRecipes());
			comboBox.setVisible(true);
			break;
		default:
			System.out.println("Something is wrong here");
		}
	}

	public ArrayList<Recipe> getSelectedRecipes() {
		return DayOfWeekLogic.getDaysRecipes(day);
	}

	@Override
	public void assignSetOnActions() {
		overViewButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				comboBox.setVisible(false);
				DayOfWeekView.this.addRecipeButton.setVisible(false);
				DayOfWeekView.this.recipeDetails.setViewOrder(0);
				DayOfWeekView.this.confirmationBox.setViewOrder(-1);
				DayOfWeekView.this.confirmationBox.setVisible(true);
				DayOfWeekView.this.recipeDetails.setVisible(false);
				disPlayViewsRecipes(DayOfWeekView.this.day);
				setButtonCLickedColor(0);
			}
		});

		breakfastButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				populateComboBox(0);
				DayOfWeekView.this.comboBox.setPromptText("--- Select a Recipe ---");
				DayOfWeekView.this.recipeDetails.setViewOrder(-1);
				DayOfWeekView.this.confirmationBox.setViewOrder(0);
				DayOfWeekView.this.confirmationBox.setVisible(false);
				DayOfWeekView.this.recipeDetails.setVisible(true);
				setButtonCLickedColor(1);
			}
		});
		entreesButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				populateComboBox(1);
				DayOfWeekView.this.comboBox.setPromptText("--- Select a Recipe ---");
				DayOfWeekView.this.recipeDetails.setViewOrder(-1);
				DayOfWeekView.this.confirmationBox.setViewOrder(0);
				DayOfWeekView.this.confirmationBox.setVisible(false);
				DayOfWeekView.this.recipeDetails.setVisible(true);
				setButtonCLickedColor(2);
			}
		});
		snacksButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				populateComboBox(2);
				DayOfWeekView.this.comboBox.setPromptText("--- Select a Recipe ---");
				DayOfWeekView.this.recipeDetails.setViewOrder(-1);
				DayOfWeekView.this.confirmationBox.setViewOrder(0);
				DayOfWeekView.this.confirmationBox.setVisible(false);
				DayOfWeekView.this.recipeDetails.setVisible(true);
				setButtonCLickedColor(3);
			}
		});

		deleteBreakfastButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				DayOfWeekView.this.breakfastRecipeName.setText("No Breakfast Chosen");
			}
		});

		deleteLunchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				DayOfWeekView.this.lunchRecipeName.setText("No Lunch Chosen");	
			}
		});

		deleteDinnerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				DayOfWeekView.this.dinnerRecipeName.setText("No Dinner Chosen");
			}
		});

		deleteSnackButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				DayOfWeekView.this.snackRecipeName.setText("No Snack Chosen");
			}
		});

		addRecipeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String selected = "";
				if (DayOfWeekView.this.comboBox.getValue() == null) {
					System.out.println("No String Entered");
				} else {
					selected = DayOfWeekView.this.comboBox.getValue().toString();
				}
				if(DayOfWeekView.this.breakfastButton.getId().contentEquals("DayOfWeekClicked")) {
					DayOfWeekView.this.breakfastRecipeName.setText(selected);
				}else if(DayOfWeekView.this.entreesButton.getId().contentEquals("DayOfWeekClicked") && DayOfWeekView.this.lunchRecipeName.getText().contentEquals("No Lunch Chosen")) {
					DayOfWeekView.this.lunchRecipeName.setText(selected);
				}else if(DayOfWeekView.this.entreesButton.getId().contentEquals("DayOfWeekClicked") 
						&& DayOfWeekView.this.dinnerRecipeName.getText().contentEquals("No Dinner Chosen")) {
					DayOfWeekView.this.dinnerRecipeName.setText(selected);
				}else if(DayOfWeekView.this.snacksButton.getId().contentEquals("DayOfWeekClicked")){
					DayOfWeekView.this.snackRecipeName.setText(selected);
				}	
				disPlayViewsRecipes(DayOfWeekView.this.day);
			}
			
		});

		confirmRecipeSelection.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {				
				ArrayList<String> chosen = new ArrayList<String>();
				
				chosen.add(DayOfWeekView.this.breakfastRecipeName.getText());
				chosen.add(DayOfWeekView.this.lunchRecipeName.getText());
				chosen.add(DayOfWeekView.this.dinnerRecipeName.getText());
				chosen.add(DayOfWeekView.this.snackRecipeName.getText());
				
				DayOfWeekLogic.addToUsersChosenRecipes(chosen, day);
			}
		});

		this.comboBox.setOnAction(e -> {
			DayOfWeekView.this.recipeDetails.getChildren().clear();
			String recipe = "";
			if (this.comboBox.getValue() != null) {
				recipe = this.comboBox.getValue().toString();
				for (int i = 0; i < DayOfWeekLogic.getRecipeList().getRecipeList().size(); i++) {
					if (recipe.contentEquals(DayOfWeekLogic.getRecipeList().getRecipeList().get(i).getName())) {
						ScrollPane scrollPane = new ScrollPane();
						scrollPane.setPrefWidth(500);
						scrollPane.setMaxHeight(375);
						DayOfWeekView.this.recipeDetailView = new RecipeDetailView(
								DayOfWeekLogic.getRecipeList().getRecipeList().get(i));
						scrollPane.setContent(DayOfWeekView.this.recipeDetailView);
						DayOfWeekView.this.recipeDetails.getChildren().add(scrollPane);
						DayOfWeekView.this.recipeDetails.setViewOrder(-1);
						DayOfWeekView.this.confirmationBox.setViewOrder(0);
						VBox.setMargin(scrollPane, new Insets(10, 0, 0, 10));
					}
				}

			}
		});
	}

	// Methods needed for testing purposes
	protected ComboBox<String> getComboBoxForTest() {
		return this.comboBox;
	}

	protected ArrayList<Button> getButtonsToTest() {
		ArrayList<Button> buttonsToTest = new ArrayList<Button>();
		buttonsToTest.addAll(new ArrayList<Button>(Arrays.asList(this.breakfastButton, this.entreesButton,
				this.snacksButton, this.deleteBreakfastButton, this.deleteLunchButton, this.deleteDinnerButton,
				this.deleteSnackButton, this.addRecipeButton)));

		return buttonsToTest;
	}

	protected ArrayList<Label> getLabels() {
		ArrayList<Label> labelsToTest = new ArrayList<Label>();
		labelsToTest.addAll(new ArrayList<Label>(Arrays.asList(this.breakfastRecipeName, this.lunchRecipeName,
				this.dinnerRecipeName, this.snackRecipeName)));

		return labelsToTest;
	}
}