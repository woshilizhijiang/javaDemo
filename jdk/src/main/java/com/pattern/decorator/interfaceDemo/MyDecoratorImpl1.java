package com.pattern.decorator.interfaceDemo;

public class MyDecoratorImpl1 extends MyDecorator{


    public MyDecoratorImpl1(IMyInit iMyInit) {
        super(iMyInit);
    }

    public void preTest(){
        System.out.println("爸爸爱球球。。");
    }

    @Override
    public void getName() {
        this.preTest();
        super.getName();
    }
}
