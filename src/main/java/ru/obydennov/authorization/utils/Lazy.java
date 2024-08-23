package ru.obydennov.authorization.utils;

import java.util.function.Supplier;

/**
 * Утилита для ленивой инициализации
 * @param <T> - любой элемент для инициализации
 *
 * @author obydennov
 * @since 21.05.2022
 */
public class Lazy <T> implements Supplier<T> {
    private Supplier<T> supplier;
    private T value;
    private boolean isInitialized = false;

    private Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public static Supplier let(Supplier supplier) {
        return new Lazy(supplier);
    }

    @Override
    public T get() {
        if (isInitialized) {
            return value;
        }
        else {
            isInitialized = true;
            return value = supplier.get();
        }
    }

}
