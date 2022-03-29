package application.Key2Keto.Tracker;

import application.Key2Keto.Tracker.ConfirmPopUp;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class ConfirmPopUpTest extends ApplicationTest{
	
	ConfirmPopUp sut;
	
	@Override
	public void start(Stage stage){
		
		sut = new ConfirmPopUp();
		sut.display();
	}
	
	@Test
	public void TestCloseButton() {
		clickOn(sut.getCloseButton());
		assertTrue(sut.getIsClosed());
	}
	
}
