package com.java8.basic;

import com.java8.basic.interfaces.MyInterface;

public class BasicDemo implements MyInterface{

    @Override
    public void getId() {
        System.out.println("MyId");
    }

    public BasicDemo(){}

    public static void main(String[] args) {
        BasicDemo.getName();
        MyInterface mi = new BasicDemo();

        mi.getId();
    }

    public static void getName(){
        System.out.println("bytecode is invokestatic");
    }
}
