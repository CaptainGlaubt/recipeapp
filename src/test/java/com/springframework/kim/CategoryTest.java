package com.springframework.kim;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springframework.kim.domain.Category;

public class CategoryTest {
	private com.springframework.kim.domain.Category category;

	@BeforeEach
	public void setUp() {
		category = new Category();
	}

	@Test
	public void getId() throws Exception {
		Long idValue = 4l;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}

	@Test
	public void getDescription() throws Exception {

	}

	@Test
	public void getRecipes() throws Exception {

	}
}
