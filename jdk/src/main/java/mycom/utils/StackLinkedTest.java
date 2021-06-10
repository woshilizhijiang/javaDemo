package mycom.utils;

public class StackLinkedTest {

    public static void main(String[] args) {
        LinkStack<Integer> linkStack = new LinkStack<>();
        linkStack.addStack(1);
        linkStack.addStack(2);
        linkStack.addStack(3);
        linkStack.addStack(4);
        linkStack.addStack(5);
        for (int i = 0; i < linkStack.getSize(); i++) {
            System.out.println(linkStack.outStack() + " : " + i);
        }
    }

}
class MyStack<T>{
    private T data;

    private MyStack<T> next;

    MyStack(T data, MyStack<T> next){
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyStack<T> getNext() {
        return next;
    }

    public void setNext(MyStack<T> next) {
        this.next = next;
    }
}

class LinkStack<N>{
    private MyStack<N> head;

    private MyStack<N> tail;

    private Integer size = 0;

    public MyStack<N> getHead() {
        return head;
    }

    public void setHead(MyStack<N> head) {
        this.head = head;
    }

    public MyStack<N> getTail() {
        return tail;
    }

    public void setTail(MyStack<N> tail) {
        this.tail = tail;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean headIsNull(){
        if(head == null){
            return true;
        }
        return false;
    }

    public void addStack(N data){
        MyStack<N> node = new MyStack<>(data,null);
        if (headIsNull()){
            head = node;
            tail = node;
            size++;
        }else {
            node.setNext(head);
            head = node;
            size++;
        }
    }

    public N outStack(){
        if (size > 0){
            N outData = head.getData();
            head = head.getNext();
            return outData;
        }else {
            throw new RuntimeException("栈里无元素!");
        }
    }
}
