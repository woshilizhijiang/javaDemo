package com.calc;

public class Numbs {
    private static final int COUNT_BITS = Integer.SIZE - 3;


    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    private static int ctlOf(int rs, int wc) { return rs | wc; }

    private static int workerCountOf(int c)  { return c & CAPACITY; }

    public static void main(String[] args) {
        System.out.println(RUNNING);
        System.out.println(ctlOf(RUNNING,0));
        System.out.println(workerCountOf(ctlOf(RUNNING,0)));
    }

    private static int smalles(int n){
        double x=Math.sqrt(n);
        long res=0;
        if(n<=0){
            res=0;
        }else if(((long)x*(long)x)==n){
            res=(long)x;
        }else {
            res=(long) x+1;
        }
        return (int)res;
    }
}
