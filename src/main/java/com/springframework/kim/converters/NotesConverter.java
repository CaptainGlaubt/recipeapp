package com.springframework.kim.converters;

import com.springframework.kim.commands.NotesCommand;
import com.springframework.kim.domain.Notes;

public class NotesConverter extends NullsafeConverter<Notes, NotesCommand> {
	
    @Override
    protected NotesCommand convertInternal(Notes source) {
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}


