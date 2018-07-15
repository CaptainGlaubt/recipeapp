package com.springframework.kim.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.springframework.kim.domain.Recipe;
import com.springframework.kim.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public Set<Recipe> getAllRecipes() {
		log.debug("In getAllRecipes");
		Set<Recipe> recipes = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}
}
