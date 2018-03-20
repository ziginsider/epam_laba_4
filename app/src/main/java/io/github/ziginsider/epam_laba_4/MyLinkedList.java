package io.github.ziginsider.epam_laba_4;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by zigin on 19.03.2018.
 */

public class MyLinkedList<T> implements List<T> {
    private int size;
    private Node<T> header;

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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element, header, header.prevNode);
        newNode.prevNode.nextNode = newNode;
        newNode.nextNode.prevNode = newNode;
        size++;
        return true;
    }

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

    @Override
    public T set(int index, T element) {
        rangeCheck(index);
        Node<T> foundNode = findNode(index);
        T oldElement = foundNode.element;
        foundNode.element = element;
        return oldElement;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return findNode(index).element;
    }

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

    /*
    * Below not implemented
    */
    @Override
    public boolean contains(Object o) {
        return false;
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
}