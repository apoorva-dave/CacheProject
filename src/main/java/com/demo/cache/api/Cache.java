package com.demo.cache.api;

import java.util.Optional;

public interface Cache {
    /**
     * Adds key value pair in cache
     * @param key
     * @param value
     */
    void add(Object key, Object value) throws CacheException;

    /**
     * Reads value corresponding to given key from cache
     * @param key
     * @return
     */
    Optional<Object> read(Object key);

    /**
     * Clears the cache
     */
    void clear() throws CacheException;
}
