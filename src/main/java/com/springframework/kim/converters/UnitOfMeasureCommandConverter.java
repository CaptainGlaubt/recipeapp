package com.springframework.kim.converters;

import com.springframework.kim.commands.UnitOfMeasureCommand;
import com.springframework.kim.domain.UnitOfMeasure;

public class UnitOfMeasureCommandConverter extends NullsafeConverter<UnitOfMeasureCommand, UnitOfMeasure> {
    @Override
    protected UnitOfMeasure convertInternal(UnitOfMeasureCommand command) {
        UnitOfMeasure uom = new UnitOfMeasure();

        uom.setId(command.getId());
        uom.setUnitOfMeasure(command.getUnitOfMeasure());

        return uom;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
