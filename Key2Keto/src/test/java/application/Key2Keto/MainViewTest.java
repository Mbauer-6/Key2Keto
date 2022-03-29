package application.Key2Keto;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import application.Key2Keto.Account.Account;

public class MainViewTest extends ApplicationTest{
	MainView sut;
	Account mockAcc = new Account();
	
	@Override
	public void start(Stage stage) {
		
		sut = new MainView(new Account("dummyUsername", "dummyPassword", "Dummy", "Name", "Male", "5'11\"", 0, 0, "Classic"), stage);
		
		Scene mainScene = new Scene(sut.getView());
		stage.setScene(mainScene);
		stage.show();	
	}
	
	@Test
	public void testDashboardButton() {
		clickOn(sut.getButtonsToTest().get(0));
		assertEquals("Dashboard", sut.getCurrentTab());
	}
	
	@Test
	public void testAccountButton() {
		clickOn(sut.getButtonsToTest().get(1));
		assertEquals("MyAccount", sut.getCurrentTab());
	}
	
	@Test
	public void testTrackerButton() {
		clickOn(sut.getButtonsToTest().get(2));
		assertEquals("Tracker", sut.getCurrentTab());
	}
	
	@Test
	public void testShoppingButton() {
		clickOn(sut.getButtonsToTest().get(3));
		assertEquals("Shopping", sut.getCurrentTab());
	}
	
	@Test
	public void testRecipeButton() {
		clickOn(sut.getButtonsToTest().get(4));
		assertEquals("Recipe", sut.getCurrentTab());
	}
	
	@Test
	public void testLogoutButton() {
		clickOn(sut.getButtonsToTest().get(5));
		assertEquals("Logout", sut.getCurrentTab());
	}
}
