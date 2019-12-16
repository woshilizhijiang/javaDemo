package com.java8.basic;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

//        System.out.println(Demo.class.getClass());
//        System.out.println(Demo.class.getClassLoader());
//        System.out.println(Demo.class.getName());

        /**
         *  bootstrap class loader
         *  引导类加载器/启动类加载器
         *
         *  结果如下
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/resources.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/sunrsasign.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/jsse.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/jce.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/charsets.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/jfr.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/classes
         *
         * 加载java的核心类库
         *
         */
        String[] files = System.getProperty("sun.boot.class.path").split(":");
        Arrays.asList(files).forEach(System.out::println);
        String model = "*************";
        System.out.println(model);


        /**
         * extensions class loader
         * 扩展类加载器，用来加载java的扩展库
         * /Users/lzj11/Library/Java/Extensions
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext
         * /Library/Java/Extensions
         * /Network/Library/Java/Extensions
         * /System/Library/Java/Extensions
         * /usr/lib/java
         */
        String[] extFiles = System.getProperty("java.ext.dirs").split(":");
        Arrays.asList(extFiles).forEach(System.out::println);


        System.out.println(model);

        /**
         *  system class loader/application class loader
         *  系统类加载器
         *
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/charsets.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/deploy.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext/cldrdata.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext/dnsns.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext/jaccess.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext/jfxrt.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext/localedata.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext/nashorn.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext/sunec.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/ext/zipfs.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/javaws.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/jce.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/jfr.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/jfxswt.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/jsse.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/management-agent.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/plugin.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/resources.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/rt.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/lib/ant-javafx.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/lib/dt.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/lib/javafx-mx.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/lib/jconsole.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/lib/packager.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/lib/sa-jdi.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/lib/tools.jar
         *
         * /Users/lzj11/Documents/developerCenter/github/forjava/jdk/target/classes
         * /Users/lzj11/.m2/repository/com/google/protobuf/protobuf-java/3.6.1/protobuf-java-3.6.1.jar
         * /Users/lzj11/.m2/repository/com/alibaba/fastjson/1.2.8/fastjson-1.2.8.jar
         *
         */

        String[] appFiles = System.getProperty("java.class.path").split(":");
        Arrays.asList(appFiles).forEach(System.out::println);

        String  aa = "ddd";
        System.out.println(model);
        System.out.println(Demo.class.getClassLoader()); //sun.misc.Launcher$AppClassLoader@330bedb4
        System.out.println(aa.getClass().getClassLoader());
        System.out.println(String.class.getClassLoader());
    }
}
