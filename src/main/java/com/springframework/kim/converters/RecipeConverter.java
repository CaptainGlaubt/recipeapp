package com.springframework.kim.converters;

import java.util.Objects;
import java.util.stream.Collectors;

import com.springframework.kim.commands.NotesCommand;
import com.springframework.kim.commands.RecipeCommand;
import com.springframework.kim.domain.Recipe;

public class RecipeConverter extends NullsafeConverter<Recipe, RecipeCommand> {
	

    private CategoryConverter categoryConverter;
    private IngredientConverter ingredientConverter;
    private NotesConverter notesConverter;    
    
    
    public RecipeConverter(CategoryConverter categoryConverter,
            IngredientConverter ingredientConverter,
            NotesConverter notesConverter) {
        Objects.requireNonNull(categoryConverter, String.format("%s MUST be provided", CategoryConverter.class.getSimpleName()));
        Objects.requireNonNull(ingredientConverter, String.format("%s MUST be provided", IngredientConverter.class.getSimpleName()));
        Objects.requireNonNull(notesConverter, String.format("%s MUST be provided", NotesConverter.class.getSimpleName()));
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }
	
    @Override
    protected RecipeCommand convertInternal(Recipe source) {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setCategories(source.getCategories() != null ? source.getCategories().stream().map(categoryConverter::convert).collect(Collectors.toSet()) : null);
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setDirections(source.getDirections());
        recipeCommand.setImage(source.getImage());
        recipeCommand.setIngredients(source.getIngredients() != null ? source.getIngredients().stream().map(ingredientConverter::convert).collect(Collectors.toSet()) : null);
        recipeCommand.setNotes(notesConverter.convert(source.getNotes()));
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setUrl(source.getUrl());
        return recipeCommand;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
