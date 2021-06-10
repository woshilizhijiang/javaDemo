package mycom.stream.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * (parameters)  ->   {statements;}
 *   参数列表   操作符    lambda体
 * Created by 20013649 on 2020/6/28.
 */

public class LambdaTest {
    public static void main(String[] args){
        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInteger2 = s -> Integer.parseInt(s);

        Consumer<String> consumer = System.out::println;
        Supplier<Human> supplier = Human::new;
    }

    static void threadLambda(){
        new Thread(
            ()->{
                System.out.println("hello Lambda！");
            }
        ).start();
    }
}
