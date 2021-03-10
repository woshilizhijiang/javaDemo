package mycom.stream.lambda;

import org.assertj.core.util.Lists;

import java.util.Comparator;
import java.util.List;
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
    static String getStr(){
        return "test";
    }

    static  void getStream(){
        List<Human> humans =  Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
       humans.stream().map(p -> p.getName()).forEach(System.out::println);
//        Function<Human,String> f = humans.stream().map(p -> p.getName());
    }

    static void getCompare(){
        List<Human> humans =  Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
//        //递增比较 正常比较
//        Collections.sort(humans, new Comparator<Human>() {
//            @Override
//            public int compare(Human h1, Human h2) {
//                return h1.getAge()-h2.getAge();
//            }
//        });
        //Lambda
        Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
        humans.sort(comparator.reversed());
        for (Human h : humans) {
            System.out.println(h.getName() + " : " + h.getAge());
        }
    }

    static void threadLambda(){
        new Thread(
            ()->{
                System.out.println("hello Lambda！");
            }
        ).start();
    }
}
