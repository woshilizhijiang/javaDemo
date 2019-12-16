package com.jvm.classloader.postiveReference.demo;

/**
 *
 * // class version 52.0 (52)
 * // access flags 0x21
 * public class com/jvm/classloader/postiveReference/demo/PostiveClass {
 *
 *   // compiled from: PostiveClass.java
 *
 *   // access flags 0x9
 *   public static I age
 *
 *   // access flags 0x9
 *   public static I number
 *
 *   // access flags 0x1
 *   public <init>()V
 *    L0
 *     LINENUMBER 57 L0
 *     ALOAD 0
 *     INVOKESPECIAL java/lang/Object.<init> ()V
 *     RETURN
 *    L1
 *     LOCALVARIABLE this Lcom/jvm/classloader/postiveReference/demo/PostiveClass; L0 L1 0
 *     MAXSTACK = 1
 *     MAXLOCALS = 1
 *
 *   // access flags 0x9
 *   public static myAddress()V
 *    L0
 *     LINENUMBER 63 L0
 *     GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
 *     LDC "Address is pass!!"
 *     INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
 *    L1
 *     LINENUMBER 64 L1
 *     BIPUSH 44
 *     PUTSTATIC com/jvm/classloader/postiveReference/demo/PostiveClass.number : I
 *    L2
 *     LINENUMBER 65 L2
 *     RETURN
 *     MAXSTACK = 2
 *     MAXLOCALS = 0
 *
 *   // access flags 0x8
 *   static <clinit>()V
 *    L0
 *     LINENUMBER 59 L0
 *     BIPUSH 12
 *     PUTSTATIC com/jvm/classloader/postiveReference/demo/PostiveClass.age : I
 *     RETURN
 *     MAXSTACK = 1
 *     MAXLOCALS = 0
 * }
 *
 *
 */

public class PostiveClass {

    public static int age = 12;
    public static int number;

    public static void myAddress(){
        System.out.println("Address is pass!!");
        number = 44;
    }

}
