package com.springframework.kim.commands;

import java.math.BigDecimal;

import com.springframework.kim.domain.Recipe;
import com.springframework.kim.domain.UnitOfMeasure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class IngredientCommand {
    private Long          id;
    private String        description;
    private BigDecimal    amount;
    private Recipe        recipe;
    private UnitOfMeasureCommand unitOfMeasure;
}


//~ Formatted by Jindent --- http://www.jindent.com
