package io.github.ziginsider.epam_laba_4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
    private int threshold;
    private final float loadFactor;

    public MyHashMap() {
        loadFactor = START_LOAD_FACTOR;
        threshold = (int) (START_CAPACITY * START_LOAD_FACTOR);
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
        threshold = (int) (startCapacity * loadFactor);
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

    @Override
    public VALUE put(KEY key, VALUE value) {
        if (key == null) return putForNullKey(value);
        int hash = hash(key.hashCode());
        int index = indexFor(hash, table.length);
        for (Entry<KEY, VALUE> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.hash == hash && (entry.key == key || key.equals(entry.key))) {
                VALUE oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        addEntry(hash, key, value, index);
        return null;
    }

    private VALUE putForNullKey(VALUE value) {
        for (Entry<KEY, VALUE> entry = table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                VALUE oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        addEntry(0, null, value, 0);
        return null;
    }

    private void addEntry(int hash, KEY key, VALUE value, int index) {
        Entry<KEY, VALUE> topEntry = table[index];
        table[index] = new Entry<>(hash, key, value, topEntry);
        if (size++ >= threshold) {
            resize(2 * table.length);
        }
    }

    private void resize(int newCapacity) {
        Entry[] oldTable = table;
        Entry[] newTable = new Entry[newCapacity];
        //transfer
        for (int i = 0; i < oldTable.length; i++) {
            Entry<KEY, VALUE> entry = oldTable[i];
            if (entry != null) {
                oldTable[i] = null;
                do {
                    Entry<KEY, VALUE> nextEntry = entry.next;
                    int index = indexFor(entry.hash, newCapacity);
                    entry.next = newTable[index];
                    newTable[index] = entry;
                    entry = nextEntry;
                } while (entry != null);
            }
        }
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    @Override
    public VALUE get(Object key) {
        if (key == null) return getForNullKey();
        int hash = hash(key.hashCode());
        int index = indexFor(hash, table.length);
        for (Entry<KEY, VALUE> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.hash == hash && (entry.key == key || key.equals(entry.key))) {
                return entry.value;
            }
        }
        return null;
    }

    private VALUE getForNullKey() {
        for (Entry<KEY, VALUE> entry = table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) return entry.value;
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        int hash;
        int index;
        if (key == null) hash = 0;
        else hash = hash(key.hashCode());
        index = indexFor(hash, table.length);
        for (Entry<KEY, VALUE> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.hash == hash && (entry.key == key || key.equals(entry.key))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) return containsNullValue();
        for (int i = 0; i < table.length; i++)
            for (Entry entry = table[i]; entry != null; entry = entry.next)
                if (value.equals(entry.value)) return true;
        return false;
    }

    private boolean containsNullValue() {
        for (int i = 0; i < table.length; i++)
            for (Entry entry = table[i]; entry != null; entry = entry.next)
                if (entry.value == null) return true;
        return false;
    }

    /*
    * Below not implemented
    */

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
