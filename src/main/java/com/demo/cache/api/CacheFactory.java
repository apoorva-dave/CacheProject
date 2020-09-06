package com.demo.cache.api;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class CacheFactory {
    public static Object getCache() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Properties props = new Properties();
        props.load(new FileReader("config.properties"));
        String className = props.getProperty("cache");
        Class claz = Class.forName(className);
        Object o = null;
        try {
            o = claz.newInstance();
        }
        catch(Exception e) {
            Method method = claz.getMethod("getInstance");
            o = method.invoke(claz);
        }
        return o;
    }
}
