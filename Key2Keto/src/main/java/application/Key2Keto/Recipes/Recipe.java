package application.Key2Keto.Recipes;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class Recipe {
	private String name = "";
	private ArrayList<Ingredient> ingredients;
	private double totalCarb = 0;
	private double totalProtein = 0;
	private double totalFat = 0;
	private double dietRatio = 0;
	private ArrayList<String> instructions;
	private int totalCalories = 0;
	private String type = "";
	private String dietType;
	private Image image;
	
	public Recipe(String type, String name, int calories, double carb, double protein, double fat, double ratio, String dietType) {
		this.name = name;
		this.dietRatio = ratio;
		this.totalCarb = carb;
		this.totalFat = fat;
		this.totalProtein = protein;
		this.totalCalories = calories;
		this.type = type;
		this.dietType = dietType;
		this.ingredients = new ArrayList<Ingredient>(0);
		this.instructions = new ArrayList<String>(0);
	}

	public Recipe(String type, String name, int calories, double carb, double protein, double fat, double ratio, String dietType, int imageNum) throws MalformedURLException {
		this.ingredients = new ArrayList<Ingredient>();
		this.instructions = new ArrayList<String>();
		this.name = name;
		this.dietRatio = ratio;
		this.totalCarb = carb;
		this.totalFat = fat;
		this.totalProtein = protein;
		this.totalCalories = calories;
		this.type = type;
		this.dietType = dietType;
		setImage(imageNum);
	}
	
	public void setImage(int imageNum) throws MalformedURLException {
		File file = new File("./src/main/java/application/Key2Keto/RecipeImages/" + this.dietType + imageNum + ".png");
		String imagePath = file.toURI().toURL().toExternalForm();
		this.image = new Image(imagePath, 130, 130, false, false);
	}
	
	public Image getImage() {
		return this.image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotalCarb(double totalCarb) {
		this.totalCarb = totalCarb;
	}

	public double getTotalCarb() {
		return this.totalCarb;
	}

	public void setTotalFat(double totalFat) {
		this.totalFat = totalFat;
	}

	public double getTotalFat() {
		return this.totalFat;
	}

	public void setTotalProtein(double totalProtein) {
		this.totalProtein = totalProtein;
	}

	public double getTotalProtein() {
		return this.totalProtein;
	}

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void addIngredient(Ingredient ing) {
		this.ingredients.add(ing);
	}

	public void addInstruction(String string) {
		this.instructions.add(string);
	}

	public ArrayList<Ingredient> getIngredient() {
		return this.ingredients;
	}

	public ArrayList<String> getInstruction() {
		return this.instructions;
	}

	public void setDietRatio(double dietRatio) {
		this.dietRatio = dietRatio;
	}

	public double getDietRatio() {
		return this.dietRatio;
	}
	
	public int getTotalCalories() {
		return this.totalCalories;
	}
	public String listedIngredients() {
		String listOfIngredients="";
		for(int i = 0; i<this.ingredients.size();i++) {
			if(i == this.ingredients.size()-1) {
				listOfIngredients = listOfIngredients.concat((i+1)+". "+this.ingredients.get(i));
			}else {
				listOfIngredients = listOfIngredients.concat((i+1)+". "+this.ingredients.get(i)+"\n");
			}
		}
		return listOfIngredients;
	}
	
	public String listedInstructions() {
		String listOfInstructions="";
		for(int i = 0; i<this.instructions.size();i++) {
			if(i == this.instructions.size()-1) {
				listOfInstructions = listOfInstructions.concat((i+1)+". "+this.instructions.get(i));
			}else {
				listOfInstructions = listOfInstructions.concat((i+1)+". "+this.instructions.get(i)+"\n");
			}
		}
		return listOfInstructions;
	}
	public String toString() {

		return this.name+"\nTotal Calories: " +this.totalCalories+"\nTotal Carbs: "+ this.totalCarb+"\n"
				+ "Total Protein: "+this.totalProtein+"\nTotal Fats: "+this.totalFat+"\n"
				+ "Ingredients: "+ this.listedIngredients()+"\nInstructions: "+this.listedInstructions()+"\n"
				+ "Diet Ratio: "+ this.dietRatio;
	}
}