package io.github.ziginsider.epam_laba_4;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by zigin on 20.03.2018.
 */

public class MyHashMap<KEY,VALUE> implements Map<KEY,VALUE> {
    private static final int START_CAPACITY = 16;
    private static final float START_LOAD_FACTOR = 0.75f;

    private int size;
    private Entry[] table;
    private int treshold;
    private final float loadFactor;



    static class Entry<KEY,VALUE> implements Map.Entry<KEY,VALUE> {

        final int hash;
        final KEY key;
        VALUE value;
        Entry<KEY,VALUE> next;

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

    /*
    * Below not implemented
    */

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

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
