package application.Key2Keto.Account;

import application.Key2Keto.SceneSwitcher;
import application.Key2Keto.Interfaces.ViewInterface;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView extends Pane implements ViewInterface
{
	//For switching scenes
	private Stage stage;
	private SceneSwitcher switcher;

	//Section for the app title/logo
	private Label titleOrLogo;
	
	//two text boxes and labels for username and password
	private Label usernameLabel;
	private Label passwordLabel;
	
	private TextField usernameTextField;
	private PasswordField passwordTextField;
	
	//one button for signing in, one button for creating account
	private Button signInButton;
	private Button createAccountButton;
	
	//need a label for creating account button
	private Label noAccountLabel;
	
	//now some HBoxes
	private HBox titleOrLogoRow;
	private HBox usernameRow;
	private HBox passwordRow;
	private HBox signInButtonRow;
	private HBox createAccountRow;
	
	//for showing errors upon invalid input
	private HBox errorRow;
	private Label errorLabel;
	
	//and a VBox to contain them all
	private VBox loginRows;
	
	public LoginView(Stage stage)
	{
		this.stage = stage;
		this.switcher = new SceneSwitcher(stage);

		initializeVariables();
		stylizeElements();
		
		assignSetOnActions();
		populateChildren();
	}
	
	public void initializeVariables()
	{
		titleOrLogo = new Label("Key2Keto");
		
		usernameLabel = new Label("Username:");
		passwordLabel = new Label("Password:");
		
		usernameTextField = new TextField();
		passwordTextField = new PasswordField();
		
		signInButton = new Button("Sign in");
		
		createAccountButton = new Button("Create Account");
		createAccountButton.setOnAction(e -> stage.setScene(switcher.AccountCreationScene()));

		noAccountLabel = new Label("Don't have an account? Create one here:");
		
		usernameRow = new HBox();
		titleOrLogoRow = new HBox();
		passwordRow = new HBox();
		signInButtonRow = new HBox();
		createAccountRow = new HBox();
		
		errorLabel = new Label();
		errorRow = new HBox();
		
		loginRows = new VBox();
	}
	
	public void stylizeElements()
	{
		stage.setTitle("Key2Keto - Sign In");
		
		titleOrLogoRow.setAlignment(Pos.CENTER);
		titleOrLogoRow.setMinWidth(500);
		HBox.setMargin(titleOrLogo, new Insets(40, 0, 40, 0));
		titleOrLogo.setId("Title");
		
		HBox.setMargin(usernameLabel, new Insets(10, 20, 10, 20));
		HBox.setMargin(usernameTextField, new Insets(10, 20, 10, 20));
		usernameLabel.setMinWidth(113);
		
		HBox.setMargin(passwordLabel, new Insets(10, 20, 10, 20));
		HBox.setMargin(passwordTextField, new Insets(10, 20, 10, 20));
		passwordLabel.setMinWidth(113);
		
		signInButtonRow.setAlignment(Pos.CENTER);
		HBox.setMargin(signInButton, new Insets(10, 0, 10, 0));
		
		errorLabel.setVisible(false);
		errorRow.setAlignment(Pos.CENTER);
		errorRow.setId("ErrorLabel");
		
		createAccountRow.setAlignment(Pos.CENTER);
		HBox.setMargin(createAccountButton, new Insets(30, 20, 30, 20));
		
		loginRows.setId("WholePane");
	}
	
	public void populateChildren() //helper function for readability
	{
		titleOrLogoRow.getChildren().add(titleOrLogo);
		usernameRow.getChildren().addAll(usernameLabel, usernameTextField);
		passwordRow.getChildren().addAll(passwordLabel, passwordTextField);
		signInButtonRow.getChildren().add(signInButton);
		
		createAccountRow.getChildren().addAll(noAccountLabel, createAccountButton);
		
		errorRow.getChildren().add(errorLabel);
		
		loginRows.getChildren().addAll(titleOrLogoRow, usernameRow, passwordRow, errorRow, signInButtonRow, createAccountRow);
		
		this.getChildren().add(loginRows);
	}
	
	public void assignSetOnActions()
	{
		signInButton.setOnAction(e -> 
		{
			if(LoginViewLogic.checkFormProperlyFilled(usernameTextField.getText(), passwordTextField.getText()))
			{
				AccountFileReader accountLoader = new AccountFileReader(usernameTextField.getText() + ".txt");
				stage.setScene(switcher.MainViewScene(accountLoader.getLoadedAccount()));
			}
			
			else
			{
				errorLabel.setText(LoginViewLogic.getErrorMessage());
				errorLabel.setVisible(true);
			}
		});
	}
	
	//for unit tests
	protected Button getSignInButton()
	{
		return signInButton;
	}
	
	protected Button getCreateAccountButton()
	{
		return createAccountButton;
	}
	
	//these are for junit
	protected TextField getUsernameTextField()
	{
		return usernameTextField;
	}
	
	protected TextField getPasswordTextField()
	{
		return passwordTextField;
	}
}
