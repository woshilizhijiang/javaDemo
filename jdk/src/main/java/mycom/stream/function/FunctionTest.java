package mycom.stream.function;

import java.util.function.Function;

/**
 *
 * Function<T,R>: 函数型接口
 *
 * 抽象方法： R apply(T t)，传入一个参数，返回想要的结果。
 * Created by 20013649 on 2020/6/28.
 */
public class FunctionTest {
    public static void main(String[] args){
        Function<Integer, Integer> function = e -> e * 6;
        System.out.println(function.apply(6));
    }
}
