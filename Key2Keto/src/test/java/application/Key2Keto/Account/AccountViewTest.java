package application.Key2Keto.Account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountViewTest extends ApplicationTest
{
	AccountView accountView;
	
	@Override
	public void start(Stage stage)
	{
		accountView = new AccountView(new Account("dummyUsername", "dummyPassword", "Dummy", "Name", "Male", "5'11\"", 0, 0, "Classic"));
		Scene accountScene = new Scene(accountView);
		
		stage.setScene(accountScene);
		stage.show();
	}
	
	@Test
	public void validUsernameInputChangesLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(0));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("newusername123");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("newusername123", accountView.getCurrentVariableLabelsForTests().get(0).getText());
	}
	
	@Test
	public void invalidUsernameInputDoesNotChangeLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(0));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write(""); //can't be blank
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("dummyUsername", accountView.getCurrentVariableLabelsForTests().get(0).getText());
	}
	
	@Test
	public void validPasswordInputChangesLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(1));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("newpassword123");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("newpassword123", accountView.getCurrentVariableLabelsForTests().get(1).getText());
	}
	
	@Test
	public void invalidPasswordInputDoesNotChangeLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(1));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write(""); //can't be blank
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("dummyPassword", accountView.getCurrentVariableLabelsForTests().get(1).getText());
	}
	
	@Test
	public void validNameInputChangesLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(2));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("New Name");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("New Name", accountView.getCurrentVariableLabelsForTests().get(2).getText());
	}
	
	@Test
	public void nameInputContainingThreePlusWordsDoesNotChangeLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(2));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("Invalid Name haha"); //can't be more than two words
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("Dummy Name", accountView.getCurrentVariableLabelsForTests().get(2).getText());
	}
	
	@Test
	public void nameInputContainingNumbersDoesNotChangeLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(2));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("1nvalid N4m3"); //can't contain numbers
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("Dummy Name", accountView.getCurrentVariableLabelsForTests().get(2).getText());
	}
	
	@Test
	public void pickingNewSexChangesLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(3));
		clickOn(accountView.getNewVariableComboBoxForTests());
		clickOn("Female");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("Female", accountView.getCurrentVariableLabelsForTests().get(3).getText());
	}
	
	@Test
	public void notPickingNewSexDoesNotChangeLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(3));
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("Male", accountView.getCurrentVariableLabelsForTests().get(3).getText());
	}
	
	@Test
	public void validHeightInputChangesLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(4));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("4'11\"");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("4'11\"", accountView.getCurrentVariableLabelsForTests().get(4).getText());
	}
	
	@Test
	public void heightInputNotContainingInchesChangesLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(4));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("6'");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("6'", accountView.getCurrentVariableLabelsForTests().get(4).getText());
	}
	
	@Test
	public void heightInputInchesHigherThanElevenDoesNotChangeLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(4));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("6'12\"");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("5'11\"", accountView.getCurrentVariableLabelsForTests().get(4).getText());
	}
	
	@Test
	public void heightInputInvalidRegexDoesNotChangeLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(4));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("adfmpwou5'f90df1m0111\"");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("5'11\"", accountView.getCurrentVariableLabelsForTests().get(4).getText());
	}
	
	@Test
	public void validWeightInputChangesLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(5));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("180");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("180 lbs", accountView.getCurrentVariableLabelsForTests().get(5).getText());
	}
	
	@Test
	public void invalidWeightInputDoesNotChangeLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(5));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("zpoi58923oiudmf3");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("0 lbs", accountView.getCurrentVariableLabelsForTests().get(5).getText());
	}
	
	@Test
	public void validAgeInputChangesLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(6));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("22");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("22", accountView.getCurrentVariableLabelsForTests().get(6).getText());
	}
	
	@Test
	public void invalidAgeInputDoesNotChangeLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(6));
		clickOn(accountView.getNewVariableTextFieldForTests());
		write("qpoifapsoidfakdmf");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("0", accountView.getCurrentVariableLabelsForTests().get(6).getText());
	}
	
	@Test
	public void pickingNewDietTypeChangesLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(7));
		clickOn(accountView.getNewVariableComboBoxForTests());
		clickOn("Modified Keto");
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("Modified Keto", accountView.getCurrentVariableLabelsForTests().get(7).getText());
	}
	
	@Test
	public void notPickingDietTypeDoesNotChangeLabelTest()
	{
		clickOn(accountView.getButtonsForTests().get(7));
		clickOn(accountView.getConfirmVariableChangeButtonForTests());
		
		assertEquals("Classic Keto", accountView.getCurrentVariableLabelsForTests().get(7).getText());
	}
}
