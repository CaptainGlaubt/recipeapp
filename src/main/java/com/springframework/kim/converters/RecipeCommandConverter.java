package com.springframework.kim.converters;

import java.util.Objects;
import java.util.stream.Collectors;

import com.springframework.kim.commands.RecipeCommand;
import com.springframework.kim.domain.Recipe;

public class RecipeCommandConverter extends NullsafeConverter<RecipeCommand, Recipe> {
	

    private CategoryCommandConverter categoryCommandConverter;
    private IngredientCommandConverter ingredientCommandConverter;
    private NotesCommandConverter notesCommandConverter;    
    
    
    public RecipeCommandConverter(CategoryCommandConverter categoryCommandConverter,
            IngredientCommandConverter ingredientCommandConverter,
            NotesCommandConverter notesCommandConverter) {
        Objects.requireNonNull(categoryCommandConverter, String.format("%s MUST be provided", CategoryCommandConverter.class.getSimpleName()));
        Objects.requireNonNull(ingredientCommandConverter, String.format("%s MUST be provided", IngredientCommandConverter.class.getSimpleName()));
        Objects.requireNonNull(notesCommandConverter, String.format("%s MUST be provided", NotesCommandConverter.class.getSimpleName()));
        this.categoryCommandConverter = categoryCommandConverter;
        this.ingredientCommandConverter = ingredientCommandConverter;
        this.notesCommandConverter = notesCommandConverter;
    }
	
    @Override
    protected Recipe convertInternal(RecipeCommand command) {
        Recipe recipe = new Recipe();
        recipe.setId(command.getId());
        recipe.setCategories(command.getCategories().stream().map(categoryCommandConverter::convert).collect(Collectors.toSet()));
        recipe.setCookTime(command.getCookTime());
        recipe.setDescription(command.getDescription());
        recipe.setDifficulty(command.getDifficulty());
        recipe.setDirections(command.getDirections());
        recipe.setImage(command.getImage());
        recipe.setIngredients(command.getIngredients() != null ? command.getIngredients().stream().map(ingredientCommandConverter::convert).collect(Collectors.toSet()):null);
        recipe.setNotes(notesCommandConverter.convert(command.getNotes()));
        recipe.setPrepTime(command.getPrepTime());
        recipe.setServings(command.getServings());
        recipe.setSource(command.getSource());
        recipe.setUrl(command.getUrl());
        return recipe;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
