package com.springframework.kim.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springframework.kim.domain.Recipe;
import com.springframework.kim.repositories.RecipeRepository;
import com.springframework.kim.services.RecipeService;

public class RecieServiceImplTest {
	private RecipeService recipeService;
	@Mock
	private RecipeRepository recipeRepository;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeService(recipeRepository);
	}

	@Test
	public void getRecipes() throws Exception {
		Recipe recipeMock = new Recipe();
		HashSet<Recipe> recipesMock = new HashSet<>();
		recipesMock.add(recipeMock);
		when(recipeService.getAllRecipes()).thenReturn(recipesMock);
		Set<Recipe> recipes = recipeService.getAllRecipes();
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}
}
