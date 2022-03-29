package application.Key2Keto.Recipes;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

class RecipeTest extends ApplicationTest {	
	Recipe recipe;
	Ingredient ingredient;

	@Test
	void test() throws MalformedURLException {
		recipe = new Recipe("Breakfast", "Chocolate Chip Cookies", 200, 20.5, 15.5, 10.5, 4, "C", 11);
		ingredient = new Ingredient("Chocolate Chips", "1/4 cup");
		recipe.addIngredient(ingredient);
		recipe.addInstruction("Eat the cookie");
		assertEquals("Eat the cookie", recipe.getInstruction().get(0));
		assertEquals(200, recipe.getTotalCalories());
		assertEquals(20.5, recipe.getTotalCarb());
		assertEquals(15.5, recipe.getTotalProtein());
		assertEquals(10.5, recipe.getTotalFat());
		assertEquals(4, recipe.getDietRatio());
		assertEquals("Breakfast", recipe.getType());
	}

}
