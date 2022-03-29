package application.Key2Keto.Account;

public class AccountCreationViewLogic
{
	private static String errorMessage;
	private static Account account;
	
	public static boolean checkFormProperlyFilled(String usernameString, String passwordString, String confirmPasswordString, String firstNameString,
												  String lastNameString, String sexString, String heightString, String weightString, String ageString,
												  String dietTypeString)
	{
		//testing if text fields are empty
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
		
		else if(confirmPasswordString.equals(""))
		{
			errorMessage = "Confirm password field must not be empty";
			return false;
		}
		
		//then confirm password
		else if(!confirmPasswordString.equals(passwordString)) //not equal to each other
		{
			errorMessage = "Confirm password does not match password";
			return false;
		}
		
		else if(firstNameString.equals(""))
		{
			errorMessage = "First name field must not be empty";
			return false;
		}
		
		else if(lastNameString.equals(""))
		{
			errorMessage = "Last name field must not be empty";
			return false;
		}
		
		//now personal details
		else if(sexString == null)
		{
			errorMessage = "A sex must be chosen";
			return false;
		}
		
		else if(heightString.equals(""))
		{
			errorMessage = "Height field must not be empty";
			return false;
		}
		
		else if(!heightString.matches("^([0-9]*'([0-9]\"|(1[0-1])\"))|([0-9]*')$"))
		{
			errorMessage = "Height must be expressed in the form ft'in\" or ft'";
			return false;
		}
		
		else if(weightString.equals(""))
		{
			errorMessage = "Weight field must not be empty";
			return false;
		}
		
		else if(!weightString.matches("^[0-9]*$"))
		{
			errorMessage = "Weight must contain only digits";
			return false;
		}
		
		else if(ageString.equals(""))
		{
			errorMessage = "Age field must not be empty";
			return false;
		}
		
		else if(!ageString.matches("^[0-9]*$"))
		{
			errorMessage = "Age must contain only digits";
			return false;
		}
		
		else if(dietTypeString == null)
		{
			errorMessage = "A diet type must be chosen";
			return false;
		}
		
		//if none of the above are true, form is filled correctly
		else
		{
			account = new Account(usernameString, passwordString, firstNameString, lastNameString, sexString, heightString,
								  Integer.parseInt(weightString), Integer.parseInt(ageString), dietTypeString);
			return true;
		}
	}
	
	public static String getErrorMessage()
	{
		return errorMessage;
	}
	
	public static Account getNewlyCreatedAccount()
	{
		return account;
	}
}
