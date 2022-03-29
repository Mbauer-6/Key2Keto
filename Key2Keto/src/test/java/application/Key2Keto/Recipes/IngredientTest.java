package application.Key2Keto.Recipes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IngredientTest {
	private Ingredient ing;
	@Test
	void test() {
		ing = new Ingredient("Chocolate Chips", "1/4 cup");
		assertEquals("Chocolate Chips", ing.getName());
		assertEquals("1/4 cup", ing.getServingSize());
		assertEquals("1/4 cup", ing.getServingSize());
		assertEquals("1/4 cup Chocolate Chips", ing.toString());
	}

}
