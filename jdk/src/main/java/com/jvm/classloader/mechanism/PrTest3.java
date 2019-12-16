package com.jvm.classloader.mechanism;

/**
 * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 * [Loaded com.jvm.classloader.mechanism.PrTest3 from file:/Users/lzj11/Documents/developerCenter/github/forjava/jdk/target/classes/]
 *  ConstClass未被加载----原因：ConstClass.COUNT已被放入常量池
 */
public class PrTest3 {
    public static void main(String[] args) {
        System.out.println(ConstClass.COUNT);
    }
}
class ConstClass{
    static final int COUNT = 1;
    static{
        System.out.println("Initialize class ConstClass");
    }
}
