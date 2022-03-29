package application.Key2Keto;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	
    @Override
    public void start(Stage stage) {
    	stage.getIcons().add(new Image(this.getClass().getResourceAsStream("ketoIcon.png")));
    	SceneSwitcher switcher = new SceneSwitcher(stage);
   
    	stage.setScene(switcher.LoginScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}