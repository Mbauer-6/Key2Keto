package application.Key2Keto.Recipes;

public class Ingredient {
	private String name="";
	private String serveSize ="";
	
	public Ingredient(String name, String serveSize){
		this.name = name;
		this.serveSize = serveSize;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setServingSize(String serveSize) {
		this.serveSize = serveSize;
	}
	
	public String getServingSize() {
		return this.serveSize;
	}
	
	public String toString() {
		return this.serveSize+ " "+this.name;
	}
}
