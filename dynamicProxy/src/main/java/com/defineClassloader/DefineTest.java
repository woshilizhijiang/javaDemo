package com.defineClassloader;

import com.Programmer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class DefineTest {
    public static void main(String[] args) throws FileNotFoundException, IOException,IllegalAccessException,InstantiationException,NoSuchMethodException, InvocationTargetException {
        // 获取字节码数组
        String classRoot = Programmer.class.getResource("/").getPath();
        InputStream is = new FileInputStream(classRoot + "/com/defineClassloader/Programmer.class");
        byte[] bs = new byte[is.available()];
        int len = is.read(bs);

        // 将字节码数组转化为内存中的类对象
        Class<Programmer> clazz = new MyClassLoader<Programmer>().defineMyClass(null,bs,0,len);
        System.out.println("生成的class对象为：" + clazz.getCanonicalName());

        // 利用反射生成对象并调用对象的方法
        Object o = clazz.newInstance();
        clazz.getMethod("code", null).invoke(o, null);
    }
}
