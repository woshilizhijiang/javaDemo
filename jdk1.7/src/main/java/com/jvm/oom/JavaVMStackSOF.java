package com.jvm.oom;

/**
 * jvm栈空间设置
 * VM Args: -Xss256k
 * @lizj11
 *
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    /**
     *  stack length: 2509
     *  Exception in thread "main" java.lang.StackOverflowError
     * 	at com.jvm.instance.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:20)
     * 	at com.jvm.instance.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:20)
     * 	...
     */
    private void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{


        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }
}
