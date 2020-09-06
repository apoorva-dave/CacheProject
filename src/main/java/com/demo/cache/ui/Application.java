package com.demo.cache.ui;

import com.demo.cache.api.Cache;
import com.demo.cache.api.CacheException;
import com.demo.cache.api.CacheFactory;
import com.demo.cache.service.Validator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class Application {
    public static void main(String[] args) throws CacheException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, InvocationTargetException {
        Cache ca = (Cache) CacheFactory.getCache();
        Validator cache = new Validator(ca);
        cache.add("XYZ", "OQR");
        cache.add("Ram", "1234");
        Optional<Object> c = cache.read("Ram");
        if(c != Optional.empty())
            System.out.println(c);
        cache.clear();
        c = cache.read("Apoorva");
        if(c == Optional.empty())
            System.out.println("Key not found in cache");
    }
}
