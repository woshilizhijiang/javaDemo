package com.netty;

import io.netty.util.NettyRuntime;

public class ConstantTMP {
    public static void main(String[] args) {
        System.out.println(NettyRuntime.availableProcessors());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
