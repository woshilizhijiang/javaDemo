package com.pattern.decorator.abstractDemo;

public class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    private void method2(){
        System.out.println("method2  decorator.");
    }

    @Override
    public void operate() {
        this.method2();
        super.operate();
    }
}
