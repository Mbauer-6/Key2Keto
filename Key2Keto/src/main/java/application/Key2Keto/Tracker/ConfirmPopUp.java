package application.Key2Keto.Tracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmPopUp extends Pane{
	Button closeButton;
	Stage popUp;
	Label confirmationLabel;
	VBox layout;
	Boolean isClosed;
	
	public ConfirmPopUp() {
		//do nothing
	}
	
	public void display() {
		this.popUp = new Stage();
		this.popUp.initModality(Modality.APPLICATION_MODAL);
		this.popUp.setTitle("Confirmation");
		this.isClosed = false;
		
		this.confirmationLabel = new Label("The information you entered was saved!");
		this.closeButton = new Button("Close");
		this.closeButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	popUp.close();
		    	isClosed = true;
		    }
		});
		
		this.layout = new VBox(10);
		this.layout.getChildren().addAll(confirmationLabel, closeButton);
		this.layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 300, 100);
		popUp.setScene(scene);
		popUp.show();
	}
	
	public Button getCloseButton() {
		return this.closeButton;
	}
	
	public boolean getIsClosed() {
		return this.isClosed;
	}
}
