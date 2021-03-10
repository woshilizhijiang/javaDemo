package mycom.lang;

import org.junit.Test;

import java.util.Arrays;

/**
 * String 为不可变   final类 不可被继承；
 * String 为char[]数组
 *
 * 使用的场景：
 * 1.分隔符
 * 2.
 */
public class TestString {

    /**
     * String字符串多种类型分隔符
     * 1.普通字符加逻辑与判断
     * 2.正则转义判断
     */
    @Test
    public void mutilSplit(){
        String str = "aa,bbccfd.dafd%over";
        String[] ss = str.split("\\,|\\.|\\%"); //普通分隔
//        String[] ss = str.split("[\\,\\.\\%]"); //转义分隔
        Arrays.stream(ss).forEach(System.out::println);
    }

    @Test
    public void stringIsCharArray(){
        String str = "abc";
        char data[] = {'a', 'b', 'c'};
        String str2 = new String(data);
        System.out.println(str.equals(str2)); //true
    }
}
