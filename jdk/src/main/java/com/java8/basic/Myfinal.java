package com.java8.basic;

public class Myfinal {
    private int  qq = 12;

    private String getfinal(){
        return "";
    }

    final class MyDemoFinal{
        private final int  qq = 12;
        private final String getfinal(){
            return "";
        }
    }

//    class Myextend extends MyDemoFinal{
//
//    }

    public static void main(String[] args) {
        System.out.println("Final.");
    }
}
