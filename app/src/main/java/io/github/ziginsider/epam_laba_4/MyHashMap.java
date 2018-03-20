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
    private Node[] table;
    private int treshold;
    private final float loadFactor;

    

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
    public Object get(Object o) {
        return null;
    }

    @Override
    public Object put(Object o, Object o2) {
        return null;
    }

    @Override
    public Object remove(Object o) {
        return null;
    }

    @Override
    public void putAll(@NonNull Map map) {

    }

    @Override
    public void clear() {

    }

    @NonNull
    @Override
    public Set keySet() {
        return null;
    }

    @NonNull
    @Override
    public Collection values() {
        return null;
    }

    @NonNull
    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
