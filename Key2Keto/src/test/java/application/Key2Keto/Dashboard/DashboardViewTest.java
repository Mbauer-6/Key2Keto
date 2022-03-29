package application.Key2Keto.Dashboard;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Recipes.Recipe;
import javafx.scene.Scene;
import javafx.stage.Stage;

class DashboardViewTest extends ApplicationTest {
	DashboardView dashView;
	Account account;
	
	@Override
	public void start(Stage stage) throws MalformedURLException {
		account = new Account("username123", "password123", "John", "McLastname", "Male", "5'9\"", 190, 24, "Modified");
		dashView = new DashboardView(account);
		this.dashView.getDashboardForTest().getUserAccount().getChosenRecipes().get(this.dashView.getDashboardForTest()
				.getCurrentDayInt()).add(new Recipe("Breakfast", "Chocolate Chip Cookies", 200, 20.5, 15.5, 10.5, 4, "C", 11));
		this.dashView.getDashboardForTest().getUserAccount().getChosenRecipes().get(this.dashView.getDashboardForTest()
				.getCurrentDayInt()).add(null);
		this.dashView.getDashboardForTest().getUserAccount().getChosenRecipes().get(this.dashView.getDashboardForTest()
				.getCurrentDayInt()).add(null);
		this.dashView.getDashboardForTest().getUserAccount().getChosenRecipes().get(this.dashView.getDashboardForTest()
				.getCurrentDayInt()).add(null);
		this.dashView.getDashboardForTest().getUserAccount().getTrackers()
		.get(this.dashView.getDashboardForTest().getCurrentDayInt()).addGoal("This is a test Goal");
		account = this.dashView.getDashboardForTest().getUserAccount();
		this.dashView = new DashboardView(account);
		Scene dashScene = new Scene(dashView);
		stage.setScene(dashScene);
		stage.show();
	}
	
	@Test
	public void getNamesOfSelectedCheckbox() {
		WaitForAsyncUtils.waitForFxEvents();
		clickOn(dashView.getCheckBoxToTest().get(0));
		assertEquals("This is a test Goal", dashView.getCheckBoxToTest().get(0).getText());
		assertEquals(true,dashView.getCheckBoxToTest().get(0).isSelected());
	}
	
	@Test
	public void getNamesOfSelectedRecipes() {		
		assertEquals("Chosen Breakfast: Chocolate Chip Cookies",this.dashView.getLabelsToTest().get(0).getText());
	}


}
