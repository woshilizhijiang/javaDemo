package com.java8.basic.valueReference;

public class PassValueOrReference {
    public static void main(String[] args){
        PassValueOrReference pvr = new PassValueOrReference();
        String str = "liyuanxin";
        int it = 11;
        char[] chs = {'a','b'};
        pvr.change(str,it,chs);
        System.out.println(str);
        System.out.println(it);
        System.out.println(chs[0]);
    }

    public void change(String str,int it,char[] chs){
        str = "值传递";
        it = 22;
        chs[0]='d';
    }


    //值传递  不变
    public void set(int i){
        i=100;
    }
    //值传递  不变
    public static void setStactic(int i){
        i=100;
    }
    //引用传递  不变
    public void setStr(String i){
        i="4445651aas";
    }
}
