package com.jvm.classloader.postiveReference.demo;

/**
 * 主动加载
 *
 * // class version 52.0 (52)
 * // access flags 0x21
 * public class com/jvm/classloader/postiveReference/demo/PostiveShow {
 *
 *   // compiled from: PostiveShow.java
 *
 *   // access flags 0x1
 *   public <init>()V
 *    L0
 *     LINENUMBER 6 L0
 *     ALOAD 0
 *     INVOKESPECIAL java/lang/Object.<init> ()V
 *     RETURN
 *    L1
 *     LOCALVARIABLE this Lcom/jvm/classloader/postiveReference/demo/PostiveShow; L0 L1 0
 *     MAXSTACK = 1
 *     MAXLOCALS = 1
 *
 *   // access flags 0x9
 *   public static main([Ljava/lang/String;)V
 *    L0
 *     LINENUMBER 13 L0
 *     GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
 *     GETSTATIC com/jvm/classloader/postiveReference/demo/PostiveClass.age : I
 *     INVOKEVIRTUAL java/io/PrintStream.println (I)V
 *    L1
 *     LINENUMBER 14 L1
 *     GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
 *     GETSTATIC com/jvm/classloader/postiveReference/demo/PostiveClass.number : I
 *     INVOKEVIRTUAL java/io/PrintStream.println (I)V
 *    L2
 *     LINENUMBER 16 L2
 *     BIPUSH 13
 *     PUTSTATIC com/jvm/classloader/postiveReference/demo/PostiveClass.number : I
 *    L3
 *     LINENUMBER 17 L3
 *     GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
 *     GETSTATIC com/jvm/classloader/postiveReference/demo/PostiveClass.number : I
 *     INVOKEVIRTUAL java/io/PrintStream.println (I)V
 *    L4
 *     LINENUMBER 20 L4
 *     INVOKESTATIC com/jvm/classloader/postiveReference/demo/PostiveClass.myAddress ()V
 *    L5
 *     LINENUMBER 21 L5
 *     RETURN
 *    L6
 *     LOCALVARIABLE args [Ljava/lang/String; L0 L6 0
 *     MAXSTACK = 2
 *     MAXLOCALS = 1
 * }
 */
public class PostiveShow {
    public static void main(String[] args) {

        //new psotive_init
//        System.out.println(new PostiveClass());

        //getstatic
        System.out.println(PostiveClass.age);
        System.out.println(PostiveClass.number);
        //putstatic
        PostiveClass.number=13;
        System.out.println(PostiveClass.number);

        //invokestatic
        PostiveClass.myAddress();
    }
}
