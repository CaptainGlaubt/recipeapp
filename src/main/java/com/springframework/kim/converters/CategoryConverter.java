package com.springframework.kim.converters;

import com.springframework.kim.commands.CategoryCommand;
import com.springframework.kim.domain.Category;

public class CategoryConverter extends NullsafeConverter<Category, CategoryCommand> {
    @Override
    protected CategoryCommand convertInternal(Category source) {
        CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());

        return categoryCommand;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
