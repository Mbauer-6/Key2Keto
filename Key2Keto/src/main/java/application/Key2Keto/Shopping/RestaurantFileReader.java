package application.Key2Keto.Shopping;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import application.Key2Keto.Interfaces.FileReaderInterface;

public class RestaurantFileReader implements FileReaderInterface {
	private Scanner sc;
	private Scanner strScan;
	private ArrayList<RestaurantMeals> restaurantMeals = new ArrayList<RestaurantMeals>();

	public RestaurantFileReader(String fileName) {
		readFile(fileName);
	}

	public ArrayList<RestaurantMeals> getMeals(){
		return this.restaurantMeals;
	}
	
	@Override
	public void readFile(String fileName) {
		try {
			File file = new File(fileName);
			sc = new Scanner(file);
			String dietType = "";
			String restName = "";
			String mealName = "";
			String cal = "";
			String fat = "";
			String carbs = "";
			String pro = "";

			while (sc.hasNextLine()) {
				strScan = new Scanner(sc.nextLine());
				strScan.useDelimiter(",");
				dietType = strScan.next();
				restName = strScan.next();
				mealName = strScan.next();
				cal = strScan.next();
				fat = strScan.next();
				carbs = strScan.next();
				pro = strScan.next();
				RestaurantMeals meal = new RestaurantMeals(dietType, restName, mealName, Integer.parseInt(cal),
						Double.parseDouble(fat), Double.parseDouble(carbs), Double.parseDouble(pro));
				this.restaurantMeals.add(meal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			strScan.close();
			sc.close();
		}
	}
}
