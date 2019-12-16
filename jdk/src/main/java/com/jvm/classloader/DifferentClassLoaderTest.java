package com.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

public class DifferentClassLoaderTest {
    public static void main(String[] args) throws Exception {


        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                InputStream stream = getClass().getResourceAsStream(fileName);
                if (stream == null) {
                    return super.loadClass(name);
                }
                try {
                    int c = stream.available();
                    byte[] b = new byte[c];
                    // 将流写入字节数组b中
                    stream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return super.loadClass(name);
            }
        };

        Object obj = classLoader.loadClass("com.jvm.classloader.DifferentClassLoaderTest").newInstance();
        DifferentClassLoaderTest obj2 = new DifferentClassLoaderTest();

        System.out.println(obj  instanceof DifferentClassLoaderTest);
        System.out.println(obj2 instanceof DifferentClassLoaderTest);


        System.out.println(obj.getClass().getClassLoader() );
        System.out.println(obj2.getClass().getClassLoader());

        System.out.println("自定义类加载器破坏双亲委派：" + obj.getClass().getClassLoader());
        System.out.println("自定义类加载器父加载器：" +obj.getClass().getClassLoader().getParent());
        System.out.println("自定义类加载器父加载器父加载器：" +obj.getClass().getClassLoader().getParent().getParent());
        System.out.println("自定义类加载器父加载器父加载器父加载器：" +obj.getClass().getClassLoader().getParent().getParent().getParent());

        System.out.println("非自定义类加载器：" + DifferentClassLoaderTest.class.getClassLoader());
    }
}
