package application.Key2Keto.Recipes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import application.Key2Keto.Account.Account;

public class DayOfWeekLogic {
	private static RecipeList recipeList = new RecipeList();
	private static Account account;

	// USER ACCOUNT ITEMS
	public static void setUserAccount(Account acct) {
		DayOfWeekLogic.account = acct;
	}

	public static Account getUserAccount() {
		return DayOfWeekLogic.account;
	}

	public static void addToUsersChosenRecipes(ArrayList<String> recipes, int day) {

		account.getChosenRecipes().get(day).clear();
		
			account.addRecipe(null, day);
			account.addRecipe(null, day);
			account.addRecipe(null, day);
			account.addRecipe(null, day);
		
		for (int i = 0; i < recipeList.getRecipeList().size(); i++) {

			if (recipeList.getRecipeList().get(i).getName().contentEquals(recipes.get(0))) {
				account.getChosenRecipes().get(day).set(0, recipeList.getRecipeList().get(i));
			}

			if (recipeList.getRecipeList().get(i).getName().contentEquals(recipes.get(1))) {
				account.getChosenRecipes().get(day).set(1, recipeList.getRecipeList().get(i));
			}

			if (recipeList.getRecipeList().get(i).getName().contentEquals(recipes.get(2))) {
				account.getChosenRecipes().get(day).set(2, recipeList.getRecipeList().get(i));
			}

			if (recipeList.getRecipeList().get(i).getName().contentEquals(recipes.get(3))) {
				account.getChosenRecipes().get(day).set(3, recipeList.getRecipeList().get(i));
			}
		}
	}

	public static void addRecipeListToClass(RecipeList recipeList) {
		DayOfWeekLogic.recipeList = recipeList;
	}

	public static RecipeList getRecipeList() {
		return recipeList;
	}

	public static ArrayList<Recipe> getDaysRecipes(int day) {
		return account.getChosenRecipes().get(day);
	}

	public static ArrayList<String> getBreakfastRecipes() {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < recipeList.breakfastRecipes().size(); i++) {
			temp.add(recipeList.breakfastRecipes().get(i).getName());
		}

		return temp;
	}

	public static ArrayList<String> getEntreeRecipes() {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < recipeList.entreeRecipes().size(); i++) {
			temp.add(recipeList.entreeRecipes().get(i).getName());
		}

		return temp;
	}

	public static ArrayList<String> getSnackRecipes() {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < recipeList.snackRecipes().size(); i++) {
			temp.add(recipeList.snackRecipes().get(i).getName());
		}

		return temp;
	}
	
	public static int getDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		Calendar LATime = new GregorianCalendar(TimeZone.getTimeZone("America/Chicago"));
		LATime.setTimeInMillis(calendar.getTimeInMillis());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

		return dayOfWeek;
	}

}
