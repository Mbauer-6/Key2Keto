package application.Key2Keto.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import application.Key2Keto.Recipes.Recipe;
import application.Key2Keto.Tracker.Tracker;

public class AccountSaver
{
	public static void saveAccount(Account account)
	{		
		FileWriter saver = null;
		int currentDay = 0;
		
		try
		{
			saver = new FileWriter(account.getUsername() + ".txt");
			
			saver.write(account.getUsername() + "," + account.getPassword() + "\n");
			saver.write(account.getFirstName() + "," + account.getLastName() + "\n");
			saver.write(account.getSex() + "," + account.getHeight() + "," + account.getWeight() + "," + account.getAge() + "\n");
			saver.write(account.getDietType() + "\n");
			
			saver.write("Trackers\n");
			
			for(Tracker tracker : account.getTrackers())
			{
				saver.write(tracker.getDayOfWeek() + "\n");
				
				if(tracker.getGoals().size() == 0)
				{
					saver.write("no goals" + "\n");
				}
				
				for(String goal : tracker.getGoals())
				{
					//saver.write(goal + ",");
					
					if(tracker.getGoals().indexOf(goal) == tracker.getGoals().size() - 1)
					{
						saver.write(goal + "\n");
					}
					
					else
					{
						saver.write(goal + ",");
					}
				}
				
				saver.write(tracker.getHoursOfSleep() + "," + tracker.getWaterIntake() + "\n");
			}
			
			saver.write("Recipes\n");
			
			for(ArrayList<Recipe> chosenRecipesForDay : account.getChosenRecipes())
			{
				saver.write(intDayToString(currentDay++) + "\n");
				
				if(chosenRecipesForDay.size() == 0)
				{
					saver.write("no recipes" + "\n");
				}
				
				int recipeNum = 0;
				
				for(Recipe chosenRecipe : chosenRecipesForDay)
				{
					if(chosenRecipe != null)
					{
						//saver.write(chosenRecipe.getName() + ",");
						
						if(recipeNum == chosenRecipesForDay.size() - 1) //if this is the last recipe
						{
							saver.write(chosenRecipe.getName() + "\n"); //don't write a comma
						}
						
						else
						{
							saver.write(chosenRecipe.getName() + ",");
						}
					}
					
					else
					{
						if(recipeNum == chosenRecipesForDay.size() - 1) //if this is the last recipe
						{
							saver.write("nothing chosen" + "\n"); //don't write a comma
						}
						
						else
						{
							saver.write("nothing chosen" + ",");
						}
					}
					
					recipeNum++;
				}
			}
			
			saver.close();
		}
		
		catch(IOException io)
		{
			io.printStackTrace();
		}
	}
	
	private static String intDayToString(int day)
	{
		switch(day)
		{
			case 0:
				return "Sunday";
			case 1:
				return "Monday";
			case 2:
				return "Tuesday";
			case 3:
				return "Wednesday";
			case 4:
				return "Thursday";
			case 5:
				return "Friday";
			case 6:
				return "Saturday";
			default:
				return "";
		}
	}
}
