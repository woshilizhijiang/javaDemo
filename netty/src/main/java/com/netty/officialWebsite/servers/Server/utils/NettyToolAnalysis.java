package com.netty.officialWebsite.servers.Server.utils;

import io.netty.util.NettyRuntime;

public class NettyToolAnalysis {
    public static void main(String[] args) {
        getAvailableProcessors();
    }

    /**
     * netty获取可用逻辑处理数量，调用java原生java.lang.Runtime的native方法 availableProcessors();
     * 本机处理器使用超线程技术，物理处理器2个  ，逻辑处理器4个
     */
    private static void getAvailableProcessors(){
        int availableProcessors = NettyRuntime.availableProcessors();
        System.out.println(availableProcessors);
    }
}
