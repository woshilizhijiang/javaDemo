package mycom.patterns.objectaction.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject=new ConcreteSubject();
        Observer obs1=new ConcreteObserver1();
        Observer obs2=new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();
    }
}
abstract class Subject{
    protected List<Observer> observers = new ArrayList<>();
    public void add(Observer observer){
        observers.add(observer);
    }
    public void remove(Observer observer){
        observers.remove(observer);
    }
    public abstract void notifyObserver();
}
class ConcreteSubject  extends Subject{
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");

        for(Object obs:observers)
        {
            ((Observer)obs).response();
        }

    }
}
interface Observer{
    void response();
}
class ConcreteObserver1 implements Observer{
    @Override
    public void response() {
        System.out.println("具体观察者1作出反应！");
    }
}
class ConcreteObserver2 implements Observer{
    @Override
    public void response() {
        System.out.println("具体观察者2作出反应！");
    }
}