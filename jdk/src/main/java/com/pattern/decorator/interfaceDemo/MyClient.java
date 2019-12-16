package com.pattern.decorator.interfaceDemo;

public class MyClient {
    public static void main(String[] args) {
        IMyInit iMyInit = new MyInitImpl();
        iMyInit = new MyDecoratorImpl1(iMyInit);
        iMyInit = new MyDecoratorImpl2(iMyInit);
        iMyInit.getName();

    }
}
