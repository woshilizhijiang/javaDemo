package com.java8.concurrency.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * JMX查询一个普通线程包含哪些线程
 * [6] Monitor Ctrl-Break
 * [5] Attach Listener
 * [4] Signal Dispatcher    分发处理发送给JVM信号的线程
 * [3] Finalizer            调用对象finalize方法
 * [2] Reference Handler    清除Reference
 * [1] main                 main线程，用户程序入口
 */
public class MutilThread {
    public static void main(String[] args) {
        //获取java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        //不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        //遍历线程
        for (ThreadInfo threadInfo:
             threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() +  "] " + threadInfo.getThreadName());
        }
    }
}
