package application.Key2Keto.Shopping;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Recipes.Recipe;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

class ShoppingViewTest extends ApplicationTest {
	ShoppingView shoppingView;
	
	@Override
	public void start(Stage stage) {
		
		shoppingView = new ShoppingView(new Account("dummyUsername", "dummyPassword", "First", "Last", "Male",
				"6'1\"", 150, 24, "Modified Keto"));
		
		Scene shoppingScene = new Scene(shoppingView);
		stage.setScene(shoppingScene);
		stage.show();

	}
	@Test
	public void getRestaurantNameToTest() {
		clickOn(shoppingView.getComboForTest());
		assertEquals("Chili's", shoppingView.getComboForTest().getItems().get(0).toString());
	}
	
	@Test
	public void getMealNameToTest() {
		clickOn(shoppingView.getComboForTest());
		clickOn(shoppingView.getComboForTest().getItems().get(0).toString());
		assertEquals("Classic Sirloin with side of Steamed Broccoli", shoppingView.getMealForTest().getText());
	}
	
	@Test
	public void getMondayMacroForTest() {
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	shoppingView.getAccountForTest().addRecipe(new Recipe("Breakfast","Dairy Free Baked Custard",246,
		    			2.71,24,6,3,"Modified"), 1);
				shoppingView.updateUI();
		    	assertEquals("Monday: Fat: 6.0g   Carbs: 2.71g  Protein: 24.0g",
		    			shoppingView.getMacroLabelsForTest().get(1).getText());
		    }
		});
		
	}

}

