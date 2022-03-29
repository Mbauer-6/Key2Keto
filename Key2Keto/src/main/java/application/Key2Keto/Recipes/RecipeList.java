package application.Key2Keto.Recipes;

import java.util.ArrayList;

public class RecipeList {
	private ArrayList<Recipe> recipeList;
	
	public RecipeList() {
		this.recipeList = new ArrayList<Recipe>();
	}
	public void addRecipe(Recipe recipe) {
		this.recipeList.add(recipe);
	}
	
	public ArrayList<Recipe> getRecipeList() {
		return this.recipeList;
	}
	public void setRecipeList(ArrayList<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
	//get a single recipe
	public Recipe singleRecipe() {
		return this.recipeList.get(0);
	}
	public int setListSize() {
		return this.recipeList.size();
	}

	public ArrayList<Recipe> entreeRecipes(){
		ArrayList<Recipe> temp = new ArrayList<Recipe>();
		for(int i=0;i<this.recipeList.size();i++) {
			if(this.recipeList.get(i).getType().contentEquals("Entrees")) {
				temp.add(this.recipeList.get(i));
			}
		}
		return temp;
	}
	public ArrayList<Recipe> breakfastRecipes(){
		ArrayList<Recipe> temp = new ArrayList<Recipe>();
		for(int i=0;i<this.recipeList.size();i++) {
			if(this.recipeList.get(i).getType().contentEquals("Breakfast")) {
				temp.add(this.recipeList.get(i));
			}
		}
		return temp;
	}
	
	public ArrayList<Recipe> snackRecipes(){
		ArrayList<Recipe> temp = new ArrayList<Recipe>();
		for(int i=0;i<this.recipeList.size();i++) {
			if(this.recipeList.get(i).getType().contentEquals("Snacks")) {
				temp.add(this.recipeList.get(i));
			}
		}
		return temp;
	}
}
