package application.Key2Keto.Account;

import java.io.File;

public class LoginViewLogic
{
	private static String errorMessage;
	
	public static boolean checkFormProperlyFilled(String usernameString, String passwordString)
	{
		if(usernameString.equals(""))
		{
			errorMessage = "Username field must not be empty";
			return false;
		}
		
		else if(passwordString.equals(""))
		{
			errorMessage = "Password field must not be empty";
			return false;
		}
		
		else
		{
			File fileExists = new File(usernameString + ".txt");
			if(!fileExists.exists())
			{
				errorMessage = usernameString + " does not exist";
				return false;
			}
			
			else
			{
				AccountFileReader accountLoader = new AccountFileReader(usernameString + ".txt");
				
				if(!passwordString.equals(accountLoader.getLoadedAccount().getPassword()))
				{
					errorMessage = "incorrect password";
					return false;
				}
				
				else
				{
					return true;
				}
			}
		}
	}
	
	public static String getErrorMessage()
	{
		return errorMessage;
	}
}
