package application.Key2Keto;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Account.AccountCreationView;
import application.Key2Keto.Account.LoginView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneSwitcher extends Pane{
	
	Stage stage;
	Account user;
	public SceneSwitcher(Stage stage) {
		this.stage = stage;
	}
	
	public Scene LoginScene() {
		StackPane loginPane = new StackPane();
    	LoginView loginView = new LoginView(this.stage);
    	
    	loginPane.getChildren().add(loginView);
        Scene loginScene = new Scene(loginPane);
        loginScene.getStylesheets().addAll(this.getClass().getResource("LoginStyling.css").toExternalForm());

        return loginScene;
	}
	
	public Scene AccountCreationScene() {
		StackPane creationPane = new StackPane();
    	AccountCreationView creationView = new AccountCreationView(this.stage);
    	
    	creationPane.getChildren().add(creationView);
        Scene creationScene = new Scene(creationPane);
        creationScene.getStylesheets().addAll(this.getClass().getResource("LoginStyling.css").toExternalForm());
        
        return creationScene;
	}
	

	public Scene MainViewScene(Account account) {
    	MainView mainView = new MainView(account, this.stage);

    	VBox view = mainView.getView();
        Scene mainViewScene = new Scene(view);
        stage.setTitle("Key2Keto");
        
        mainViewScene.getStylesheets().addAll(this.getClass().getResource("MainStyling.css").toExternalForm());
        
        return mainViewScene;
	}
}
