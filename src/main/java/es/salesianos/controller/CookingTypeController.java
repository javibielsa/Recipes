package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.CookingType;
import es.salesianos.service.Service;


@Controller
public class CookingTypeController {

	private static Logger log = LogManager.getLogger(CookingTypeController.class);

	private Service service;

	@GetMapping("/CookingType")
	public ModelAndView index() {
		log.debug("entrando a insertar nuevo tipo de cocina");
		return new ModelAndView("cookingType", "command", new CookingType());
	}

	@PostMapping
	@RequestMapping(value = "cookingType/insert")
	public ModelAndView create(@RequestBody CookingType cookingType) {
		log.debug("inserting cookingType");
		service.insert(cookingType);
		return new ModelAndView("cookingType", "command", new CookingType());
	}

}

