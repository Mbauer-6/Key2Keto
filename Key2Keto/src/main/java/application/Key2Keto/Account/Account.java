package application.Key2Keto.Account;

import java.util.ArrayList;
import java.util.Arrays;

import application.Key2Keto.Recipes.Recipe;
import application.Key2Keto.Tracker.Tracker;

public class Account
{
	private String username;
	private String password;
	
	private String firstName;
	private String lastName;
	
	private String sex;
	private String height;
	private int weight;
	private int age;
	
	private String dietType;
	
	private ArrayList<Tracker> dayTrackers; //hours of sleep, water intake, goals for each day of the week
	private ArrayList<ArrayList<Recipe>> chosenRecipes; //2d array of chosen recipes; e.g. [0][1] = sunday's second recipe
	
	public Account()
	{
		username = "";
		password = "";
		
		firstName = "";
		lastName = "";
		
		sex = "";
		height = "";
		weight = 0;
		age = 0;
		
		dietType = "";
		
		dayTrackers = new ArrayList<Tracker>
		(
			Arrays.asList(new Tracker("Sunday"), new Tracker("Monday"), new Tracker("Tuesday"), new Tracker("Wednesday"),
					      new Tracker("Thursday"), new Tracker("Friday"), new Tracker("Saturday"))
		);
		
		chosenRecipes = new ArrayList<ArrayList<Recipe>>(
			Arrays.asList(new ArrayList<Recipe>(), new ArrayList<Recipe>(), new ArrayList<Recipe>(), new ArrayList<Recipe>(),
						  new ArrayList<Recipe>(), new ArrayList<Recipe>(), new ArrayList<Recipe>())
		);
	}
	
	public Account(String username, String password, String firstName, String lastName, String sex, String height, int weight, int age, String dietType)
	{
		this.username = username;
		this.password = password;
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		this.sex = sex;
		this.height = height;
		this.weight = weight;
		this.age = age;
		
		this.dietType = dietType;
		
		dayTrackers = new ArrayList<Tracker>
		(
			Arrays.asList(new Tracker("Sunday"), new Tracker("Monday"), new Tracker("Tuesday"), new Tracker("Wednesday"),
					      new Tracker("Thursday"), new Tracker("Friday"), new Tracker("Saturday"))
		);
		
		chosenRecipes = new ArrayList<ArrayList<Recipe>>(
			Arrays.asList(new ArrayList<Recipe>(), new ArrayList<Recipe>(), new ArrayList<Recipe>(), new ArrayList<Recipe>(),
						  new ArrayList<Recipe>(), new ArrayList<Recipe>(), new ArrayList<Recipe>())
		);
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public String getSex()
	{
		return this.sex;
	}
	
	public String getHeight()
	{
		return this.height;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public String getDietType()
	{
		return this.dietType;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public void setHeight(String height)
	{
		this.height = height;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setDietType(String dietType)
	{
		this.dietType = dietType;
	}
	
	public ArrayList<Tracker> getTrackers()
	{
		return this.dayTrackers;
	}
	
	public ArrayList<ArrayList<Recipe>> getChosenRecipes()
	{
		return this.chosenRecipes;
	}
	
	public void addRecipe(Recipe newRecipe, int day)
	{
		this.chosenRecipes.get(day).add(newRecipe);
	}
	
	public void removeRecipe(Recipe recipeToRemove, int day)
	{
		this.chosenRecipes.get(day).remove(this.chosenRecipes.get(day).indexOf(recipeToRemove));
	}
}
