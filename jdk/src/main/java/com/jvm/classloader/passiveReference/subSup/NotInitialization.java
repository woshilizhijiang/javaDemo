package com.jvm.classloader.passiveReference.subSup;

import com.jvm.classloader.passiveReference.Const.ConstClass;

/**
 *
 * load但是没有初始化子类
 *
 * [Loaded com.jvm.classloader.passiveReference.subSup.NotInitialization from file:/Users/lzj11/Documents/developerCenter/github/forjava/jdk/target/classes/]
 * [Loaded sun.launcher.LauncherHelper$FXHelper from /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar]
 * [Loaded java.lang.Class$MethodArray from /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar]
 * [Loaded java.lang.Void from /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar]
 * [Loaded com.jvm.classloader.passiveReference.subSup.SuperClass from file:/Users/lzj11/Documents/developerCenter/github/forjava/jdk/target/classes/]
 * [Loaded com.jvm.classloader.passiveReference.subSup.SubClass from file:/Users/lzj11/Documents/developerCenter/github/forjava/jdk/target/classes/]
 *
 * SuperCLass
 * 123
 * [Loaded java.lang.Shutdown from /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar]
 * [Loaded java.lang.Shutdown$Lock from /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar]
 *
 */
public class NotInitialization {

    public static void main(String[] args) {
//        System.out.println(SubClass.value);
//        SuperClass[] sca = new SuperClass[10];
        //调用常量区信息，不到时class初始化
        System.out.println(ConstClass.HELLOWORLD);
    }

}
