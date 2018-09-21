package com.springframework.kim.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.springframework.kim.commands.CategoryCommand;
import com.springframework.kim.domain.Category;

public class CategoryConverterTest {
    public static final Long   ID_VALUE    = new Long(1L);
    public static final String DESCRIPTION = "description";
    CategoryConverter          converter;

    @Test
    public void convert() throws Exception {

        // given
        Category category = new Category();

        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        // when
        CategoryCommand categoryCommand = converter.convert(category);

        // then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @BeforeEach
    public void setUp() throws Exception {
        converter = new CategoryConverter();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
