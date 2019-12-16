package com.jvm.classloader.passiveReference.subSup;

public class SuperClass {

    public static int value = 123;

    static {
        System.out.println("SuperCLass");
    }
}
