package com.springframework.kim.commands;

import java.util.HashSet;
import java.util.Set;

import com.springframework.kim.domain.Category;
import com.springframework.kim.domain.Difficulty;
import com.springframework.kim.domain.Ingredient;
import com.springframework.kim.domain.Notes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RecipeCommand {
    private Set<Ingredient> ingredients = new HashSet<>();
    private Set<Category>   categories  = new HashSet<>();
    private Long            id;
    private String          description;
    private Integer         prepTime;
    private Integer         cookTime;
    private Integer         servings;
    private String          source;
    private String          url;
    private String          directions;
    private Byte[]          image;
    private Difficulty      difficulty;
    private Notes           notes;
}


//~ Formatted by Jindent --- http://www.jindent.com
