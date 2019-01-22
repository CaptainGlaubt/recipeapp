package com.springframework.kim.converters;

import java.util.Objects;

import com.springframework.kim.commands.IngredientCommand;
import com.springframework.kim.domain.Ingredient;

public class IngredientConverter extends NullsafeConverter<Ingredient, IngredientCommand> {
	
private UnitOfMeasureConverter unitOfMeasureConverter;
	
	
    public IngredientConverter(UnitOfMeasureConverter unitOfMeasureConverter) {
    	Objects.requireNonNull(unitOfMeasureConverter, String.format("%s MUST be provided", UnitOfMeasureConverter.class.getSimpleName()));
		this.unitOfMeasureConverter = unitOfMeasureConverter;
	}
	
    @Override
    protected IngredientCommand convertInternal(Ingredient source) {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUnitOfMeasure(unitOfMeasureConverter.convert(source.getUnitOfMeasure()));
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setRecipe(source.getRecipe());
        return ingredientCommand;
    }
}


