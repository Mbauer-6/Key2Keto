package application.Key2Keto.Account;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class AccountSaverTest
{
	@Test
	public void saveToFileTest()
	{
		Account accountToSave = new Account("testUsername", "testPassword", "testFirstName", "testLastName", "testSex", "testHeight", 200, 22, "Modified");
		
		AccountSaver.saveAccount(accountToSave);
		
		File sut = new File("testUsername.txt");
		Scanner fileScanner = null;
		
		try
		{
			fileScanner = new Scanner(sut);
			fileScanner.useDelimiter(",|\n");
			
			assertEquals("testUsername", fileScanner.next());
			assertEquals("testPassword", fileScanner.next());
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		finally
		{
			fileScanner.close();
		}
	}
}
