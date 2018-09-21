package com.springframework.kim.converters;

import com.springframework.kim.commands.IngredientCommand;
import com.springframework.kim.domain.Ingredient;

public class IngredientCommandConverter extends NullsafeConverter<IngredientCommand, Ingredient> {
    @Override
    protected Ingredient convertInternal(IngredientCommand source) {
        Ingredient ingredient = new Ingredient();

        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());
        ingredient.setUnitOfMeasure(source.getUnitOfMeasure());
        ingredient.setAmount(source.getAmount());
        ingredient.setRecipe(source.getRecipe());

        return ingredient;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
