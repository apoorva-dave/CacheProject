package com.demo.cache.service;

import com.demo.cache.api.Cache;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SimpleCache implements Cache {

    Map<Object, Object> entries = new HashMap<>();

    private static SimpleCache INSTANCE = null;

    private SimpleCache() {

    }

    public static synchronized SimpleCache getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SimpleCache();
        }
        return INSTANCE;
    }

    @Override
    public void add(Object key, Object value) {
        entries.put(key, value);
    }

    @Override
    public Optional<Object> read(Object key) {
        return Optional.ofNullable(entries.get(key));
    }

    @Override
    public void clear() {
        entries.clear();
    }
}
