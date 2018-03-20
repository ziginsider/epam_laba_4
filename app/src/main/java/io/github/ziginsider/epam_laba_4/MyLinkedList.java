package io.github.ziginsider.epam_laba_4;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * Implementation LinkedList by interface {@link List}
 * <p>
 * <p>Implemented methods: {@link MyLinkedList#size()}, {@link MyLinkedList#isEmpty()},
 * {@link MyLinkedList#add(Object)}, {@link MyLinkedList#add(int, Object)},
 * {@link MyLinkedList#set(int, Object)}, {@link MyLinkedList#get(int)},
 * {@link MyLinkedList#remove(Object)}, {@link MyLinkedList#remove(int)},
 * {@link MyLinkedList#clear()}, {@link MyLinkedList#iterator()}
 * <p>
 * <p>Not implemented methods: {@link MyLinkedList#contains(Object)},
 * {@link MyLinkedList#containsAll(Collection)}, {@link MyLinkedList#toArray()},
 * {@link MyLinkedList#toArray(Object[])}, {@link MyLinkedList#addAll(Collection)},
 * {@link MyLinkedList#addAll(int, Collection)}, {@link MyLinkedList#removeAll(Collection)},
 * {@link MyLinkedList#retainAll(Collection)}, {@link MyLinkedList#indexOf(Object)},
 * {@link MyLinkedList#lastIndexOf(Object)}, {@link MyLinkedList#listIterator()},
 * {@link MyLinkedList#subList(int, int)}, {@link MyLinkedList#listIterator(int)}
 *
 * @author Alex Kisel
 * @since 2018-03-20
 */
public class MyLinkedList<T> implements List<T> {
    private int size;
    private Node<T> header;

    /**
     * Constructs an empty list.
     */
    MyLinkedList() {
        size = 0;
        header = new Node<>(null, null, null);
        header.nextNode = header.prevNode = header;
    }

    private static class Node<T> {
        T element;
        Node<T> nextNode;
        Node<T> prevNode;

        Node(T element, Node<T> nextNode, Node<T> prevNode) {
            this.element = element;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
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
     * Returns <tt>true</tt> if this list contains no values.
     *
     * @return <tt>true</tt> if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return <tt>true</tt>
     */
    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element, header, header.prevNode);
        newNode.prevNode.nextNode = newNode;
        newNode.nextNode.prevNode = newNode;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, T element) {
        rangeCheckForAdd(index);
        if (index == size) {
            add(element);
        } else {
            Node<T> foundNode = findNode(index);
            Node<T> newNode = new Node<>(element, foundNode, foundNode.prevNode);
            foundNode.prevNode.nextNode = newNode;
            foundNode.prevNode = newNode;
            size++;
        }
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public T set(int index, T element) {
        rangeCheck(index);
        Node<T> foundNode = findNode(index);
        T oldElement = foundNode.element;
        foundNode.element = element;
        return oldElement;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public T get(int index) {
        rangeCheck(index);
        return findNode(index).element;
    }

    /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return element previously at the specified position
     */
    @Override
    public T remove(int index) {
        rangeCheck(index);
        Node<T> foundNode = findNode(index);
        T oldElement = foundNode.element;
        foundNode.prevNode.nextNode = foundNode.nextNode;
        foundNode.nextNode.prevNode = foundNode.prevNode;
        foundNode.nextNode = foundNode.prevNode = null;
        foundNode.element = null;
        size--;
        return oldElement;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged.
     *
     * @param object element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     */
    @Override
    public boolean remove(Object object) {
        Node<T> foundNode = findNodeByElement(object);
        if (!foundNode.equals(header)) {
            foundNode.prevNode.nextNode = foundNode.nextNode;
            foundNode.nextNode.prevNode = foundNode.prevNode;
            foundNode.nextNode = foundNode.prevNode = null;
            foundNode.element = null;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        Node<T> cursor = header.nextNode;
        for (int i = 0; i < size; i++) {
            Node<T> nextNode = cursor.nextNode;
            cursor.element = null;
            cursor.nextNode = null;
            cursor.prevNode = null;
            cursor = nextNode;
        }
        size = 0;
    }

    private Node<T> findNode(int index) {
        Node<T> foundNode = header;
        if (index < (size >> 1)) {
            for (int i = 0; i <= index; i++) {
                foundNode = foundNode.nextNode;
            }
        } else {
            for (int i = size; i > index; i--) {
                foundNode = foundNode.prevNode;
            }
        }
        return foundNode;
    }

    private Node<T> findNodeByElement(Object object) {
        Node<T> foundNode = header;
        for (int i = 0; i < size; i++) {
            foundNode = foundNode.nextNode;
            if (foundNode.element.equals(object)) {
                return foundNode;
            }
        }
        return header;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
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
        return new MyIterator<>(header);
    }

    private class MyIterator<T> implements Iterator<T> {
        private Node<T> cursor;

        MyIterator(Node<T> header) {
            this.cursor = header.nextNode;
        }

        @Override
        public boolean hasNext() {
            return (cursor != header && size != 0);
        }

        @Override
        public T next() {
            T element = cursor.element;
            cursor = cursor.nextNode;
            return element;
        }
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
}