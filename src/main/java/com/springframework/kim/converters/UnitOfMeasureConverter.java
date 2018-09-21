package com.springframework.kim.converters;

import com.springframework.kim.commands.UnitOfMeasureCommand;
import com.springframework.kim.domain.UnitOfMeasure;

public class UnitOfMeasureConverter extends NullsafeConverter<UnitOfMeasure, UnitOfMeasureCommand> {
    @Override
    protected UnitOfMeasureCommand convertInternal(UnitOfMeasure source) {
        UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();

        uomCommand.setId(source.getId());
        uomCommand.setUnitOfMeasure(source.getUnitOfMeasure());

        return uomCommand;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
