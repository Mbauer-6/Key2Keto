package application.Key2Keto.Account;

public class AccountViewLogic
{
	private static String errorMessage;
	private static Account account;
	
	public static boolean checkNewVariableIsValid(String accountDetailToChange, String newDetailString)
	{
		switch(accountDetailToChange)
		{
			case "Username":
				if(newDetailString.equals(""))
				{
					errorMessage = "Username field must not be empty";
					return false;
				}
				
				else
				{
					return true;
				}
				
			case "Password":
				if(newDetailString.equals(""))
				{
					errorMessage = "Password field must not be empty";
					return false;
				}
				
				else
				{
					return true;
				}

			case "Name":
				if(newDetailString.equals(""))
				{
					errorMessage = "Name field must not be empty";
					return false;
				}
				
				else if(!newDetailString.matches("^[A-Za-z]+\\s[A-Za-z]+$"))
				{
					errorMessage = "Name must be two words containing only letters";
					return false;
				}
				
				else
				{
					return true;
				}

			case "Sex":
				if(newDetailString == null)
				{
					errorMessage = "A sex must be chosen";
					return false;
				}
				
				else
				{
					return true;
				}

			case "Height":
				if(newDetailString.equals(""))
				{
					errorMessage = "Height field must not be empty";
					return false;
				}
				
				else if(!newDetailString.matches("^([0-9]*'([0-9]\"|(1[0-1])\"))|([0-9]*')$"))
				{
					errorMessage = "Height must be expressed in the form ft'in\" or ft'";
					return false;
				}
				
				else
				{
					return true;
				}
				
			case "Weight":
				if(newDetailString.equals(""))
				{
					errorMessage = "Weight field must not be empty";
					return false;
				}
				
				else if(!newDetailString.matches("^[0-9]*$"))
				{
					errorMessage = "Weight must only contain digits";
					return false;
				}
				
				else
				{
					return true;
				}

			case "Age":
				if(newDetailString.equals(""))
				{
					errorMessage = "Age field must not be empty";
					return false;
				}
				
				else if(!newDetailString.matches("^[0-9]*$"))
				{
					errorMessage = "Age must only contain digits";
					return false;
				}
				
				else
				{
					return true;
				}

			case "DietType":
				if(newDetailString == null)
				{
					errorMessage = "A diet type must be chosen";
					return false;
				}
				
				else
				{
					return true;
				}

			default:
				return false;
		}
	}
	
	public static String getErrorMessage()
	{
		return errorMessage;
	}
	
	public static Account getAccount()
	{
		return account;
	}
	
	public static void setAccount(Account newAccount)
	{
		account = newAccount;
	}
}
