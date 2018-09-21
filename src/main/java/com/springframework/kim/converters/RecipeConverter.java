package com.springframework.kim.converters;

import com.springframework.kim.commands.RecipeCommand;
import com.springframework.kim.domain.Recipe;

public class RecipeConverter extends NullsafeConverter<Recipe, RecipeCommand> {
    @Override
    protected RecipeCommand convertInternal(Recipe source) {
        RecipeCommand recipeCommand = new RecipeCommand();

        recipeCommand.setId(source.getId());
        recipeCommand.setCategories(source.getCategories());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setDirections(source.getDirections());
        recipeCommand.setImage(source.getImage());
        recipeCommand.setIngredients(source.getIngredients());
        recipeCommand.setNotes(source.getNotes());
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setUrl(source.getUrl());

        return recipeCommand;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
