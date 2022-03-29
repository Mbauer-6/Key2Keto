package application.Key2Keto.Tracker;

import javafx.scene.Scene;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import application.Key2Keto.Account.Account;

public class DayViewTest extends ApplicationTest{
	
	DayView sut;
	
	@Override
	public void start(Stage stage){
		
		sut = new DayView("", new Account("username123", "password123", "John", "McLastname", "Male", "5'9\"", 190, 24, "Classic"));
		
		Scene dayScene = new Scene(sut);
		stage.setScene(dayScene);
		stage.show();	
	}
	
	@Test
	public void TestSleepSpinner() {
		clickOn(sut.getSleepSpinnerForTest());
		eraseText(1);
		write("7.5");
		clickOn(sut.getSaveButtonsToTest().get(0));
		assertEquals(7.5, sut.getSleepSpinnerValueForTest());
	}
	
	@Test
	public void TestWaterSpinner() {
		clickOn(sut.getWaterSpinnerForTest());
		eraseText(1);
		write("45");
		clickOn(sut.getSaveButtonsToTest().get(1));
		assertEquals(45, sut.getWaterSpinnerValueForTest());
	}
	
	@Test
	public void TestAddingGoalTextField() {
		clickOn(sut.getAddGoalsFieldForTest());
		write("Sleep atleast 7 hours a day");
		clickOn(sut.getSaveButtonsToTest().get(2));
		assertEquals("Sleep atleast 7 hours a day", sut.getGoalsFieldValueForTest());
	}
}
