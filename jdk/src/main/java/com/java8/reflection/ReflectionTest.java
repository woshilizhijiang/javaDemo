package com.java8.reflection;

import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("com.java8.reflection.Online");

        Method mth = cls.getMethod("getName");
        mth.invoke(cls.newInstance());


    }
}
