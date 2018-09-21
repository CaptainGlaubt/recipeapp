package com.springframework.kim.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import lombok.Synchronized;

public abstract class NullsafeConverter<S, T> implements Converter<S, T> {
    @Synchronized
    @Nullable
    @Override
    public T convert(S source) {
        if (source != null) {
            return convertInternal(source);
        }

        return null;
    }

    protected abstract T convertInternal(S source);
}


//~ Formatted by Jindent --- http://www.jindent.com
