package mycom.callback.async;

public class A implements CallBack {
    private B b;
    public A(B b){
       this.b = b;
    }
    public void ask(String question){
        System.out.println("A问了B一个问题");
        new Thread(()->{
            b.executeMessage(A.this,question);
        }).start();
        play();
    }
    public void play(){
        System.out.println("A：我要逛街去了");
    }
    @Override
    public void solve(String result) {
        System.out.println("B告诉A的答案是--》"+result);
    }
}
