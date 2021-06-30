package com.java8.collection;

import org.junit.Test;

import java.util.HashMap;

public class HashBasic {

    @Test
    public void test(){
        String key = "1";
        System.out.println(hash(key));
        Object obj = new Object();
        System.out.println(obj.hashCode());
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
