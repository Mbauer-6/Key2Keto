package application.Key2Keto.Tracker;

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

public class TrackerView extends Pane implements ViewInterface{
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
	private DayView days[];
	private DayView testDay;
	
	public TrackerView(Account user){
		TrackerViewLogic.setUserAccount(user);
		initializeVariables();
		populateDaysOfWeek();
		assignSetOnActions();
		populateChildren();
		stylizeElements();
	}
	
	@Override
	public void initializeVariables()
	{
		view = new VBox();
		categoryTabs = new HBox();
		sundayButton = new Button("SUNDAY");
		mondayButton = new Button("MONDAY");
		tuesdayButton = new Button("TUESDAY");
		wednesdayButton = new Button("WEDNESDAY");
		thursdayButton = new Button("THURSDAY");
		fridayButton = new Button("FRIDAY");
		saturdayButton = new Button("SATURDAY");
		daysOfWeek = new StackPane();
		days = new DayView[7];
	}
	
	@Override
	public void populateChildren() {
		categoryTabs.getChildren().addAll(sundayButton, mondayButton, tuesdayButton, wednesdayButton, thursdayButton, fridayButton, saturdayButton);
		daysOfWeek.getChildren().addAll(days[0],days[1],days[2],days[3],days[4],days[5],days[6]);
		view.getChildren().addAll(categoryTabs,daysOfWeek);
		
		this.getChildren().add(view);
	}
	
	@Override
	public void assignSetOnActions()
	{
		sundayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(0);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(0);
		    }
		});
		mondayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(1);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(1);
		    }
		});
		tuesdayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(2);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(2);
		    }
		});
		wednesdayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(3);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(3);
		    }
		});
		thursdayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(4);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(4);
		    }
		});
		fridayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(5);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(5);
		    }
		});
		saturdayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(6);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(6);
		    }
		});
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
		days[0] = new DayView("Sunday", TrackerViewLogic.getUserAccount());
		days[1] = new DayView("Monday", TrackerViewLogic.getUserAccount());
		days[2] = new DayView("Tuesday", TrackerViewLogic.getUserAccount());
		days[3] = new DayView("Wednesday", TrackerViewLogic.getUserAccount());
		days[4] = new DayView("Thursday", TrackerViewLogic.getUserAccount());
		days[5] = new DayView("Friday", TrackerViewLogic.getUserAccount());
		days[6] = new DayView("Saturday", TrackerViewLogic.getUserAccount());
	}
	
	protected void setDayStack(int num) {
		for(int i = 0; i < 7; i++) {
			if(num == i) {
				days[i].setViewOrder(-1);
				setViewForTest(days[i]);
			}else {
				days[i].setViewOrder(0);
			}
		}
	}
	
	protected ArrayList<Button> getButtonsToTest(){
		ArrayList<Button> buttonsToTest = new ArrayList<Button>();
		
		buttonsToTest.addAll(new ArrayList<Button>(Arrays.asList(this.sundayButton, this.mondayButton, this.tuesdayButton,
				this.wednesdayButton, this.thursdayButton, this.fridayButton, this.saturdayButton)));
		
		return buttonsToTest;
	}
	
	protected DayView getViewForTest(){		
		return this.testDay;
	}
	
	protected void setViewForTest(DayView day) {
		this.testDay = day;
	}
	
	
}
