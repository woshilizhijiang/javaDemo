package mycom.patterns.objectaction.chain;

/**
 * Created by 20013649 on 2020/7/8.
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        handler1.handleRequest("two");
    }
}
abstract class Handler{
    private Handler next;
    public Handler getNext() {
        return next;
    }
    public void setNext(Handler next) {
        this.next = next;
    }
    public abstract void handleRequest(String request);
}
class ConcreteHandler1 extends Handler{
    @Override
    public void handleRequest(String request) {
        if(request.equals("one")){
            System.out.println("具体处理者1负责处理该请求！");
        }else{
            if (null != getNext()){
                getNext().handleRequest(request);
            }else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
class ConcreteHandler2 extends Handler{
    @Override
    public void handleRequest(String request) {
        if(request.equals("two")){
            System.out.println("具体处理者2负责处理该请求！");
        }else{
            if (null != getNext()){
                getNext().handleRequest(request);
            }else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}