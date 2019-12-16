package com.pattern.observer.demo01.impl;


import com.pattern.observer.demo01.interfaces.Subject;

public class ConcreteSubject extends Subject {
    public void doSomething(){
        super.notifyObservers(null,null);
    }
}
