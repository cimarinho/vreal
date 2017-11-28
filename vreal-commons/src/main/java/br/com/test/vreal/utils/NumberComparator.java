package br.com.test.vreal.utils;

import java.util.HashMap;
import java.util.Map;

public class NumberComparator {

    private final Comparable number;
    private static final Map<Class, NumberConverter> converterMap;
    private NumberComparator(Number number) {
        this.number = (Comparable) number;
    }

    public static NumberComparator valueOf(Number number) {
        return new NumberComparator(number);
    }

    public boolean isLowerThan(Number other) {
        return this.number.compareTo(cast(other)) < 0;
    }

    private <T> T cast(Number other) {
        if(number.getClass().equals(other.getClass())) {
            return (T) other;
        } else {
            return (T) converterMap.get(number.getClass()).cast(other);
        }
    }

    static {
        converterMap = new HashMap<>();
        converterMap.put(Integer.class, Number::intValue);
        converterMap.put(int.class, Number::intValue);

        converterMap.put(Long.class, Number::longValue);
        converterMap.put(long.class, Number::longValue);

    }

    interface NumberConverter {
        Number cast(Number number);
    }
}