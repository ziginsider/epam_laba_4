package io.github.ziginsider.epam_laba_4;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by zigin on 20.03.2018.
 */

public class MyHashMap<KEY, VALUE> implements Map<KEY, VALUE> {
    private static final int START_CAPACITY = 16;
    private static final float START_LOAD_FACTOR = 0.75f;

    private int size;
    private Entry[] table;
    private int treshold;
    private final float loadFactor;

    public MyHashMap() {
        loadFactor = START_LOAD_FACTOR;
        treshold = (int) (START_CAPACITY * START_LOAD_FACTOR);
        table = new Entry[START_CAPACITY];
        size = 0;
    }

    public MyHashMap(int startCapacity, float loadFactor) {
        if (startCapacity < 0) {
            throw new IllegalArgumentException("Illegal start capacity: " + startCapacity);
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        treshold = (int) (startCapacity * loadFactor);
        table = new Entry[startCapacity];
        size = 0;
    }

    public MyHashMap(int startCapacity) {
        this(startCapacity, START_LOAD_FACTOR);
    }

    static class Entry<KEY, VALUE> implements Map.Entry<KEY, VALUE> {

        final int hash;
        final KEY key;
        VALUE value;
        Entry<KEY, VALUE> next;

        public Entry(int hash, KEY key, VALUE value, Entry<KEY, VALUE> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public KEY getKey() {
            return key;
        }

        @Override
        public VALUE getValue() {
            return value;
        }

        @Override
        public VALUE setValue(VALUE value) {
            VALUE oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    static int hash(int keyHash) {
        keyHash ^= (keyHash >>> 20) ^ (keyHash >>> 12);
        return keyHash ^ (keyHash >>> 7) ^ (keyHash >>> 4);
    }

    static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*
    * Below not implemented
    */

    @Override
    public boolean containsKey(Object o) {
        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        return false;
    }

    @Override
    public VALUE get(Object o) {
        return null;
    }

    @Override
    public VALUE put(KEY key, VALUE value) {
        return null;
    }

    @Override
    public VALUE remove(Object o) {
        return null;
    }

    @Override
    public void putAll(@NonNull Map<? extends KEY, ? extends VALUE> map) {

    }

    @Override
    public void clear() {

    }

    @NonNull
    @Override
    public Set<KEY> keySet() {
        return null;
    }

    @NonNull
    @Override
    public Collection<VALUE> values() {
        return null;
    }

    @NonNull
    @Override
    public Set<Map.Entry<KEY, VALUE>> entrySet() {
        return null;
    }

}
