package com.jvm.classloader.passiveReference.Const;

public class ConstClass {

    static {
        System.out.println("ConstCLass init!");
    }
    public static final String HELLOWORLD = "hello world";
}
