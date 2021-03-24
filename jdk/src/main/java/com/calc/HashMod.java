package com.calc;

/**
 *  基于 x mod 2^n = x & (2^n - 1)
 *  右边效率高于左边
 */
public class HashMod {
    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 400000000; i++) {
            modCal(111111 ,5);
        }
        System.out.println("end " + (System.nanoTime() -start));

        long start2 = System.nanoTime();
        for (int i = 0; i < 400000000; i++) {
            modCal2(111111 ,5);
        }
        System.out.println("en2 " + (System.nanoTime() -start2));
    }

    public static int modCal(int init,int n){
//        System.out.println(init % 2^n);
        return init % 2^n;
    }

    public static int modCal2(int init,int n){
//        System.out.println(init & (2^n - 1));
        return init & (2^n - 1);
    }
}
