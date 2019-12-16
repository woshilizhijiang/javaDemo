package com.jvm.oom;

import java.util.ArrayList;
import java.util.List;

public class OOMObject {
    public byte[] placeholder = new byte[64*1024];

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();

    }

    public static void main(String[] args) throws InterruptedException {
        String aa = "abcdeabcdeabcdeabcdeabcdeabcde";

        System.out.println(aa);
        System.out.println(aa.hashCode());

//        fillHeap(10000);
    }
}
