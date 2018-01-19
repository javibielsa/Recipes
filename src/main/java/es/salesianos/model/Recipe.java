package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

	private String name;

	private List<Ingredient> ingredients;

	private List<CookingTool> tools;

	public Recipe() {
		setIngredients(new ArrayList<Ingredient>());
		setTools(new ArrayList<CookingTool>());
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<CookingTool> getTools() {
		return tools;
	}

	public void setTools(List<CookingTool> tools) {
		this.tools = tools;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
