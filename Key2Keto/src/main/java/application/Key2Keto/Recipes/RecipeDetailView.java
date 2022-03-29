package application.Key2Keto.Recipes;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RecipeDetailView extends Pane {
	private Recipe recipe;
	private Label nameLabel;
	private Label carbLabel;
	private Label proteinLabel;
	private Label fatLabel;
	private Label ratioLabel;
	private Label ingredientsLabel;
	private Label totalCaloriesLabel;
	private Label instructionsLabel;
	private Label insTitle;
	private Label ingTitle;
	private VBox vbox;
	private HBox hbox;
	private VBox upper;
	private VBox lower;
	private Button imageButton;
	private Image image;
	private ImageView imageView;
	
	public RecipeDetailView(Recipe recipe) {
		this.recipe = recipe;
		initializeVariables();
		stylingOfVariables();
		populateChildren();
		this.getChildren().add(vbox);
	}
	
	public void initializeVariables(){
		this.vbox = new VBox();
		this.lower = new VBox();
		this.upper = new VBox();
		this.hbox = new HBox();
		this.imageButton = new Button("");
		this.image = this.recipe.getImage();
		this.imageView = new ImageView(image);
		this.nameLabel = new Label(this.recipe.getName());
		this.carbLabel = new Label(String.valueOf("Total Carbohydrates: " +this.recipe.getTotalCarb()));
		this.proteinLabel = new Label("Total Protein: " + String.valueOf(this.recipe.getTotalProtein()));
		this.fatLabel = new Label("Total Fat: " + String.valueOf(this.recipe.getTotalFat()));
		this.ratioLabel = new Label(String.valueOf("Recipe Ratio: "+ this.recipe.getDietRatio()+"/1"));
		this.totalCaloriesLabel = new Label("Total Calories: "+String.valueOf(this.recipe.getTotalCalories()));
		
		this.ingTitle = new Label("Ingredients");
		this.ingredientsLabel = new Label(this.recipe.listedIngredients());
		this.ingredientsLabel.setWrapText(true);
		this.ingredientsLabel.setId("DetailLabels");
		
		this.insTitle = new Label("Instructions");
		this.instructionsLabel = new Label(this.recipe.listedInstructions());
		this.instructionsLabel.setWrapText(true);
		this.instructionsLabel.setId("DetailLabels");
	}
	
	
	public void stylingOfVariables() {
		this.setPrefWidth(480);
		this.vbox.setPrefSize(480, 500);
		this.vbox.setId("DetailBackground");
		this.hbox.setPrefSize(480, 125);
		this.hbox.setId("DetailBackground");
		
		this.nameLabel.setPrefWidth(350);
		this.nameLabel.setWrapText(true);
		this.nameLabel.setId("DetailLargeLabels");
		//this.nameLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.carbLabel.setPrefWidth(400);
		this.carbLabel.setId("DetailLabels");
		
		this.totalCaloriesLabel.setPrefWidth(400);
		this.totalCaloriesLabel.setId("DetailLabels");
		
		this.proteinLabel.setPrefWidth(400);
		this.proteinLabel.setId("DetailLabels");
		
		this.ratioLabel.setPrefWidth(400);
		this.ratioLabel.setId("DetailLabels");
		
		this.fatLabel.setPrefWidth(400);
		this.fatLabel.setId("DetailLabels");
		
		this.ingTitle.setPrefWidth(400);
		this.ingTitle.setId("DetailLargeLabels");
		this.insTitle.setPrefWidth(400);
		this.insTitle.setId("DetailLargeLabels");
		
		this.imageButton.setPrefSize(130,130);
		this.imageButton.setAlignment(Pos.CENTER);
		
		this.imageView.setFitHeight(130);
		this.imageView.setFitWidth(130);
		
		this.imageButton.setGraphic(this.imageView);
		
		this.upper.setPrefWidth(350);
		this.upper.setId("DetailBackground");
		VBox.setMargin(nameLabel, new Insets(0, 0, 0, 0));
		VBox.setMargin(carbLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(proteinLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(fatLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(ratioLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(totalCaloriesLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(ingredientsLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(instructionsLabel, new Insets(0, 0, 0, 20));
	}
	
	public void populateChildren() {
		this.upper.getChildren().addAll(nameLabel,ratioLabel,totalCaloriesLabel,carbLabel,proteinLabel,fatLabel);
		this.hbox.getChildren().addAll(this.upper,this.imageButton);
		this.lower.getChildren().addAll(ingTitle,ingredientsLabel,insTitle,instructionsLabel);
		this.vbox.getChildren().addAll(this.hbox,lower);
	}
	
	protected ArrayList<Label> getDetailLabels(){
		ArrayList<Label> labelsToTest = new ArrayList<Label>();
		labelsToTest.addAll(new ArrayList<Label>(Arrays.asList(this.nameLabel, this.ratioLabel, this.totalCaloriesLabel,
				this.carbLabel, this.proteinLabel, this.fatLabel)));
		
		return labelsToTest;
	}
}
