package com;

public class TryFinallyReturn {
    public static void main(String[] args) {
        System.out.println("结果： " + test());
    }
    //返回1 方法内i=2;印证了java是值传递,不是引用传递
    static int test() {
        int i = 1;
        try {
            System.out.println("try里面的i : " + i);
            return i;
        } finally {
            System.out.println("进入finally...");
            ++i;
            System.out.println("fianlly里面的i : " + i);
//            return i;
        }
    }
}
