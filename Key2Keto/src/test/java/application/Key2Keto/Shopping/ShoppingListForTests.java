package application.Key2Keto.Shopping;

import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document; 
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import application.Key2Keto.Interfaces.ShoppingListInterface;
import application.Key2Keto.Recipes.Ingredient;
import application.Key2Keto.Recipes.Recipe;
import javafx.stage.Stage;

public class ShoppingListForTests implements ShoppingListInterface
{
	private ArrayList<ArrayList<Recipe>> recipes;
	
	private String currentRecipeInfo;
	private String currentIngredientInfo;
	
	private ArrayList<String> shoppingListRecipes;
	private ArrayList<String> shoppingListIngredients;
	
	public ShoppingListForTests(ArrayList<ArrayList<Recipe>> recipes)
	{
		this.recipes = new ArrayList<ArrayList<Recipe>>(recipes);
		currentRecipeInfo = "";
		currentIngredientInfo = "";
		
		shoppingListRecipes = new ArrayList<String>();
		shoppingListIngredients = new ArrayList<String>();
		
		generateStrings();
	}
	
	public ArrayList<ArrayList<Recipe>> getRecipes()
	{
		return recipes;
	}
	
	public void generateStrings() //helper function to "toString()" recipes and ingredients in a format that looks good
	{
		for(ArrayList<Recipe> recipeList : recipes)
		{
			for(Recipe recipe : recipeList)
			{
				currentRecipeInfo = "Recipe: " + recipe.getName() + " | " + recipe.getTotalCalories()
								  + " Calories | " + recipe.getTotalCarb() + "g Carbs | " + recipe.getTotalProtein()
								  + "g Protein | " + recipe.getTotalFat() + "g Fat";
				
				shoppingListRecipes.add(currentRecipeInfo);
				
				for(Ingredient ingredient : recipe.getIngredient())
				{
					currentIngredientInfo = ingredient.toString();
					
					shoppingListIngredients.add(currentIngredientInfo);
				}
				
				shoppingListIngredients.add(","); //delimiter
			}
		}
		
		generateShoppingList();
	}
	
	public void generateShoppingList() //helper function that uses iText to create and format a PDF for printing
	{		
		int currentIngredientIndex = 0;
		Document shoppingListDocument = null;
		
		try
		{
			PdfWriter PDFWriter = new PdfWriter("ShoppingList.pdf");
			PdfDocument pdf = new PdfDocument(PDFWriter);
			
			shoppingListDocument = new Document(pdf);
			
			for(int i = 0; i < shoppingListRecipes.size(); i++)
			{
				shoppingListDocument.add(new Paragraph(shoppingListRecipes.get(i)));
				
				for(int j = currentIngredientIndex; j < shoppingListIngredients.size(); j++)
				{	
					if(shoppingListIngredients.get(j).equals(","))
					{
						currentIngredientIndex++;
						break; //comma reached; end of current recipe's list of ingredients
					}
					
					shoppingListDocument.add(new Paragraph("- " + shoppingListIngredients.get(j)));
					currentIngredientIndex++;
				}
			}
		}
		
		catch(FileNotFoundException fileNotFound)
		{
			System.out.println("ERROR: file not found");
		}
		
		finally
		{
			shoppingListDocument.close();
		}
	}
}