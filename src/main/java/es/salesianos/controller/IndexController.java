package es.salesianos.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.CookingTool;
import es.salesianos.model.Ingredient;
import es.salesianos.model.Recipe;


@Controller
public class IndexController {

	private static Logger log = LogManager.getLogger(IndexController.class);

	private List<CookingTool> cookingTools = new ArrayList<CookingTool>();
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	@GetMapping("/")
	public ModelAndView index() {
		cookingTools.clear();
		ingredients.clear();
		Recipe recipe = new Recipe();
		ModelAndView modelAndView = new ModelAndView("index", "command", recipe);
		modelAndView.addObject("recipe", recipe);
		return modelAndView;
	}

	@PostMapping("recipeInsert")
	public ModelAndView recipeInsert(Recipe recipe) {
		log.debug("recipeInsert:" + recipe.toString());
		ModelAndView modelAndView = new ModelAndView("index", "command", recipe);
		addPageData(recipe, modelAndView);
		return modelAndView;
	}

	private void addPageData(Recipe recipe, ModelAndView modelAndView) {
		modelAndView.addObject("recipe", recipe);
		modelAndView.addObject("name", recipe.getName());
		modelAndView.addObject("ingredients", getIngredients());
		modelAndView.addObject("cookingTools", getCookingTools());
	}

	@PostMapping("ingredientInsert")
	public ModelAndView ingredientInsert(Recipe recipe) {
		log.debug("ingredientInsert:" + recipe.toString());

		Ingredient ingredient = new Ingredient();
		ingredient.setName(recipe.getIngredientName());
		getIngredients().add(ingredient);

		ModelAndView modelAndView = new ModelAndView("index", "command", recipe);
		addPageData(recipe, modelAndView);
		return modelAndView;
	}

	@PostMapping("cookingToolInsert")
	public ModelAndView cookingToolInsert(Recipe recipe) {
		log.debug("cookingToolInsert:" + recipe.toString());

		CookingTool cookingTool = new CookingTool();
		cookingTool.setName(recipe.getCookingToolName());
		getCookingTools().add(cookingTool);

		ModelAndView modelAndView = new ModelAndView("index", "command", recipe);
		addPageData(recipe, modelAndView);
		return modelAndView;
	}

	public List<CookingTool> getCookingTools() {
		return cookingTools;
	}

	public void setCookingTools(List<CookingTool> cookingTools) {
		this.cookingTools = cookingTools;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

}
