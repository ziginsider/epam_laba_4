package io.github.ziginsider.epam_laba_4;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation ArrayList by interface {@link List}
 * <p>
 * <p>Implemented methods: {@link MyArrayList#size()}, {@link MyArrayList#isEmpty()},
 * {@link MyArrayList#add(Object)}, {@link MyArrayList#add(int, Object)},
 * {@link MyArrayList#get(int)}, {@link MyArrayList#set(int, Object)},
 * {@link MyArrayList#remove(int)}, {@link MyArrayList#remove(Object)},
 * {@link MyArrayList#clear()}, {@link MyArrayList#iterator()}
 * <p>
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

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    MyArrayList() {
        this(START_CAPACITY);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param capacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    MyArrayList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return <tt>true</tt>
     */
    @Override
    public boolean add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     */
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

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
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

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public T set(int index, T element) {
        rangeCheck(index);
        T oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
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

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If the list does not contain the element, it is
     * unchanged.
     *
     * @param object element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     */
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

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator of the elements in this list (in proper
     * sequence
     *
     * @return iterator
     */
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