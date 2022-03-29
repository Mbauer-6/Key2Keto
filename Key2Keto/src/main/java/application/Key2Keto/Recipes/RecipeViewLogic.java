package application.Key2Keto.Recipes;

import application.Key2Keto.Account.Account;

public class RecipeViewLogic {
	private static Account account;
	private static RecipeFileReader fileReader;
	
	public static void setUserAccount(Account acct) {
		RecipeViewLogic.account = acct;
	}

	public static Account getUserAccount() {
		return RecipeViewLogic.account;
	}
	
	public static void setFileReader(String file) {
		RecipeViewLogic.fileReader = new RecipeFileReader(file);
	}

	public static RecipeFileReader getFileReader() {
		return RecipeViewLogic.fileReader;
	}

	
}
