package com.springframework.kim.converters;

import java.util.Objects;

import com.springframework.kim.commands.IngredientCommand;
import com.springframework.kim.domain.Ingredient;

public class IngredientCommandConverter extends NullsafeConverter<IngredientCommand, Ingredient> {
	
	private UnitOfMeasureCommandConverter unitOfMeasureCommandConverter;
	
	
    public IngredientCommandConverter(UnitOfMeasureCommandConverter unitOfMeasureCommandConverter) {
    	Objects.requireNonNull(unitOfMeasureCommandConverter, String.format("%s MUST be provided", UnitOfMeasureCommandConverter.class.getSimpleName()));
		this.unitOfMeasureCommandConverter = unitOfMeasureCommandConverter;
	}



	@Override
    protected Ingredient convertInternal(IngredientCommand source) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());
        ingredient.setUnitOfMeasure(unitOfMeasureCommandConverter.convert(source.getUnitOfMeasure()));
        ingredient.setAmount(source.getAmount());
        ingredient.setRecipe(source.getRecipe());
        return ingredient;
    }
}


