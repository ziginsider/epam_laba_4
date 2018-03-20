package io.github.ziginsider.epam_laba_4;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation ArrayList by interface {@link List}
 *
 * <p>Implemented methods: {@link MyArrayList#size()}, {@link MyArrayList#isEmpty()},
 * {@link MyArrayList#add(Object)}, {@link MyArrayList#add(int, Object)},
 * {@link MyArrayList#get(int)}, {@link MyArrayList#set(int, Object)},
 * {@link MyArrayList#remove(int)}, {@link MyArrayList#remove(Object)},
 * {@link MyArrayList#clear()}, {@link MyArrayList#iterator()}
 *
 * <p>Not implemented methods: {@link MyArrayList#containsAll(Collection)},
 * {@link MyArrayList#add(int, Object)}, {@link MyArrayList#add(Object)},
 * {@link MyArrayList#retainAll(Collection)}, {@link MyArrayList#removeAll(Collection)},
 * {@link MyArrayList#indexOf(Object)}, {@link MyArrayList#lastIndexOf(Object)},
 * {@link MyArrayList#listIterator(int)}, {@link MyArrayList#listIterator()},
 * {@link MyArrayList#subList(int, int)}, {@link MyArrayList#contains(Object)},
 * {@link MyArrayList#toArray(Object[])}, {@link MyArrayList#toArray()}
 *
 * @author Alex Kisel
 * @since 2018-03-20
 */
public class MyArrayList<T> implements List<T> {
    private static final int START_CAPACITY = 10;

    private T[] elements;
    private int size;

    MyArrayList() {
        this(START_CAPACITY);
    }

    MyArrayList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        return true;
    }

    @Override
    public void add(int index, T element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
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
        T oldElement = elements[index];
        elements[index] = element;
        return oldElement;
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
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(elements);
    }

    private class MyIterator<T> implements Iterator<T> {
        private int index = 0;
        private T[] elements;

        MyIterator(T[] elements) {
            this.elements = elements;
        }

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public T next() {
            return elements[index++];
        }
    }

    /*
    * Below not implemented
    */

    /**
     * Not implemented
     */
    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return false;
    }

    /**
     * Not implemented
     */
    @Override
    public boolean addAll(@NonNull Collection<? extends T> collection) {
        return false;
    }

    /**
     * Not implemented
     */
    @Override
    public boolean addAll(int i, @NonNull Collection<? extends T> collection) {
        return false;
    }

    /**
     * Not implemented
     */
    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        return false;
    }

    /**
     * Not implemented
     */
    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        return false;
    }

    /**
     * Not implemented
     */
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    /**
     * Not implemented
     */
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    /**
     * Not implemented
     */
    @NonNull
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    /**
     * Not implemented
     */
    @NonNull
    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    /**
     * Not implemented
     */
    @NonNull
    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }

    /**
     * Not implemented
     */
    @Override
    public boolean contains(Object o) {
        return false;
    }

    /**
     * Not implemented
     */
    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * Not implemented
     */
    @NonNull
    @Override
    public <T1> T1[] toArray(@NonNull T1[] t1s) {
        return null;
    }
}