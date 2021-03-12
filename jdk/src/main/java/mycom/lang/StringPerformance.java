package mycom.lang;

import org.junit.Test;

public class StringPerformance {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String a = "test";
        for (int i = 1; i < 10000; i++) {
            a +=i;
        }
        System.out.println(System.currentTimeMillis()-start);
    }
    @Test
    public void stringBuilder(){
        long start = System.currentTimeMillis();
        StringBuilder a = new StringBuilder("test");
        for (int i = 10; i < 1000000; i++) {
            a.append(i);
        }
        System.out.println(System.currentTimeMillis()-start);
    }

    @Test
    public void stringBuffer(){
        long start = System.currentTimeMillis();
        StringBuffer a = new StringBuffer("test");
        for (int i = 10; i < 1000000; i++) {
            a.append(i);
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
/**
 * String增加值过程
 * 循环内每一步 都伴随着
 * new StringBuilder -> StringBuilder.init() -> StringBuilder.append -> StringBuilder.toString
 *
 NEW java/lang/StringBuilder
 DUP
 INVOKESPECIAL java/lang/StringBuilder.<init> ()V
 ALOAD 1
 INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 ILOAD 2
 INVOKEVIRTUAL java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
 INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
 *
 * StringBuilder追加值过程
 * 循环内部只做
 *  StringBuilder.append操作，性能明显优于String
 *
 *  StringBuffer构建就是StringBuffer，单线程情和StringBuilder况线程几乎无差异；线程安全建议使用StringBuilder
 */
