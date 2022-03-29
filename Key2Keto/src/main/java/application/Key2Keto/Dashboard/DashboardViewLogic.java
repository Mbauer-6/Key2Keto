package application.Key2Keto.Dashboard;

import java.util.ArrayList;

import application.Key2Keto.Account.Account;
import javafx.scene.control.CheckBox;

public class DashboardViewLogic {
	private static Dashboard dashboard;
	
	public static void setDashboard(Account acct) {
		DashboardViewLogic.dashboard = new Dashboard(acct);
	}

	public static Dashboard getDashboard() {
		return DashboardViewLogic.dashboard;
	}

	public static String populateDaysRecipe(int loc) {
		String recipeText = "";
		
			switch (loc) {
			case 0:
				if (dashboard.getUserAccount().getChosenRecipes().get(dashboard.getCurrentDayInt()).size() > 0 
						&& dashboard.getUserAccount().getChosenRecipes().get(dashboard.getCurrentDayInt()).get(0) != null) {
					recipeText = "Chosen Breakfast: " + dashboard.getUserAccount().getChosenRecipes()
							.get(dashboard.getCurrentDayInt()).get(0).getName();
				} else {
					recipeText = "Chosen Breakfast: Nothing Chosen";
				}
				break;
			case 1:
				if (dashboard.getUserAccount().getChosenRecipes().get(dashboard.getCurrentDayInt()).size() > 0 
						&& dashboard.getUserAccount().getChosenRecipes().get(dashboard.getCurrentDayInt()).get(1) != null) {
					recipeText = "Chosen Lunch: " + dashboard.getUserAccount().getChosenRecipes()
							.get(dashboard.getCurrentDayInt()).get(1).getName();
				} else {
					recipeText = "Chosen Lunch: Nothing Chosen";
				}
				break;
			case 2:
				if (dashboard.getUserAccount().getChosenRecipes().get(dashboard.getCurrentDayInt()).size() > 0 
						&& dashboard.getUserAccount().getChosenRecipes().get(dashboard.getCurrentDayInt()).get(2) != null) {
					recipeText = "Chosen Dinner: " + dashboard.getUserAccount().getChosenRecipes()
							.get(dashboard.getCurrentDayInt()).get(2).getName();
				} else {
					recipeText = "Chosen Dinner: Nothing Chosen";
				}
				break;
			case 3:
				if (dashboard.getUserAccount().getChosenRecipes().get(dashboard.getCurrentDayInt()).size() > 0 
						&& dashboard.getUserAccount().getChosenRecipes().get(dashboard.getCurrentDayInt()).get(3) != null) {
					recipeText = "Chosen Snack: " + dashboard.getUserAccount().getChosenRecipes()
							.get(dashboard.getCurrentDayInt()).get(3).getName();
				} else {
					recipeText = "Chosen Snack: Nothing Chosen";
				}
				break;
			default:
				System.out.println("Should not get here");
			}
		return recipeText;
	}
	
	public static boolean allGoalsCompleted(ArrayList<CheckBox> boxes) {
		int total = boxes.size();
		int count = 0;
		for(int i = 0; i<boxes.size();i++) {
			if(boxes.get(i).isSelected()) {
				count++;
			}
		}
		if(count == total) {
			return true;
		}else {
			return false;
		}	
	}
}
