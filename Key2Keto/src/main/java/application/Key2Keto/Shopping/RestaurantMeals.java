package application.Key2Keto.Shopping;

public class RestaurantMeals {
	private String dietType;
	private String restaurantName;
	private String mealName;
	private int calories;
	private double fat;
	private double carbs;
	private double protein;
	
	public RestaurantMeals(String dietType, String restaurantName, String mealName, int calories, double fat, double carbs, double protein) {
		this.dietType = dietType;
		this.restaurantName = restaurantName;
		this.mealName = mealName;
		this.calories = calories;
		this.fat = fat;
		this.carbs = carbs;
		this.protein = protein;
	}
	
	public void setDietType(String type) {
		this.dietType = type;
	}
	
	public String getDietType() {
		return this.dietType;
	}
	
	public void setRestaurantName(String name) {
		this.restaurantName = name;
	}
	
	public String getRestaurantName() {
		return this.restaurantName;
	}
	
	public void setMealName(String name) {
		this.mealName = name;
	}
	
	public String getMealName() {
		return this.mealName;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public int getCalories() {
		return this.calories;
	}
	
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getFat() {
		return this.fat;
	}
	
	public void setCarbs(double carb) {
		this.carbs = carb;
	}
	public double getCarbs() {
		return this.carbs;
	}
	
	public void setProtein(double protein) {
		this.protein = protein;
	}
	
	public double getProtein() {
		return this.protein;
	}
	
	public String toString() {
		return "Restaurant Name: "+this.restaurantName+" Meal Name: "+this.mealName+" Total Calories: "+this.calories+" Total Fat: "
				+this.fat+" Total Carbs: "+this.carbs+" Total Protein: "+this.protein;
	}
}
