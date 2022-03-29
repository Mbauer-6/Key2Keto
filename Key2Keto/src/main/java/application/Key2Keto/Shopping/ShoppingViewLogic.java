package application.Key2Keto.Shopping;

import java.util.ArrayList;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Recipes.Recipe;

public class ShoppingViewLogic {
	private static ArrayList<RestaurantMeals> restaurantMeals = new ArrayList<RestaurantMeals>();
	private static Account account;
	private static ArrayList<ArrayList<Recipe>> usersChosenRecipes = new ArrayList<ArrayList<Recipe>>();
	private static String dietType;
	private static RestaurantFileReader restFileReader;
	
	public static void setUserAccount(Account acct) {
		ShoppingViewLogic.account = acct;
	}

	public static Account getUserAccount() {
		return ShoppingViewLogic.account;
	}
	
	public static void setFileReader(String file) {
		ShoppingViewLogic.restFileReader = new RestaurantFileReader(file);
	}

	public static RestaurantFileReader getFileReader() {
		return ShoppingViewLogic.restFileReader;
	}
	
	public static void setUsersChosenRecipes(ArrayList<ArrayList<Recipe>> usersChosen) {
		ShoppingViewLogic.usersChosenRecipes = usersChosen;
	}
	
	public static void setDietType(String type) {
		ShoppingViewLogic.dietType = type;
	}
	
	public static ArrayList<ArrayList<Recipe>> getChosenRecipes(){
		return ShoppingViewLogic.usersChosenRecipes;
	}
	
	public static void setRestaurantMeals(ArrayList<RestaurantMeals> meals) {
		ShoppingViewLogic.restaurantMeals = meals;
	}
	public static ArrayList<RestaurantMeals> getRestMeals(){
		return ShoppingViewLogic.restaurantMeals;
	}
	
	public static String findRestaurantMeal(String restaurantName) {
		String mealName = "";
		for (int i = 0; i < ShoppingViewLogic.getRestMeals().size(); i++) {
			if (restaurantName.contentEquals(ShoppingViewLogic.getFileReader().getMeals().get(i).getRestaurantName())) {
				mealName = ShoppingViewLogic.getFileReader().getMeals().get(i).getMealName();
				break;
			}
		}
		if(mealName.contentEquals("")) {
			mealName = "Meal Not Found";
		}
		return mealName;
	}

	public static ArrayList<String> getRestaurantNames(ArrayList<RestaurantMeals> meals, String diet){
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i = 0;i<meals.size(); i++) {
			if(meals.get(i).getDietType().contentEquals(diet)) {
				temp.add(meals.get(i).getRestaurantName());
			}
		}
		return temp;
	}
	
	public static ArrayList<String> populateIngredientsForDay(ArrayList<Recipe> recipes) {
		ArrayList<String> temp = new ArrayList<String>();
		if(recipes != null) {
			for(int i = 0; i<recipes.size();i++) {
				if(recipes.get(i)!=null) {
					for(int j =0; j<recipes.get(i).getIngredient().size();j++) {
						temp.add(recipes.get(i).getIngredient().get(j).toString());
					}	
				}
			}
		}

		return temp;
	}
	
	public static double totalFat(ArrayList<Recipe> recipes) {
		double total = 0;
		for(int i = 0; i <recipes.size(); i++) {
			if(recipes.get(i)!=null) {
				total += recipes.get(i).getTotalFat();
			}
		}
		return total;
	}
	
	public static double totalCarb(ArrayList<Recipe> recipes) {
		double total = 0;
		for(int i = 0; i <recipes.size(); i++) {
			if(recipes.get(i)!=null) {
				total += recipes.get(i).getTotalCarb();
			}
		}
		return total;
	}
	
	public static double totalProtein(ArrayList<Recipe> recipes) {
		double total = 0;
		for(int i = 0; i <recipes.size(); i++) {
			if(recipes.get(i)!=null) {
				total += recipes.get(i).getTotalProtein();
			}
		}
		return total;
	}
}