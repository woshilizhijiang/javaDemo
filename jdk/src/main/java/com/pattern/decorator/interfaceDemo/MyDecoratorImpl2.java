package com.pattern.decorator.interfaceDemo;

public class MyDecoratorImpl2 extends MyDecorator {

    public MyDecoratorImpl2(IMyInit iMyInit) {
        super(iMyInit);
    }
    public void preTest(){
        System.out.println("妈妈爱球球。。");
    }

    @Override
    public void getName() {
        this.preTest();
        super.getName();
    }
}
