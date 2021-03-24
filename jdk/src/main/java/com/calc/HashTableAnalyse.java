package com.calc;

public class HashTableAnalyse {
    public static void main(String[] args) {
        int oldCapacity = 13;
        int newCapacity = (oldCapacity << 1) + 1;
        System.out.println(newCapacity);
    }
}
