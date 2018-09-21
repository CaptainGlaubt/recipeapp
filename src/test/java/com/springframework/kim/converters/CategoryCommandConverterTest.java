package com.springframework.kim.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.springframework.kim.commands.CategoryCommand;
import com.springframework.kim.domain.Category;

public class CategoryCommandConverterTest {
    public static final Long   ID_VALUE    = new Long(1L);
    public static final String DESCRIPTION = "description";
    CategoryCommandConverter   conveter;

    @Test
    public void convert() throws Exception {

        // given
        CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        // when
        Category category = conveter.convert(categoryCommand);

        // then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(conveter.convert(new CategoryCommand()));
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(conveter.convert(null));
    }

    @BeforeEach
    public void setUp() throws Exception {
        conveter = new CategoryCommandConverter();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
