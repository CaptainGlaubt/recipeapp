package com.springframework.kim.converters;

import com.springframework.kim.commands.IngredientCommand;
import com.springframework.kim.domain.Ingredient;

public class IngredientConverter extends NullsafeConverter<Ingredient, IngredientCommand> {
    @Override
    protected IngredientCommand convertInternal(Ingredient source) {
        IngredientCommand ingredientCommand = new IngredientCommand();

        ingredientCommand.setId(source.getId());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUnitOfMeasure(source.getUnitOfMeasure());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setRecipe(source.getRecipe());

        return ingredientCommand;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
