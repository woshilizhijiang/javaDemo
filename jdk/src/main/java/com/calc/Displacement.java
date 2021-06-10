package com.calc;

/**
 * 位移算法
 */
public class Displacement {

    public static void main(String[] args) {
        Displacement displacement = new Displacement();
        boolean flag = displacement.calc(3);
        System.out.println(flag);
    }

    public boolean calc(int n){
        System.out.println("n * 31 : " + n * 31);
        System.out.println("n << 5 - n : " + ((n << 5) - n));
        return n * 31 == (n << 5) - n;
    }
}
