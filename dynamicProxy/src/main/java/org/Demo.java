package org;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NotFoundException {

        ClassPool cp = ClassPool.getDefault();

        CtClass clazz = cp.get("org.TestClass");
        CtMethod method = clazz.getDeclaredMethod("compute");

//        compute called with param: [5], return: 1005
        method.insertAfter("System.out.println(\"compute called with param: \" + java.util.Arrays.toString($args) + \", return: \" + $_);");

        clazz.toClass();
        clazz.detach();
        TestClass test = new TestClass();
        test.compute(5);

    }

    private static void createAutClass() throws CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // ClassPool包含所有动态生成的类，getDefault()返回默认的ClassPool，
        ClassPool cp = ClassPool.getDefault();
        // 动态生成一个类
        CtClass gclazz = cp.makeClass("com.AAA");
        CtMethod gmethod = CtMethod.make
                ("public void sayHello() { System.out.println(\"Hello Javaassist\"); }", gclazz);
        gclazz.addMethod(gmethod);
        // 转换成Class
        Class<?> gc = gclazz.toClass();
        // 将该CtClass从ClassPool中移除，
        gclazz.detach();
        // 调用方法
        Object ginst = gc.newInstance();
        Method gm = gc.getMethod("sayHello");
        gm.invoke(ginst);
    }
}
