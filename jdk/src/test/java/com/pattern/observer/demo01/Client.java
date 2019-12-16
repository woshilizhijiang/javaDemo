package com.pattern.observer.demo01;

import com.pattern.observer.demo01.impl.ConcreteObserver;
import com.pattern.observer.demo01.impl.ConcreteSubject;
import com.pattern.observer.demo01.interfaces.Subject;

import java.util.Observer;

public class Client {
    public static void main(String[] args) {
        //create a subject
        Subject subject = new ConcreteSubject();

        //define a observer
        Observer obs = new ConcreteObserver();

        //observer watch subject
        subject.addObserver(obs);

        //dosomething
        ((ConcreteSubject) subject).doSomething();


    }
}
