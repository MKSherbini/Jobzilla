package com.mksherbini.jobzilla.adapters;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericAdapter<T, R> {
    R adapt(T orm);

    default List<R> adapt(List<T> orms) {
        return orms.stream().map(this::adapt).collect(Collectors.toList());
    }
}
