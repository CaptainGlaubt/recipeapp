package com.springframework.kim.converters;

import com.springframework.kim.commands.CategoryCommand;
import com.springframework.kim.domain.Category;

public class CategoryCommandConverter extends NullsafeConverter<CategoryCommand, Category> {
    @Override
    protected Category convertInternal(CategoryCommand source) {
        Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}


