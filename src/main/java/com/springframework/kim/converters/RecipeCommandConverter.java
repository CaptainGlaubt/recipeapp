package com.springframework.kim.converters;

import com.springframework.kim.commands.RecipeCommand;
import com.springframework.kim.domain.Recipe;

public class RecipeCommandConverter extends NullsafeConverter<RecipeCommand, Recipe> {
    @Override
    protected Recipe convertInternal(RecipeCommand command) {
        Recipe recipe = new Recipe();

        recipe.setId(command.getId());
        recipe.setCategories(command.getCategories());
        recipe.setCookTime(command.getCookTime());
        recipe.setDescription(command.getDescription());
        recipe.setDifficulty(command.getDifficulty());
        recipe.setDirections(command.getDirections());
        recipe.setImage(command.getImage());
        recipe.setIngredients(command.getIngredients());
        recipe.setNotes(command.getNotes());
        recipe.setPrepTime(command.getPrepTime());
        recipe.setServings(command.getServings());
        recipe.setSource(command.getSource());
        recipe.setUrl(command.getUrl());

        return recipe;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
