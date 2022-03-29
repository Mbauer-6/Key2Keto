package application.Key2Keto.Recipes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

class RecipeFileReaderTest extends ApplicationTest {

	private RecipeFileReader fileReader;
	
	@Test
	public void test() {
		fileReader = new RecipeFileReader("./src/main/java/application/Key2Keto/Recipes/ModifiedKeto.txt");
		
		assertEquals(16,fileReader.getRecipeList().getRecipeList().size());
	}

}

