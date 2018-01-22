package es.salesianos.controller;

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

	@GetMapping("/")
	public ModelAndView index() {
		Recipe recipe = new Recipe();
		return new ModelAndView("index", "command", recipe);
	}

	@PostMapping("recipeInsert")
	public ModelAndView recipeInsert(Recipe recipe) {
		log.debug("recipeInsert");
		return new ModelAndView("index", "command", recipe);
	}

	@PostMapping("ingredientInsert")
	public ModelAndView ingredientInsert(Recipe recipe) {
		log.debug("ingredientInsert");

		Ingredient ingredient = new Ingredient();
		ingredient.setName(recipe.getIngredientName());

		recipe.getIngredients().add(ingredient);

		return new ModelAndView("index", "command", recipe);
	}

	@PostMapping("cookingToolInsert")
	public ModelAndView cookingToolInsert(Recipe recipe) {
		log.debug("cookingToolInsert");

		CookingTool cookingTool = new CookingTool();
		cookingTool.setName(recipe.getCookingToolName());

		recipe.getTools().add(cookingTool);

		return new ModelAndView("index", "command", recipe);
	}

}
