package com.springframework.kim.converters;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.springframework.kim.commands.IngredientCommand;
import com.springframework.kim.commands.UnitOfMeasureCommand;
import com.springframework.kim.domain.Ingredient;
import com.springframework.kim.domain.Recipe;

public class IngredientCommandConverterTest {
    public static final Recipe         RECIPE      = new Recipe();
    public static final BigDecimal     AMOUNT      = new BigDecimal("1");
    public static final String         DESCRIPTION = "Cheeseburger";
    public static final Long           ID_VALUE    = new Long(1L);
    public static final Long           UOM_ID      = new Long(2L);
    private IngredientCommandConverter converter;

    @Test
    public void convert() throws Exception {

        // given
        IngredientCommand command = new IngredientCommand();

        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);

        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();

        unitOfMeasureCommand.setId(UOM_ID);
        command.setUnitOfMeasure(unitOfMeasureCommand);

        // when
        Ingredient ingredient = converter.convert(command);

        // then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUnitOfMeasure());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(UOM_ID, ingredient.getUnitOfMeasure().getId());
    }

    @Test
    public void convertWithNullUOM() throws Exception {

        // given
        IngredientCommand command = new IngredientCommand();

        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);

        // when
        Ingredient ingredient = converter.convert(command);

        // then
        assertNotNull(ingredient);
        assertNull(ingredient.getUnitOfMeasure());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @BeforeEach
    public void setUp() throws Exception {
        converter = new IngredientCommandConverter(new UnitOfMeasureCommandConverter());
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
