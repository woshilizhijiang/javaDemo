package com.jvm;

import java.util.Vector;

public class LockAnsy {
    public static Vector<Integer> obj = new Vector<Integer>();

    public static void main(String[] args) {

        synchronized (obj){
            System.out.println("aa");
        }

    }

    public synchronized  void getName(){
        System.out.println("aa");
    }
}
