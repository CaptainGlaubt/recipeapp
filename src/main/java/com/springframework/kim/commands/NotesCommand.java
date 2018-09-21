package com.springframework.kim.commands;

import com.springframework.kim.domain.Recipe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NotesCommand {
    private Long   id;
    private Recipe recipe;
    private String recipeNotes;
}


//~ Formatted by Jindent --- http://www.jindent.com
