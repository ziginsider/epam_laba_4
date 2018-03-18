package io.github.ziginsider.epam_laba_4;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
    public boolean add(T element) {
        try {
            ensureCapacity(size + 1);
            elements[size++] = element;
            return true;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(int index, T element) {
        rangeCheckForAdd(index);
        try {
            ensureCapacity(size + 1);
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    private void ensureCapacity(int demandCapacity) {
        int oldCapacity = elements.length;
        if (demandCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1) + 1;
            T[] newElements = (T[]) new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public T set(int index, T element) {
        rangeCheck(index);
        try {
            T oldElement = elements[index];
            elements[index] = element;
            return oldElement;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T remove(int index) {
        rangeCheck(index);
        T oldElement = elements[index];
        if (size - 1 != index) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        }
        elements[--size] = null;
        return oldElement;
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            throw new NullPointerException("Removable object is null");
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(elements[i])) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {

    }

    /*
    *
    *
    * Below not implemented
    *
    *
    */

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, @NonNull Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NonNull
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @NonNull
    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @NonNull
    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NonNull
    @Override
    public <T1> T1[] toArray(@NonNull T1[] t1s) {
        return null;
    }
}
