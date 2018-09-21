package com.springframework.kim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.kim.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({ "", "/", "/index" })
    public String getIndexPage(Model model) {
        log.debug("In getIndexPage");
        model.addAttribute("recipes", recipeService.getAllRecipes());

        return "index";
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
