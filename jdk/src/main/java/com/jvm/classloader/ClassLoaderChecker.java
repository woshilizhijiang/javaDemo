package com.jvm.classloader;

import java.lang.reflect.Method;

public class ClassLoaderChecker {
    public static void main(String[] args) throws Exception  {
//        MyClassLoader myClassLoader = new MyClassLoader("/Users/lzj11/Documents/developerCenter/github/forjava/jdk");
//
//        Class c = myClassLoader.loadClass("com.jvm.classloader.Hello");
//        Class b = myClassLoader.loadClass("com.jvm.classloader.Hello");
//        if(c!=null){
//            Object obj=c.newInstance();
//            Method method=c.getMethod("say", null);
//            method.invoke(obj, null);
//            System.out.println(c.getClassLoader());
//        }
//        if(b!=null){
//            Object obj=b.newInstance();
//            Method method=c.getMethod("say", null);
//            method.invoke(obj, null);
//            System.out.println(b.getClassLoader());
//        }

        System.out.println(ClassLoaderChecker.class.getClassLoader());

    }
}
