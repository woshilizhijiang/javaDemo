package com.pattern.observer.demo01.interfaces;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public abstract class Subject {
    private Vector<Observer> obsVector = new Vector<>();

    public void addObserver(Observer o){
        this.obsVector.add(o);

    }

    public void delObserver(Observer o){
        this.obsVector.remove(o);

    }

    public void notifyObservers(Observable o, String args){
        obsVector.forEach(observer -> observer.update(null,null));
    }
}
