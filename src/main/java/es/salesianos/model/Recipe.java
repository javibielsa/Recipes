package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

	private String name;

	private List<Ingredient> ingredients;

	private List<CookingTool> tools;

	public Recipe() {
		ingredients = new ArrayList<Ingredient>();
		tools = new ArrayList<CookingTool>();
	}

}
