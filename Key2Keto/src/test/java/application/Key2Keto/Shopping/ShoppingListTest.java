package application.Key2Keto.Shopping;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.ITextExtractionStrategy;
import com.itextpdf.kernel.pdf.canvas.parser.listener.SimpleTextExtractionStrategy;

import application.Key2Keto.Recipes.*;

public class ShoppingListTest extends ApplicationTest
{	
	@Test
	public void shoppingListBuildsCorrectlyTest() throws MalformedURLException
	{	
		ArrayList<ArrayList<Recipe>> testRecipeList = new ArrayList<ArrayList<Recipe>>();
		ArrayList<Recipe> firstRecipes = new ArrayList<Recipe>();
		firstRecipes.add(new Recipe("recipetype1", "recipename1", 55, 20.0, 15.7, 12.3, 4.0, "Classic", 0));
		ArrayList<Recipe> secondRecipes = new ArrayList<Recipe>();
		secondRecipes.add(new Recipe("recipetype2", "recipename2", 56, 18.3, 22.2, 33.2, 3.5, "Modified", 0));
		ArrayList<Recipe> thirdRecipes = new ArrayList<Recipe>();
		thirdRecipes.add(new Recipe("recipetype3", "recipename3", 58, 12.4, 9.5, 10.2, 2.3, "Modified", 0));
		testRecipeList.add(firstRecipes);
		testRecipeList.add(secondRecipes);
		testRecipeList.add(thirdRecipes);
		
		ShoppingListForTests sut = new ShoppingListForTests(testRecipeList);
		
		for(ArrayList<Recipe> recipeList : sut.getRecipes())
		{
			for(Recipe recipe : recipeList)
			{
				recipe.addIngredient(new Ingredient("ingredient", "servesize"));
			}
		}
		
		assertEquals("recipetype1", sut.getRecipes().get(0).get(0).getType());
		assertEquals("recipename1", sut.getRecipes().get(0).get(0).getName());
		assertEquals(56, sut.getRecipes().get(1).get(0).getTotalCalories());
		assertEquals(18.3, sut.getRecipes().get(1).get(0).getTotalCarb());
		assertEquals(9.5, sut.getRecipes().get(2).get(0).getTotalProtein());
		assertEquals(10.2, sut.getRecipes().get(2).get(0).getTotalFat());
		assertEquals(2.3, sut.getRecipes().get(2).get(0).getDietRatio());
		assertEquals("ingredient", sut.getRecipes().get(2).get(0).getIngredient().get(0).getName());
		assertEquals("servesize", sut.getRecipes().get(0).get(0).getIngredient().get(0).getServingSize());
	}
	
	@Test
	public void shoppingListFileIsCreatedTest() throws MalformedURLException
	{
		ArrayList<ArrayList<Recipe>> testRecipeList = new ArrayList<ArrayList<Recipe>>();
		ArrayList<Recipe> firstRecipes = new ArrayList<Recipe>();
		firstRecipes.add(new Recipe("recipetype1", "recipename1", 55, 20.0, 15.7, 12.3, 4.0, "Classic", 0));
		ArrayList<Recipe> secondRecipes = new ArrayList<Recipe>();
		secondRecipes.add(new Recipe("recipetype2", "recipename2", 56, 18.3, 22.2, 33.2, 3.5, "Modified", 0));
		ArrayList<Recipe> thirdRecipes = new ArrayList<Recipe>();
		thirdRecipes.add(new Recipe("recipetype3", "recipename3", 58, 12.4, 9.5, 10.2, 2.3, "Modified", 0));
		testRecipeList.add(firstRecipes);
		testRecipeList.add(secondRecipes);
		testRecipeList.add(thirdRecipes);
		
		ShoppingListForTests sut = new ShoppingListForTests(testRecipeList);
		
		File shoppingList = new File("ShoppingList.pdf");
		assertTrue(shoppingList.exists());
	}
	
	@Test
	public void writingToPdfWorksTest() throws MalformedURLException
	{
		PdfReader reader = null;
		PdfDocument pdfDocument = null;
		ArrayList<ArrayList<Recipe>> testRecipeList = new ArrayList<ArrayList<Recipe>>();
		ArrayList<Recipe> firstRecipes = new ArrayList<Recipe>();
		firstRecipes.add(new Recipe("recipetype1", "nametotest", 23, 53.2, 55.3, 17.8, 4.0, "Classic", 0));
		testRecipeList.add(firstRecipes);
		
		ShoppingListForTests sut = new ShoppingListForTests(testRecipeList);
		
		try
		{
			reader = new PdfReader("ShoppingList.pdf");
			pdfDocument = new PdfDocument(reader);
			ITextExtractionStrategy strategy = new SimpleTextExtractionStrategy();
			
			String pdfContent = PdfTextExtractor.getTextFromPage(pdfDocument.getPage(1), strategy);
			
			assertEquals("Recipe: nametotest | 23 Calories | 53.2g Carbs | 55.3g Protein | 17.8g Fat", pdfContent);
		}
		
		catch(IOException io)
		{
			System.out.println("ERROR: issue reading file");
		}
		
		finally
		{
			try
			{
				reader.close();
				pdfDocument.close();
			}
			
			catch(IOException io)
			{
				System.out.println("ERROR: issue closing file");
			}
		}
	}
}
