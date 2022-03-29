package application.Key2Keto.Recipes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;

import application.Key2Keto.Account.Account;
import javafx.scene.Scene;
import javafx.stage.Stage;



class RecipeViewTest extends ApplicationTest{
	RecipeView recipeView;
	
	@Override
	public void start(Stage stage) {
		
		recipeView = new RecipeView(new Account("dummyUsername", "dummyPassword", "First", "Last", "Male", "6'1\"", 150, 24, "Modified Keto"));
		
		Scene recipeScene = new Scene(recipeView);
		stage.setScene(recipeScene);
		stage.show();
	}
	
	@Test
	public void gettingSelectedDayView() {
		clickOn(recipeView.getButtonsToTest().get(0));
		assertEquals(-1, recipeView.getViewForTest().getViewOrder());
		assertEquals("Sunday",recipeView.getViewForTest().getName());
	}
	
	
	@Test
	public void gettingRecipeNameFromComboBox() {
		clickOn(recipeView.getButtonsToTest().get(0));
		DayOfWeekView day = recipeView.getViewForTest();
		clickOn(day.getButtonsToTest().get(0));
		clickOn(day.getComboBoxForTest());
		assertEquals("Dairy Free Baked Custard", day.getComboBoxForTest().getItems().get(0).toString());
	}
	
	@Test
	public void gettingRecipeRatioFromSelectedRecipeFromComboBox() {
		clickOn(recipeView.getButtonsToTest().get(0));
		DayOfWeekView day = recipeView.getViewForTest();
		clickOn(day.getButtonsToTest().get(0));
		clickOn(day.getComboBoxForTest());
		assertEquals(4,day.getComboBoxForTest().getItems().size());
		assertEquals("Dairy Free Baked Custard", day.getComboBoxForTest().getItems().get(0).toString());
		
		interact(() -> {
			day.getComboBoxForTest().getSelectionModel().select(0);
		});
		
		assertEquals("Recipe Ratio: 2.71/1", day.getDetailView().getDetailLabels().get(1).getText());

	}
	
	@Test
	public void gettingRecipeNameAfterAddingRecipeToDaysList() {
		clickOn(recipeView.getButtonsToTest().get(0));
		DayOfWeekView day = recipeView.getViewForTest();
		clickOn(day.getButtonsToTest().get(0));
		clickOn(day.getComboBoxForTest());
		assertEquals(4,day.getComboBoxForTest().getItems().size());
		assertEquals("Dairy Free Baked Custard", day.getComboBoxForTest().getItems().get(0).toString());
		
		interact(() -> {
			day.getComboBoxForTest().getSelectionModel().select(0);
		});
		
		clickOn(day.getButtonsToTest().get(7));
		assertEquals("Dairy Free Baked Custard", day.getLabels().get(0).getText());
	}
	
	@Test
	public void gettingBreakFastLabelAfterDeletingRecipeFromDaysList() {
		clickOn(recipeView.getButtonsToTest().get(0));
		DayOfWeekView day = recipeView.getViewForTest();
		clickOn(day.getButtonsToTest().get(0));
		clickOn(day.getComboBoxForTest());
		assertEquals(4,day.getComboBoxForTest().getItems().size());
		assertEquals("Dairy Free Baked Custard", day.getComboBoxForTest().getItems().get(0).toString());
		
		interact(() -> {
			day.getComboBoxForTest().getSelectionModel().select(0);
		});
		
		clickOn(day.getButtonsToTest().get(7));
		clickOn(day.getButtonsToTest().get(3));
		assertEquals("No Breakfast Chosen", day.getLabels().get(0).getText());

	}

}
