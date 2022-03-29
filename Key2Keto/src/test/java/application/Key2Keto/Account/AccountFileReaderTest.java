package application.Key2Keto.Account;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import application.Key2Keto.Recipes.Recipe;

public class AccountFileReaderTest extends ApplicationTest
{	
	@Test
	public void loadFileTest() throws MalformedURLException
	{
		Account accountToSave = new Account("usernameToTest", "passwordToTest", "firstNameTest", "lastNameTest", "sexTest", "heightTest", 200, 25, "Modified");
		accountToSave.addRecipe(new Recipe("Breakfast", "Dairy Free Baked Custard", 246, 2.71, 24, 6, 3, "Modified", 0), 0);
		accountToSave.addRecipe(new Recipe("Entrees", "Lamb and Asparagus with Tangy Sauce", 500, 2.5, 47, 15, 3.7, "Modified", 0), 0);
		accountToSave.addRecipe(new Recipe("Snacks", "Keto Biscotti", 823, 2, 75, 21, 17, "Modified", 0), 1);
		accountToSave.addRecipe(null, 2);
		accountToSave.addRecipe(null, 2);
		accountToSave.addRecipe(new Recipe("Entrees", "Rogan Josh", 450, 2, 46, 18, 5, "Modified", 0), 2);
		
		accountToSave.getTrackers().get(0).setHoursOfSleep(5.5);
		accountToSave.getTrackers().get(0).setWaterIntake(15);
		accountToSave.getTrackers().get(1).addGoal("goalTest");
		accountToSave.getTrackers().get(2).addGoal("goalTest1");
		accountToSave.getTrackers().get(4).setWaterIntake(17.5);
		accountToSave.getTrackers().get(5).setHoursOfSleep(9.5);
		
		AccountSaver.saveAccount(accountToSave);
		
		AccountFileReader sut = new AccountFileReader("usernameToTest.txt");
		
		assertEquals("usernameToTest", sut.getLoadedAccount().getUsername());
		assertEquals("passwordToTest", sut.getLoadedAccount().getPassword());
		assertEquals("firstNameTest", sut.getLoadedAccount().getFirstName());
		assertEquals("lastNameTest", sut.getLoadedAccount().getLastName());
		assertEquals("sexTest", sut.getLoadedAccount().getSex());
		assertEquals("heightTest", sut.getLoadedAccount().getHeight());
		assertEquals(200, sut.getLoadedAccount().getWeight());
		assertEquals(25, sut.getLoadedAccount().getAge());
		assertEquals("Modified", sut.getLoadedAccount().getDietType());
		
		assertEquals("Breakfast", sut.getLoadedAccount().getChosenRecipes().get(0).get(0).getType());
		assertEquals("Entrees", sut.getLoadedAccount().getChosenRecipes().get(0).get(1).getType());
		assertEquals("Snacks", sut.getLoadedAccount().getChosenRecipes().get(1).get(0).getType());
		assertEquals("Entrees", sut.getLoadedAccount().getChosenRecipes().get(2).get(2).getType());
		
		assertEquals(5.5, sut.getLoadedAccount().getTrackers().get(0).getHoursOfSleep());
		assertEquals(15, sut.getLoadedAccount().getTrackers().get(0).getWaterIntake());
		assertEquals("goalTest", sut.getLoadedAccount().getTrackers().get(1).getGoals().get(0));
		assertEquals("goalTest1", sut.getLoadedAccount().getTrackers().get(2).getGoals().get(0));
		assertEquals(17.5, sut.getLoadedAccount().getTrackers().get(4).getWaterIntake());
		assertEquals(9.5, sut.getLoadedAccount().getTrackers().get(5).getHoursOfSleep());
	}
}
