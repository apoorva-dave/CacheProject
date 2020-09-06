package com.demo.cache.service;

import com.demo.cache.api.Cache;
import com.demo.cache.api.CacheException;

import java.util.Optional;

public class Validator implements Cache {

    private Cache cache;

    public Validator(Cache cache) {
        this.cache = cache;
    }

    @Override
    public void add(Object key, Object value) throws CacheException {
        if(key == null) {
            throw new CacheException();
        }
        cache.add(key, value);
    }

    @Override
    public Optional<Object> read(Object key) {
        return cache.read(key);
    }

    @Override
    public void clear() throws CacheException {
        cache.clear();
    }
}
