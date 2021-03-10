package mycom.patterns.objectaction.command;

/**
 * Created by 20013649 on 2020/7/7.
 */
public class CommandPattern {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker invoker = new Invoker();
        invoker.setCommand(cmd);
        System.out.println("客户访问调用者的call()方法...");
        invoker.call();
    }
}

/**
 * 调用者
 * 拥有很多command命令对象，不直接访问Receiver
 */
class Invoker{
    private Command command;
    public Invoker(){}
    public void call(){
        System.out.println("调用者执行命令command...");
        command.execute();
    }
    public void setCommand(Command command) {
        this.command = command;
    }
}
interface Command{
    void execute();
}

/**
 * 具体命令实现，拥有Receiver对象
 */
class ConcreteCommand implements Command{
    private Receiver receiver;

    public ConcreteCommand(){
        receiver=new Receiver();
    }
    @Override
    public void execute() {
        receiver.action();
    }
}

/**
 * 具体命令对象的实现者
 */
class Receiver{
    public void action(){
        System.out.println("接收者的action()方法被调用...");
    }
}
