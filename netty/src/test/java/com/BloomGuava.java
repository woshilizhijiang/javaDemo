package com;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomGuava {

    private static int size = 1000000;
    private static double fpp = 0.01;//期望的误判率

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),size,fpp);

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++){
            bloomFilter.put(i);
        }
        int count = 0;
        for (int i = 1000000; i < 2000000; i++){
            if(bloomFilter.mightContain(i)){
                count++;
                System.out.println(i + "误判了" );
            }
        }
        //10314
        System.out.println("总共的误判数:" + count);

    }
}
