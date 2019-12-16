package com.pattern.decorator.interfaceDemo;

public class MyDecorator implements IMyInit {

    private IMyInit iMyInit = null;

    public MyDecorator(IMyInit iMyInit){
        this.iMyInit = iMyInit;
    }


    @Override
    public void getName() {
        this.iMyInit.getName();
    }

}
