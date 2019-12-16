package com.pattern.decorator.abstractDemo;

public class ConcreteComponent extends Component {

    @Override
    public void operate() {
        System.out.println("do something");
    }
}
