package com.jvm.classloader.parentinvokersonclassloader;

import java.lang.reflect.Method;

public class ClassLoaderTest {
    private static Object fooTestInstance;
    private FooClassLoader fooClassLoader = new FooClassLoader();

    public static void main(String[] args) throws Exception {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        classLoaderTest.initAndLoad();
        fooTestInstance = classLoaderTest.getFooTestInstance();
        System.out.println(fooTestInstance.getClass().getClassLoader());

        Method getFoo = fooTestInstance.getClass().getMethod("getFoo");
        System.out.println(getFoo.invoke(fooTestInstance));
        System.out.println(classLoaderTest.getClass().getClassLoader());
    }

    private void initAndLoad() throws Exception{
        Class<?> aClass = Class.forName("com.jvm.classloader.parentinvokersonclassloader.FooTest",true,fooClassLoader);
        fooTestInstance = aClass.newInstance();
    }
    private Object getFooTestInstance(){
        return fooTestInstance;
    }
}
