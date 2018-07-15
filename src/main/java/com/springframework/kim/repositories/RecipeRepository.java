package com.springframework.kim.repositories;

import org.springframework.data.repository.CrudRepository;
import com.springframework.kim.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
