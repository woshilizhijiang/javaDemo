package mycom.stream.function;

import java.util.function.Supplier;

/**
 *
 * Supplier<T>: 供给型接口
 * 抽象方法：T get()，无参数，有返回值。
 *
 *
 * Created by 20013649 on 2020/6/28.
 */
public class SuppilerTest {
    public static void main(String[] args){
        Supplier<String> supplier = () -> "我们都喜欢李球球";
        System.out.println(supplier.get());
    }
}
