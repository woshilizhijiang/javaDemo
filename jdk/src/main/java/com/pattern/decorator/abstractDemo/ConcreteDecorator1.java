package com.pattern.decorator.abstractDemo;

public class ConcreteDecorator1 extends Decorator {

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    private void method1(){
        System.out.println("method1  decorator.");
    }

    @Override
    public void operate() {
        this.method1();
        super.operate();
    }
}
