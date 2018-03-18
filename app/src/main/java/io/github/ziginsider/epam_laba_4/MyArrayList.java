package io.github.ziginsider.epam_laba_4;

import java.util.List;
import java.util.Objects;

/**
 * Created by zigin on 18.03.2018.
 */

public class MyArrayList<T> implements List<T> {

    private static final int START_CAPACITY = 10;

    private T[] elements;
    private int size;

    public MyArrayList() {
        this(START_CAPACITY);
    }

    public MyArrayList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean add(T t) {
        try {
            ensureCapacity(size + 1);
            elements[size++] = t;
            return  true;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public int size() {
        return size;
    }
}
