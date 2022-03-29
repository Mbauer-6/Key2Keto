package application.Key2Keto.Account;

import java.util.ArrayList;
import java.util.Arrays;

import application.Key2Keto.SceneSwitcher;
import application.Key2Keto.Interfaces.ViewInterface;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AccountCreationView extends Pane implements ViewInterface
{
	//For switching scenes
	private Stage stage;
	private SceneSwitcher switcher;
	
	private Label createAccountLabel;
	
	//a label sectioning off the "Create New Account" text from the text fields
	private Label accountDetailsDivider;
	
	private Label newUsernameLabel;
	private TextField newUsernameTextField;
	
	private Label newPasswordLabel;
	private PasswordField newPasswordTextField;
	
	//typically on many account creation forms
	private Label confirmPasswordLabel;
	private PasswordField confirmPasswordTextField;
	
	//now for personal details
	private Label personalDetailsDivider;

	private Label firstNameLabel;
	private TextField firstNameTextField;
	
	private Label lastNameLabel;
	private TextField lastNameTextField;
	
	//haha
	private Label sexLabel;
	private ComboBox<String> sexChooser;
	
	private Label heightLabel;
	private TextField heightTextField;
	
	private Label weightLabel;
	private TextField weightTextField;
	
	private Label ageLabel;
	private TextField ageTextField;
	
	private Label dietTypeLabel;
	private ComboBox<String> dietTypeChooser;
	
	private Button cancelAccountCreationButton;
	private Button createAccountButton;
	
	private HBox titleRow;
	private HBox accountDetailsDividerRow;
	private HBox newUsernameRow;
	private HBox newPasswordRow;
	private HBox confirmPasswordRow;
	private HBox personalDetailsDividerRow;

	private HBox firstNameRow;
	private HBox lastNameRow;

	private HBox sexRow;
	private HBox heightRow;
	private HBox weightRow;
	private HBox ageRow;
	private HBox dietTypeRow;
	private HBox createAccountButtonRow;
	
	private HBox errorRow;
	private Label errorLabel;
	
	private VBox accountCreationRows;
	
	public AccountCreationView(Stage stage)
	{
		this.stage = stage;
		this.switcher = new SceneSwitcher(stage);

		initializeVariables();
		stylizeElements();
		
		populateChildren();
	}
	
	public void initializeVariables()
	{
		createAccountLabel = new Label("Create New Account");
		
		accountDetailsDivider = new Label("Account Details");
		
		newUsernameLabel = new Label("Username:");
		newUsernameTextField = new TextField();
		
		newPasswordLabel = new Label("Password:");
		newPasswordTextField = new PasswordField();
		
		confirmPasswordLabel = new Label("Confirm Password:");
		confirmPasswordTextField = new PasswordField();
		
		personalDetailsDivider = new Label("Personal Details");
		
		firstNameLabel = new Label("First Name:");
		firstNameTextField = new TextField();
		
		lastNameLabel = new Label("Last Name:");
		lastNameTextField = new TextField();
		
		sexLabel = new Label("Sex:");
		String sexes[] = {"Male", "Female"};
		sexChooser = new ComboBox<String>(FXCollections.observableArrayList(sexes));
		
		heightLabel = new Label("Height:");
		heightTextField = new TextField();
		
		weightLabel = new Label("Weight:");
		weightTextField = new TextField();
		
		ageLabel = new Label("Age:");
		ageTextField = new TextField();
		
		dietTypeLabel = new Label("Diet Type:");
		String diets[] = {"Classic Keto", "Light Keto", "Modified Keto"};
		dietTypeChooser = new ComboBox<String>(FXCollections.observableArrayList(diets));
		
		cancelAccountCreationButton = new Button("Cancel");
		createAccountButton = new Button("Create Account");
		
		assignSetOnActions();
		
		titleRow = new HBox();
		accountDetailsDividerRow = new HBox();
		newUsernameRow = new HBox();
		newPasswordRow = new HBox();
		confirmPasswordRow = new HBox();
		personalDetailsDividerRow = new HBox();
    
		firstNameRow = new HBox();
		lastNameRow = new HBox();
		sexRow = new HBox();
		heightRow = new HBox();
		weightRow = new HBox();
		ageRow = new HBox();
		dietTypeRow = new HBox();
		createAccountButtonRow = new HBox();
		
		accountCreationRows = new VBox();
		
		errorLabel = new Label();
		errorRow = new HBox();
	}
	
	public void stylizeElements()
	{
		stage.setTitle("Key2Keto - Create New Account");
		
		titleRow.setAlignment(Pos.CENTER);
		titleRow.setMinWidth(500);
		HBox.setMargin(createAccountLabel, new Insets(40, 0, 40, 0));
		createAccountLabel.setId("Title");
		
		accountDetailsDividerRow.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
													   				   BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, 
													   				   CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
		accountDetailsDividerRow.setAlignment(Pos.CENTER);
		HBox.setMargin(accountDetailsDivider, new Insets(10, 0, 10, 0));
		accountDetailsDivider.setId("DetailDividers");
		
		HBox.setMargin(newUsernameLabel, new Insets(20, 10, 10, 10));
		HBox.setMargin(newUsernameTextField, new Insets(20, 10, 10, 10));
		newUsernameLabel.setMinWidth(144);
		
		HBox.setMargin(newPasswordLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(newPasswordTextField, new Insets(10, 10, 10, 10));
		newPasswordLabel.setMinWidth(144);
		
		HBox.setMargin(confirmPasswordLabel, new Insets(10, 10, 20, 10));
		HBox.setMargin(confirmPasswordTextField, new Insets(10, 10, 10, 10));
		confirmPasswordLabel.setMinWidth(144);
		
		createAccountButtonRow.setAlignment(Pos.CENTER);
		HBox.setMargin(createAccountButton, new Insets(20, 5, 20, 5));
		HBox.setMargin(cancelAccountCreationButton, new Insets(20, 5, 20, 5));
		
		personalDetailsDividerRow.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
				   														BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, 
				   														CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
		personalDetailsDividerRow.setAlignment(Pos.CENTER);
		HBox.setMargin(personalDetailsDivider, new Insets(10, 0, 10, 0));
		personalDetailsDivider.setId("DetailDividers");
		
		HBox.setMargin(firstNameLabel, new Insets(20, 10, 10, 10));
		HBox.setMargin(firstNameTextField, new Insets(20, 10, 10,10));
		firstNameLabel.setMinWidth(144);
		
		HBox.setMargin(lastNameLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(lastNameTextField, new Insets(10, 10, 10, 10));
		lastNameLabel.setMinWidth(144);
		
		HBox.setMargin(sexLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(sexChooser, new Insets(10, 10, 10, 10));
		sexLabel.setMinWidth(144);
		sexChooser.setMinWidth(157);
		
		HBox.setMargin(heightLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(heightTextField, new Insets(10, 10, 10, 10));
		heightLabel.setMinWidth(144);
		
		heightTextField.setPromptText("e.g. 5'11\"");
		
		HBox.setMargin(weightLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(weightTextField, new Insets(10, 10, 10, 10));
		weightLabel.setMinWidth(144);
		weightTextField.setPromptText("in pounds");
		
		HBox.setMargin(ageLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(ageTextField, new Insets(10, 10, 10, 10));
		ageLabel.setMinWidth(144);
		ageTextField.setPromptText("in years");
		
		HBox.setMargin(dietTypeLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(dietTypeChooser, new Insets(10, 10, 10, 10));
		dietTypeLabel.setMinWidth(144);
		dietTypeChooser.setMinWidth(157);
		
		errorLabel.setVisible(false);
		errorRow.setAlignment(Pos.CENTER);
		errorRow.setId("ErrorLabel");
		
		accountCreationRows.setId("WholePane");
	}
	
	public void assignSetOnActions()
	{
		cancelAccountCreationButton.setOnAction(e ->
		{
			stage.setScene(switcher.LoginScene());
		});
		
		createAccountButton.setOnAction(e -> 
		{
			if(AccountCreationViewLogic.checkFormProperlyFilled(newUsernameTextField.getText(), newPasswordTextField.getText(), confirmPasswordTextField.getText(),
																firstNameTextField.getText(), lastNameTextField.getText(), sexChooser.getSelectionModel().getSelectedItem(), 
																heightTextField.getText(), weightTextField.getText(), ageTextField.getText(), 
																dietTypeChooser.getSelectionModel().getSelectedItem()))
			{	
				stage.setScene(switcher.MainViewScene(AccountCreationViewLogic.getNewlyCreatedAccount()));
				System.out.println("Recipe Type: "+ AccountCreationViewLogic.getNewlyCreatedAccount().getDietType());
			}
			
			else
			{
				errorLabel.setText(AccountCreationViewLogic.getErrorMessage());
				errorLabel.setVisible(true);
			}
		});
	}
	
	public void populateChildren()
	{
		titleRow.getChildren().add(createAccountLabel);
		
		accountDetailsDividerRow.getChildren().add(accountDetailsDivider);
		
		newUsernameRow.getChildren().addAll(newUsernameLabel, newUsernameTextField);
		newPasswordRow.getChildren().addAll(newPasswordLabel, newPasswordTextField);
		
		confirmPasswordRow.getChildren().addAll(confirmPasswordLabel, confirmPasswordTextField);
		
		personalDetailsDividerRow.getChildren().add(personalDetailsDivider);
		
		firstNameRow.getChildren().addAll(firstNameLabel, firstNameTextField);
		lastNameRow.getChildren().addAll(lastNameLabel, lastNameTextField);
		
		sexRow.getChildren().addAll(sexLabel, sexChooser);
		heightRow.getChildren().addAll(heightLabel, heightTextField);
		weightRow.getChildren().addAll(weightLabel, weightTextField);
		ageRow.getChildren().addAll(ageLabel, ageTextField);
		dietTypeRow.getChildren().addAll(dietTypeLabel, dietTypeChooser);
		
		createAccountButtonRow.getChildren().addAll(cancelAccountCreationButton, createAccountButton);
		
		errorRow.getChildren().add(errorLabel);
		
		accountCreationRows.getChildren().addAll(titleRow, accountDetailsDividerRow, newUsernameRow, newPasswordRow, confirmPasswordRow, 
												 personalDetailsDividerRow, firstNameRow, lastNameRow, sexRow, heightRow, weightRow, ageRow, dietTypeRow, 
												 errorRow, createAccountButtonRow);
		
		this.getChildren().add(accountCreationRows);
	}
	
	//for setting on action in pane containing this pane
	public Button getCreateAccountButton()
	{
		return createAccountButton;
	}
	
	//these two are for junit
	protected ArrayList<TextField> getAccountDetailTextFields()
	{
		ArrayList<TextField> textFieldsToReturn = new ArrayList<TextField>
		(
			Arrays.asList(newUsernameTextField, newPasswordTextField, confirmPasswordTextField, firstNameTextField, lastNameTextField,
						  heightTextField, weightTextField, ageTextField)
		);
		
		return textFieldsToReturn;
	}
	
	protected ArrayList<ComboBox<String>> getAccountDetailComboBoxes()
	{
		ArrayList<ComboBox<String>> comboBoxesToReturn = new ArrayList<ComboBox<String>>
		(
			Arrays.asList(sexChooser, dietTypeChooser)
		);
		
		return comboBoxesToReturn;
	}
}