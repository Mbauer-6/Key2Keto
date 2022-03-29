package application.Key2Keto.Account;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountCreationViewTest extends ApplicationTest
{
	AccountCreationView accountCreationView;
	
	@Override
	public void start(Stage stage)
	{
		accountCreationView = new AccountCreationView(stage);
		Scene accountScene = new Scene(accountCreationView);
		
		stage.setScene(accountScene);
		stage.show();
	}
	
	@Test
	public void properlyFilledFormSwitchesSceneTest()
	{
		ArrayList<TextField> textFields = accountCreationView.getAccountDetailTextFields();
		ArrayList<ComboBox<String>> comboBoxes = accountCreationView.getAccountDetailComboBoxes();
		
		clickOn(textFields.get(0)); //username
		write("newusername123");
		
		clickOn(textFields.get(1)); //password
		write("newpassword123");
		
		clickOn(textFields.get(2)); //confirm password
		write("newpassword123");
		
		clickOn(textFields.get(3)); //first name
		write("John");
		
		clickOn(textFields.get(4)); //last name
		write("Lastnameigan");
		
		clickOn(comboBoxes.get(0)); //sex
		clickOn("Male");
		
		clickOn(textFields.get(5)); //height
		write("6'1\"");
		
		clickOn(textFields.get(6)); //weight
		write("195");
		
		clickOn(textFields.get(7)); //age
		write("22");
		
		clickOn(comboBoxes.get(1)); //diet type
		clickOn("Classic Keto");
		
		clickOn(accountCreationView.getCreateAccountButton());
		
		assertEquals(false, accountCreationView.isFocused());
	}
	
	@Test
	public void improperlyFilledFormDoesNotSwitchSceneTest()
	{
		ArrayList<TextField> textFields = accountCreationView.getAccountDetailTextFields();
		ArrayList<ComboBox<String>> comboBoxes = accountCreationView.getAccountDetailComboBoxes();
		
		clickOn(textFields.get(0)); //username
		write("newusername123");
		
		clickOn(textFields.get(1)); //password
		write("newpassword123");
		
		clickOn(textFields.get(2)); //confirm password
		write("unmatchingpassword123");
		
		clickOn(textFields.get(3)); //first name
		write("John withaspace");
		
		clickOn(textFields.get(4)); //last name
		write("Lastnameigan anotherspace");
		
		clickOn(textFields.get(5)); //height
		write("6'13\"");
		
		clickOn(textFields.get(6)); //weight
		write("one hundred eighty five");
		
		clickOn(textFields.get(7)); //age
		write("twenty five");
		
		clickOn(accountCreationView.getCreateAccountButton());
		
		assertEquals(true, accountCreationView.getCreateAccountButton().isFocused());
	}
	
	@Test
	public void validFormCreatesAccountObjectTest()
	{
		ArrayList<TextField> textFields = accountCreationView.getAccountDetailTextFields();
		ArrayList<ComboBox<String>> comboBoxes = accountCreationView.getAccountDetailComboBoxes();
		
		clickOn(textFields.get(0)); //username
		write("newusername123");
		
		clickOn(textFields.get(1)); //password
		write("newpassword123");
		
		clickOn(textFields.get(2)); //confirm password
		write("newpassword123");
		
		clickOn(textFields.get(3)); //first name
		write("John");
		
		clickOn(textFields.get(4)); //last name
		write("Lastnameigan");
		
		clickOn(comboBoxes.get(0)); //sex
		clickOn("Male");
		
		clickOn(textFields.get(5)); //height
		write("6'1\"");
		
		clickOn(textFields.get(6)); //weight
		write("195");
		
		clickOn(textFields.get(7)); //age
		write("22");
		
		clickOn(comboBoxes.get(1)); //diet type
		clickOn("Classic Keto");
		
		clickOn(accountCreationView.getCreateAccountButton());
		
		Account sut = AccountCreationViewLogic.getNewlyCreatedAccount();
		
		assertEquals("newusername123", sut.getUsername());
		assertEquals("newpassword123", sut.getPassword());
		assertEquals("John", sut.getFirstName());
		assertEquals("Lastnameigan", sut.getLastName());
		assertEquals("Male", sut.getSex());
		assertEquals("6'1\"", sut.getHeight());
		assertEquals(195, sut.getWeight());
		assertEquals(22, sut.getAge());
		assertEquals("Classic Keto", sut.getDietType());
	}
}
