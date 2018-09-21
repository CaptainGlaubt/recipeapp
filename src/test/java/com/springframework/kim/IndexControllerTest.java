package com.springframework.kim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.springframework.kim.controllers.IndexController;
import com.springframework.kim.domain.Recipe;
import com.springframework.kim.services.RecipeService;

public class IndexControllerTest {
	private IndexController indexController;

	@Mock
	private RecipeService recipeServiceMock;

	@Mock
	private Model modelMock;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeServiceMock);
	}

	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	public void test_get_index_page() {
		// given
		Recipe recipe = new Recipe();
		recipe.setId(1l);

		Set<Recipe> recipes = new HashSet<>();
		recipes.add(recipe);
		recipes.add(new Recipe());
		when(recipeServiceMock.getAllRecipes()).thenReturn(recipes);

		@SuppressWarnings("unchecked")
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		// when
		String view = indexController.getIndexPage(modelMock);

		// then
		assertEquals("index", view);
		verify(recipeServiceMock, times(1)).getAllRecipes();
		verify(modelMock, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}
}
