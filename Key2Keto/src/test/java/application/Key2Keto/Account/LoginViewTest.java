package application.Key2Keto.Account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginViewTest extends ApplicationTest
{
	LoginView loginView;
	
	@Override
	public void start(Stage stage)
	{
		loginView = new LoginView(stage);
		Scene accountScene = new Scene(loginView);
		
		stage.setScene(accountScene);
		stage.show();
	}
	
	@Test
	public void validAccountInputSwitchesScene()
	{
		clickOn(loginView.getUsernameTextField());
		write("username123");
		clickOn(loginView.getPasswordTextField());
		write("password123");
		clickOn(loginView.getSignInButton());
		
		assertEquals(false, loginView.isFocused());
	}
	
	@Test
	public void emptyAccountInputDoesNotSwitchScene()
	{
		clickOn(loginView.getSignInButton());
		
		assertEquals(true, loginView.getSignInButton().isFocused());
	}
	
	@Test
	public void emptyUsernameDoesNotSwitchScene()
	{
		clickOn(loginView.getPasswordTextField());
		write("password123");
		clickOn(loginView.getSignInButton());
		
		assertEquals(true, loginView.getSignInButton().isFocused());
	}
	
	@Test
	public void emptyPasswordDoesNotSwitchScene()
	{
		clickOn(loginView.getUsernameTextField());
		write("username123");
		clickOn(loginView.getSignInButton());
		
		assertEquals(true, loginView.getSignInButton().isFocused());
	}
	
	@Test
	public void clickingCreateAccountButtonSwitchesScene()
	{
		clickOn(loginView.getCreateAccountButton());
		
		assertEquals(false, loginView.isFocused());
	}
}
