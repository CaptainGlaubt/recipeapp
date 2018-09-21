package com.springframework.kim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.kim.services.RecipeService;

@Controller
public class RecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping(path = "/recipe/show/{id}")
	public String showById(@PathVariable(required = true) String id, Model model) {
		model.addAttribute("recipe", recipeService.getById(new Long(id)));
		return "recipe/show";
	}
}
