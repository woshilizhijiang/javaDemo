package mycom.patterns.objectaction.template;

/**
 * Created by 20013649 on 2020/6/30.
 */
public class TemplateMethodPattern {
    public static void main(String[] args){
//        AbstractClass tm = new ConcreteClass();
//        tm.templateMethod();
        AbstractClass tmb = new ConcreteClassB();
        tmb.templateMethod();
    }
}
abstract class AbstractClass{
    public void templateMethod(){
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    public void specificMethod(){
        System.out.println("抽象类中的具体方法被调用...");
    }
    public abstract void abstractMethod1();
    public abstract void abstractMethod2();
}
class ConcreteClass extends AbstractClass{
    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
class ConcreteClassB extends AbstractClass{
    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1B的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2B的实现被调用...");
    }
}