package mycom.stream.function;

import java.util.function.Consumer;

/**
 * Consumer<T>：消费型接口
 * 抽象方法： void accept(T t)，接收一个参数进行消费，但无需返回结果。
 * 默认方法： andThen(Consumer<? super T> after)，
 *          先消费然后在消费，先执行调用andThen接口的accept方法，然后在执行andThen方法参数after中的accept方法。
 *
 *
 * Created by 20013649 on 2020/6/28.
 */
public class ConsumerTest {
    public static void main(String[] args){
//        Consumer consumer = System.out::println;
//        consumer.accept("hello function");

        Consumer<String> consumer1 = s -> System.out.print("车名："+s.split(",")[0]);
        Consumer<String> consumer2 = s -> System.out.print("-->颜色："+s.split(",")[1] + System.getProperty("line.separator"));
        String[] strings = {"保时捷,白色", "法拉利,红色","奔驰,黑色"};
        for (String str: strings) {
            consumer1.andThen(consumer2).accept(str);
        }
    }
}
