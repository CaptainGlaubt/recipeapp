package com.springframework.kim.converters;

import com.springframework.kim.commands.NotesCommand;
import com.springframework.kim.domain.Notes;

public class NotesCommandConverter extends NullsafeConverter<NotesCommand, Notes> {
    @Override
    protected Notes convertInternal(NotesCommand command) {
        Notes notes = new Notes();
        notes.setId(command.getId());
        notes.setRecipeNotes(command.getRecipeNotes());
        return notes;
    }
}


