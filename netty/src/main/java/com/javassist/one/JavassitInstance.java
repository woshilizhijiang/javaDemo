package com.javassist.one;

import javassist.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class JavassitInstance {

    public static void main(String[] args) throws Exception {
        JavassitInstance.createClass();
    }
    public static void createClass() throws CannotCompileException, NotFoundException {
        //等价于ClassPool cp = ClassPool.getDefault();
        ClassPool cp = new ClassPool();
        cp.appendSystemPath();

        CtClass userClass = cp.makeClass("com.javassist.one.HelloOne");

        CtField idField = new CtField(CtClass.longType,"id",userClass);
        userClass.addField(idField);

        CtField nameField = new CtField(cp.get("java.lang.String"),"name", userClass);
        userClass.addField(nameField);

        CtMethod getMethod = CtNewMethod.make("public String getName(){return this.name;}", userClass);
        CtMethod setMethod = CtNewMethod.make("public void setName(String name){this.name = name;}", userClass);

        userClass.addMethod(setMethod);
        userClass.addMethod(getMethod);

        Class clazz = userClass.toClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType() + ":" + field.getName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getReturnType() + "-" + method.getName() + "-"
                    + Arrays.toString(method.getParameterTypes()));
        }


    }

}
