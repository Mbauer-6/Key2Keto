package application.Key2Keto.Tracker;

import java.util.ArrayList;
import java.util.Arrays;


import application.Key2Keto.Account.Account;
import application.Key2Keto.Interfaces.ViewInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DayView extends Pane implements ViewInterface{
	
	Tracker tracker;
	ConfirmPopUp popUp;
	int day;
	
	Spinner<Double> sleepField;
	Button sleepButton;
	Label sleepLabel;
	
	Spinner<Double> waterField;
	Button waterButton;
	Label waterLabel;
	
	TextField goalsTextField;
	Label goalsLabel;
	Button addGoalsButton;
	
	VBox sleepContent;
	VBox waterContent;
	VBox goalsContent;
	VBox wholeView;
	
	public DayView(String dayString, Account user){
		DayViewLogic.setDay(dayString);
		this.day = getIntFormOfDay(dayString);
		DayViewLogic.setUserAccount(user);
		
		initializeVariables();
		stylizeElements();
		assignSetOnActions();
		
		this.sleepField.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
		this.waterField.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
		
		populateChildren();
	}
	
	@Override
	public void initializeVariables() {
		this.tracker = new Tracker(DayViewLogic.getDayString());
		this.popUp = new ConfirmPopUp();
		
		this.wholeView = new VBox();
		this.sleepContent = new VBox();
		this.waterContent = new VBox();
		this.goalsContent = new VBox();
		
		this.sleepLabel = new Label("How many hours of sleep did you have today?");
		this.sleepField = new Spinner<Double>(0, 24, 0, 0.5);
		this.sleepField.setEditable(true);
		this.sleepButton = new Button("Save");
		
		this.waterLabel = new Label("How many ounces of water did you drink today?");
		this.waterField = new Spinner<Double>(0, 128, 0, 1.0);
		this.waterField.setEditable(true);
		this.waterButton = new Button("Save");
		
		this.goalsTextField = new TextField();
		this.goalsLabel = new Label("Add your own personalized goals here:");
		this.addGoalsButton = new Button("Add");
	}
	
	@Override
	public void stylizeElements() {
		
		this.sleepContent.setSpacing(10);
		this.waterContent.setSpacing(10);
		this.goalsContent.setSpacing(10);
		
		this.sleepContent.setPadding(new Insets(15,20, 10,10));
		this.waterContent.setPadding(new Insets(15,20, 10,10));
		this.goalsContent.setPadding(new Insets(15,20, 10,10));
		
		this.sleepLabel.setPrefSize(400, 30);
		this.sleepLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		this.waterLabel.setPrefSize(400, 30);
		this.waterLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		this.goalsLabel.setPrefSize(400, 30);
		this.goalsLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		
		this.sleepButton.setPrefSize(125, 30);
		this.sleepButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		this.waterButton.setPrefSize(125, 30);
		this.waterButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		this.addGoalsButton.setPrefSize(125, 30);
		this.addGoalsButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
	}
	
	@Override
	public void assignSetOnActions() {
		this.sleepButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	if(sleepField.getValue() != null) {
		    		tracker.setHoursOfSleep(Double.valueOf(sleepField.getValue()));
		    		DayViewLogic.getUserAccount().getTrackers().get(day).setHoursOfSleep(Double.valueOf(sleepField.getValue()));
		    		popUp.display();
		    	}
		    }
		});
		
		this.waterButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
			    if(waterField.getValue() != null) {
			    	tracker.setWaterIntake(Double.valueOf(waterField.getValue()));	
			    	DayViewLogic.getUserAccount().getTrackers().get(day).setWaterIntake(Double.valueOf(waterField.getValue()));
			    	popUp.display();
			    }
			   }
		});
			
		this.addGoalsButton.setOnAction(new EventHandler<ActionEvent>() {
		   @Override public void handle(ActionEvent e) {
		    if(!goalsTextField.getText().isEmpty()) {
		    	tracker.addGoal(goalsTextField.getText());
		    	DayViewLogic.getUserAccount().getTrackers().get(day).addGoal(goalsTextField.getText());
		    	goalsTextField.clear();
		    	popUp.display();
		    }
		   }
	    });
	}
	
	@Override
	public void populateChildren() {
		this.sleepContent.getChildren().addAll(this.sleepLabel, this.sleepField, this.sleepButton);
		this.waterContent.getChildren().addAll(this.waterLabel, this.waterField, this.waterButton);
		this.goalsContent.getChildren().addAll(this.goalsLabel, this.goalsTextField, this.addGoalsButton);
		this.wholeView.getChildren().addAll(this.sleepContent, this.waterContent, this.goalsContent);
		this.getChildren().add(wholeView);
	}
	
	public int getIntFormOfDay(String dayName) {
		int day = 0;
		switch(dayName) {
			case "Sunday":
				day = 0;
				break;
			case "Monday":
				day = 1;
				break;
			case "Tuesday":
				day = 2;
				break;
			case "Wednesday":
				day = 3;
				break;
			case "Thursday":
				day = 4;
				break;
			case "Friday":
				day = 5;
				break;
			case "Saturday":
				day = 5;
				break;
			default:
				System.out.println("This does not exist.");
		}
		return day;
	}
	
	/********* For testing purposes ***********/
	
	public String getDayOfWeek() {
		return DayViewLogic.getDayString();
	}
	
	public Spinner<Double> getSleepSpinnerForTest() {
		return this.sleepField;
	}
	
	public Double getSleepSpinnerValueForTest() {
		return Double.valueOf(this.sleepField.getValue());
	}
	
	public Spinner<Double> getWaterSpinnerForTest() {
		return this.waterField;
	}
	
	public Double getWaterSpinnerValueForTest() {
		return Double.valueOf(this.waterField.getValue());
	}
	
	public TextField getAddGoalsFieldForTest() {
		return this.goalsTextField;
	}
	
	public String getGoalsFieldValueForTest() {
		return this.tracker.getGoals().get(0);
	}
	
	public ArrayList<Button> getSaveButtonsToTest(){
		ArrayList<Button> buttonsToTest = new ArrayList<Button>();
		
		buttonsToTest.addAll(new ArrayList<Button>(Arrays.asList(this.sleepButton, this.waterButton, this.addGoalsButton)));
		
		return buttonsToTest;
	}
}