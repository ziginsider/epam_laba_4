package io.github.ziginsider.epam_laba_4;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implementation HashMap by interface {@link Map}
 *
 * <p>Implemented methods: {@link MyHashMap#hash(int)}, {@link MyHashMap#indexFor(int, int)},
 * {@link MyHashMap#size()}, {@link MyHashMap#isEmpty()}, {@link MyHashMap#put(Object, Object)},
 * {@link MyHashMap#get(Object)}, {@link MyHashMap#containsKey(Object)},
 * {@link MyHashMap#containsValue(Object)}, {@link MyHashMap#clear()}, {@link MyHashMap#values()},
 * {@link MyHashMap#remove(Object)}
 *
 * <p>Not implemented methods: {@link MyHashMap#putAll(Map)}, {@link MyHashMap#keySet()},
 * {@link MyHashMap#entrySet()}
 *
 * @author Alex Kisel
 * @since 2018-03-20
 */
public class MyHashMap<KEY, VALUE> implements Map<KEY, VALUE> {
    private static final int START_CAPACITY = 16;
    private static final float START_LOAD_FACTOR = 0.75f;

    private int size;
    private Entry[] table;
    private int threshold;
    private final float loadFactor;

    /**
     * Constructs an empty {@link MyHashMap} with the default initial capacity = 16
     * and the default load factor = 0.75
     */
    public MyHashMap() {
        loadFactor = START_LOAD_FACTOR;
        threshold = (int) (START_CAPACITY * START_LOAD_FACTOR);
        table = new Entry[START_CAPACITY];
        size = 0;
    }

    /**
     * Constructs an empty {@link MyHashMap} with the specified start
     * capacity and load factor
     *
     * @param startCapacity
     * @param loadFactor
     */
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

    /**
     * Constructs an empty {@link MyHashMap} with the specified start
     * capacity and load factor = 0.75
     *
     * @param startCapacity
     */
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

    /**
     * Applies a supplemental hash function to a given hashCode.
     *
     * @param keyHash hash code of Entry's key
     * @return Entry's hash code
     */
    static int hash(int keyHash) {
        keyHash ^= (keyHash >>> 20) ^ (keyHash >>> 12);
        return keyHash ^ (keyHash >>> 7) ^ (keyHash >>> 4);
    }

    /**
     * Returns index for hash code Entry's hash.
     *
     * @param hash Entry's hash code
     * @param length - lenght of {@link MyHashMap#table}
     * @return index in {@link MyHashMap#table}
     */
    static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     *
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     */
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

    /**
     * Returns the value to which the specified key is mapped,
     * or <tt>null</tt> if this map contains no mapping for the key.
     *
     * @param key Entry's key
     * @return returns the value to which the specified key is mapped,
     * or <tt>null</tt> if this map contains no mapping for the key.
     */
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

    /**
     * Returns <tt>true</tt> if this map contains a mapping for the
     * specified key.
     *
     * @param key The key whose presence in this map is to be tested
     * @return <tt>true</tt> if this map contains a mapping for the specified
     * key
     */
    @Override
    public boolean containsKey(Object key) {
        int hash;
        if (key == null) hash = 0;
        else hash = hash(key.hashCode());
        int index = indexFor(hash, table.length);
        for (Entry<KEY, VALUE> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.hash == hash && (entry.key == key || key.equals(entry.key))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns <tt>true</tt> if this map maps one or more keys to the
     * specified value.
     *
     * @param value value whose presence in this map is to be tested
     * @return <tt>true</tt> if this map maps one or more keys to the
     *         specified value
     */
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

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key key whose mapping is to be removed from the map
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     */
    @Override
    public VALUE remove(Object key) {
        int hash;
        if (key == null) hash = 0;
        else hash = hash(key.hashCode());
        int index = indexFor(hash, table.length);
        for (Entry<KEY, VALUE> prev = table[index], entry = prev;
             entry != null;
             prev = entry, entry = entry.next) {
            if (entry.hash == hash && (entry.key == key || key.equals(entry.key))) {
                VALUE oldValue = entry.value;
                size--;
                if (prev == entry) table[index] = entry.next;
                else prev.next = entry.next;
                return oldValue;
            }
        }
        return null;
    }

    /**
     * Removes all of the mappings from this map.
     * The map will be empty after this call returns.
     */
    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++)
            table[i] = null;
        size = 0;
    }

    /**
     * Returns a {@link Collection} view of the values contained in this map.
     *
     * @return Returns a {@link Collection} view of the values contained in this map.
     */
    @NonNull
    @Override
    public Collection<VALUE> values() {
        List<VALUE> values = new MyArrayList<>();
        for (int i = 0; i < table.length; i++)
            for (Entry entry = table[i]; entry != null; entry = entry.next)
                values.add((VALUE) entry.value);
        return values;
    }

    /**
     * Not implemented
     */
    @Override
    public void putAll(@NonNull Map<? extends KEY, ? extends VALUE> map) {
    }

    /**
     * Not implemented
     */
    @NonNull
    @Override
    public Set<KEY> keySet() {
        return null;
    }

    /**
     * Not implemented
     */
    @NonNull
    @Override
    public Set<Map.Entry<KEY, VALUE>> entrySet() {
        return null;
    }
}