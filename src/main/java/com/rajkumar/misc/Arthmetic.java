package com.rajkumar.misc;

import java.util.function.Function;

public class Arthmetic implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer*integer;
    }

    @Override
    public <V> Function<V, Integer> compose(Function<? super V, ? extends Integer> before) {
        return null;
    }

    @Override
    public <V> Function<Integer, V> andThen(Function<? super Integer, ? extends V> after) {
        return null;
    }
}
