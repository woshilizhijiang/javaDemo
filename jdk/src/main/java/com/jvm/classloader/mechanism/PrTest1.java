package com.jvm.classloader.mechanism;

/**
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * <Description> 输出：Initialize class Dgrandpa
 *                         Initialize class Dfather<br>
 *  *  对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，
 *  *  只会触发父类的初始化而不会触发子类的初始化。至于是否要触发子类的加载和验证，在虚拟机中并未明确规定，
 *  *  这点取决于虚拟机的具体实现。对于Sun HotSpot虚拟机来说，可通过-XX:+TraceClassLoading参数观察到此操作
 *  *  会导致子类的加载。
 *
 * JVM参数-XX:+TraceClassLoading看子类会被加载
 * [Loaded com.jvm.classloader.mechanism.Dgrandpa from file:/Users/lzj11/Documents/developerCenter/github/forjava/jdk/target/classes/]
 * [Loaded com.jvm.classloader.mechanism.Dfather from file:/Users/lzj11/Documents/developerCenter/github/forjava/jdk/target/classes/]
 * [Loaded com.jvm.classloader.mechanism.Dson from file:/Users/lzj11/Documents/developerCenter/github/forjava/jdk/target/classes/]
 *
 */
public class PrTest1 {

    public static void main(String[] args) {
        //打印
        // Initialize class Dgrandpa
        //Initialize class Dfather
        //Dson未被初始化
        //
        int x = Dson.count;
    }

}
class Dgrandpa{
    static {
        System.out.println("Initialize class Dgrandpa");
    }
}
class Dfather extends Dgrandpa{
    static int count = 1;
    static{
        System.out.println("Initialize class Dfather");
    }
}

class Dson extends Dfather{
    static{
        System.out.println("Initialize class Dson");
    }
}


