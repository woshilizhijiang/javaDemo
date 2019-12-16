package com.jvm.classloader.mechanism;

/**
 * <Description> 没有任何输出<br>
 * 通过数组定义来引用类，不会触发此类的初始化
 *
 * [Loaded com.jvm.classloader.mechanism.PrTest2 from file:/Users/lzj11/Documents/developerCenter/github/forjava/jdk/target/classes/]
 * [Loaded sun.launcher.LauncherHelper$FXHelper from /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar]
 * [Loaded java.lang.Class$MethodArray from /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar]
 * [Loaded java.lang.Void from /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar]
 * [Loaded com.jvm.classloader.mechanism.E from file:/Users/lzj11/Documents/developerCenter/github/forjava/jdk/target/classes/]
 * [Loaded java.lang.Shutdown from /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar]
 * [Loaded java.lang.Shutdown$Lock from /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar]
 *
 */
public class PrTest2 {
    public static void main(String[] args) {
        E[] e = new E[10];
    }
}

class E{
    static {
        System.out.println("Initialize class E");
    }
}
