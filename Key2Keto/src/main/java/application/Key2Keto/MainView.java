package application.Key2Keto;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Account.AccountSaver;
import application.Key2Keto.Account.AccountView;
import application.Key2Keto.Dashboard.*;
import application.Key2Keto.Recipes.RecipeView;
import application.Key2Keto.Shopping.ShoppingView;
import application.Key2Keto.Tracker.TrackerView;

public class MainView extends Pane{
	Account user;
  
	private Stage stage;
	private SceneSwitcher switcher;
	
  VBox view;
	HBox labels;
	private Button dash;
	private Button account;
	private Button tracker;
	private Button shopping;
	private Button recipes;
	private Button logout;
	private StackPane mainContent;
	private RecipeView recipeView;
	private AccountView accountView;
	private TrackerView trackerView;
	private DashboardView dashboardView;
	private ShoppingView shoppingView;
	Label title;
	String currentTab;
	

	public MainView(Account user, Stage stage) {

		this.user = user;
		
		this.stage = stage;
		switcher = new SceneSwitcher(stage);
		
		InitializeVariables();
		StylizeElements();
		AddAllElementsToChildren();
		
	
		this.recipes.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder(0);
		    	currentTab = "Recipe";
		    }
		});
		
		this.dash.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder(1);
		    	currentTab = "Dashboard";
		    }
		});
		
		this.account.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder(2);
		    	currentTab = "MyAccount";
		    }
		});
		
		this.tracker.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder(3);
		    	currentTab = "Tracker";
		    }
		});
		
		this.shopping.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder(4);
		    	currentTab = "Shopping";
		    }
		});
		
		this.logout.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder(5);
		    	currentTab = "Logout";
		    }
		});
}
	public Account getAccount() {
		return this.user;
	}
	
	private void InitializeVariables(){
	    view = new VBox();
		labels = new HBox();
		dash = new Button("DASHBOARD");
		account = new Button("MY ACCOUNT");
		tracker = new Button("TRACKER");
		shopping = new Button("SHOPPING");
		recipes = new Button("RECIPES");
		logout = new Button("LOG OUT");
		mainContent = new StackPane();
		recipeView = new RecipeView(this.user);
		accountView = new AccountView(this.user);
		trackerView = new TrackerView(this.user);
		dashboardView = new DashboardView(this.user);
		shoppingView = new ShoppingView(this.user);
		title = new Label("KEY2KETO");
		currentTab = "";
	}

	private void StylizeElements(){
		title.setId("title");
		
		view.setPrefSize(1000, 750);
		VBox.setMargin(labels, new Insets(0, 10, 0, 10));
		VBox.setMargin(this.mainContent, new Insets(5, 10, 5, 10));
		VBox.setMargin(title, new Insets(5, 10, 5, 10));
		view.setId("WholeMainPane");
		
		labels.setPrefSize(1000, 75);
		labels.setSpacing(12);
		labels.setAlignment(Pos.CENTER);
		labels.setId("MainTabsBox");
		
		dash.setPrefSize(129, 45);
		dash.setId("MainTabs");
		
		account.setPrefSize(129, 45);
		account.setId("MainTabs");
		
		tracker.setPrefSize(129, 45);
		tracker.setId("MainTabs");
		
		shopping.setPrefSize(129, 45);
		shopping.setId("MainTabs");
		
		recipes.setPrefSize(129, 45);
		recipes.setId("MainTabs");
		
		logout.setPrefSize(129, 45);
		logout.setId("MainTabs");
		
		view.setAlignment(Pos.CENTER);
	}
	
	private void AddAllElementsToChildren(){
		labels.getChildren().addAll(dash,account,tracker,shopping,recipes,logout);
		view.getChildren().addAll(title,labels, mainContent);
		this.mainContent.getChildren().addAll(recipeView,accountView, dashboardView, trackerView,shoppingView);
		this.mainContent.setVisible(false);
	}

	public void stackOrder(int num){
		switch(num) {
			case 0: //Switch to Recipe tab
				this.mainContent.setVisible(true);
				this.dashboardView.setVisible(false);
				this.accountView.setVisible(false);
				this.recipeView.setVisible(true);
				this.trackerView.setVisible(false);
				this.shoppingView.setVisible(false);
				
				this.recipeView.setViewOrder(-1);
				this.dashboardView.setViewOrder(0);
				this.accountView.setViewOrder(0);
				this.trackerView.setViewOrder(0);
				this.shoppingView.setViewOrder(0);
				break;
				
			case 1: //Switch to Dashboard tab
				this.mainContent.setVisible(true);
				this.dashboardView.setVisible(true);
				this.accountView.setVisible(false);
				this.recipeView.setVisible(false);
				this.trackerView.setVisible(false);
				this.shoppingView.setVisible(false);
				this.dashboardView.updateUI();

				this.recipeView.setViewOrder(0);
				this.dashboardView.setViewOrder(-1);
				this.accountView.setViewOrder(0);
				this.trackerView.setViewOrder(0);
				this.shoppingView.setViewOrder(0);
			
				break;
			case 2: //Switch to Account tab
				this.mainContent.setVisible(true);
				this.recipeView.setViewOrder(0);
				this.dashboardView.setViewOrder(0);
				this.accountView.setViewOrder(-1);
				this.trackerView.setViewOrder(0);
				this.shoppingView.setViewOrder(0);
			
				this.dashboardView.setVisible(false);
				this.accountView.setVisible(true);
				this.recipeView.setVisible(false);
				this.shoppingView.setVisible(false);
				this.trackerView.setVisible(false);
				break;
				
			case 3: //Switch to tracker tab
				this.mainContent.setVisible(true);
				this.recipeView.setViewOrder(0);
				this.dashboardView.setViewOrder(0);
				this.accountView.setViewOrder(0);
				this.shoppingView.setViewOrder(0);
				this.trackerView.setViewOrder(-1);
			
				this.dashboardView.setVisible(false);
				this.accountView.setVisible(false);
				this.recipeView.setVisible(false);
				this.shoppingView.setVisible(false);
				this.trackerView.setVisible(true);
				break;
				
			case 4: //Switch to ShoppingView
				this.mainContent.setVisible(true);
				this.recipeView.setViewOrder(0);
				this.dashboardView.setViewOrder(0);
				this.accountView.setViewOrder(0);
				this.trackerView.setViewOrder(0);
				this.shoppingView.setViewOrder(-1);
				this.shoppingView.updateUI();
				
				this.dashboardView.setVisible(false);
				this.accountView.setVisible(false);
				this.recipeView.setVisible(false);
				this.trackerView.setVisible(false);
				this.shoppingView.setVisible(true);
				break;
				
			case 5:
				Stage logoutConfirmation = new Stage();
				
				VBox confirmationRows = new VBox();
				HBox confirmationLabelRow = new HBox();
				Label confirmationLabel = new Label("Are you sure you want to log out?");
				confirmationLabelRow.setAlignment(Pos.CENTER);
				HBox.setMargin(confirmationLabel, new Insets(50, 20, 50, 20));
				confirmationLabel.setFont(Font.font("Verdana", 14));
				HBox confirmationButtonsRow = new HBox();
				confirmationButtonsRow.setAlignment(Pos.CENTER);
				Button yesButton = new Button("Yes");
				Button noButton = new Button("No");
				HBox.setMargin(yesButton, new Insets(0, 20, 20, 20));
				HBox.setMargin(noButton, new Insets(0, 20, 20, 20));
				yesButton.setFont(Font.font("Verdana", 14));
				noButton.setFont(Font.font("Verdana", 14));
				confirmationLabelRow.getChildren().add(confirmationLabel);
				confirmationButtonsRow.getChildren().addAll(yesButton, noButton);
				confirmationRows.getChildren().addAll(confirmationLabelRow, confirmationButtonsRow);
				
				yesButton.setOnAction(e ->
				{
					AccountSaver.saveAccount(user);
					logoutConfirmation.close();
					this.stage.setScene(this.switcher.LoginScene());
				});
				
				noButton.setOnAction(e ->
				{
					logoutConfirmation.close();
				});
				
				logoutConfirmation.setScene(new Scene(confirmationRows));
				logoutConfirmation.show();
				break;
			default:
				System.out.println("You should not get here");
		}	
	}
	
	public VBox getView() {
		return this.view;
	}
	
	public String getCurrentTab() {
		return this.currentTab;
	}
	
	public ArrayList<Button> getButtonsToTest(){
		ArrayList<Button> buttonsToTest = new ArrayList<Button>();
		
		buttonsToTest.addAll(new ArrayList<Button>(Arrays.asList(this.dash, this.account, this.tracker,
							this.shopping, this.recipes, this.logout)));
		
		return buttonsToTest;
	}
}