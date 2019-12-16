package com.java8.lamda;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 用lambda表达式实现Runnable
 * lambda表达式替换匿名类
 *
 * lambda语法：
 * (params) -> expression
 * (params) -> statement
 * (params) -> {statements}
 *
 * @author lizj11
 *
 */
public class LambdaDemo {
    public static void main(String[] args) {
        LambdaDemo lr = new LambdaDemo();
        lr.lambdaForeachlist();

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> ((String)str).startsWith("J") );

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print null :");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->((String)str).length() > 4);
    }

    /**
     * lambda表达式和 函数式编程接口Predicate
     * jdk8 新包  java.util.function
     */
    private static void lambdaFunction(){
    }
    public static void filter(List<String> names, Predicate condition){
        for (String name: names) {
            if (condition.test(name)){
                System.out.println(name + " ");
            }
        }

//        names.forEach((name) -> {
//            if (condition.test(name)){
//                System.out.println(name + " ");
//            }
//        });

    }


    private void lambdaComparator(){
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {

                return a1.getWeight().compareTo(a2.getWeight());
            }
        };

        //Lambda
        Comparator<Apple> byWeightLambda = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        System.out.println(byWeight);

    }

    /**
     * lambda实现Runnable
     *  @author lizj11
     */
    private void lambdaRunnable(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + " : Before Java8, too much code for too little to do");
//            }
//        },"Thread1").start();
        new Thread(
                ()-> System.out.println(Thread.currentThread().getName() + " : In Java8, Lamda expression rocks!!"),
                "Thread2").start();
    }

    private void lambdaTrans(){
        JButton show = new JButton("Show");
//        show.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Event handling without lambda expression is boring");
//            }
//        });

        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });

    }

    private void lambdaForeachlist(){

        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        for (String feature : features) {
//            System.out.println(feature);
//        }
        System.out.println("******************************************************************");

        //lambda表达式
        features.forEach((n)->System.out.println(n));
        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
//        features.forEach(System.out::println);
    }

}
