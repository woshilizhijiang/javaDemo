package com.pattern.observer.demo01.impl;

import java.util.Observable;
import java.util.Observer;

public class ConcreteObserver implements Observer {


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("receive message! call me later" +  arg);
    }
}
