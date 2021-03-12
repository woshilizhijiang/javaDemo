/*
package mycom.stream;

//import com.google.common.collect.ImmutableList;
import mycom.stream.lambda.Human;
import org.assertj.core.util.Lists;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

*/
/**
 *
 * Stream它并不是一个容器，它只是对容器的功能进行了增强，
 * 添加了很多便利的操作,例如查找、过滤、分组、排序等一系列的操作。
 * 并且有串行、并行两种执行模式，并行模式充分的利用了多核处理器的优势，
 * 使用fork/join框架进行了任务拆分，同时提高了执行速度
 *
 * 特点：
 * Stream自己不会存储元素。
 * Stream的操作不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * Stream 操作是延迟执行的。它会等到需要结果的时候才执行。也就是执行终端操作的时候。
 *
 * Stream操作过程
 * 创建Stream----filter----map----......----collec
 * 源数据创建     中间操作                    终端操作
 * 一个Steam
 *
 * Created by 20013649 on 2020/6/28.
 *//*

public class StreamTest {

    //如何创建Stream
    static void createCollectionStream(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        Stream<Integer> stream = integerList.stream();
        Stream<Integer> stream2 = integerList.parallelStream();
    }

    static void createArrayStream(){
        int[] ints = {1,2,3};
        Arrays.stream(ints);
        //LongStream DoubleStream
        IntStream stream = Arrays.stream(ints);
    }
    static void createValueStream(){
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6,1);
        Stream<String> stringStream = Stream.of("a","b","c","d","e","f");
        integerStream.distinct().forEach(System.out::println);
    }
    static void createLimitlessStream(){
//        Stream.generate(Math::random).limit(5).forEach(System.out::println);
        List<Integer> collect = Stream.iterate(0,i->i+1).limit(5).collect(Collectors.toList());
        for (int c: collect) {
            Stream.of(c).forEach(System.out::println);
        }
    }

    //Stream的中间操作
    //如果Stream只有中间操作是不会执行的，当执行终端操作的时候才会执行中间操作，
    // 这种方式称为延迟加载或惰性求值
    static void distinctTest(){
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("A", 13));
        humanList.add(new Human("B", 23));
        humanList.add(new Human("C", 33));
        humanList.add(new Human("A", 13));

//        why A B C A 无效
//        humanList.stream().distinct()
//                .forEach(human -> System.out.println(human.getName()));

        //filter
//        humanList.stream().filter(human -> human.getAge()>15)
//                .forEach(human -> System.out.println(human.getName()));

        //sorted
//        humanList.stream().sorted(Comparator.comparing(Human::getAge).reversed().reversed())
//                .forEach(human -> System.out.println(human.getName()));
        //sorted limit
//        humanList.stream().sorted(Comparator.comparing(Human::getAge).reversed())
//                .limit(1)
//                .forEach(human -> System.out.println(human.getName()));

        //sorted skip 抛弃
//        humanList.stream().sorted(Comparator.comparing(Human::getAge).reversed())
//                .skip(humanList.size() - 1)
//                .forEach(human -> System.out.println(human.getName()));

        //sorted map
        humanList.stream().map(human -> "welcome to " + human.getName())
                .forEach(human->{
                    if ("aaa".equals("bb")){
                        return;
                    }
                });
    }

    static void flatMap(){
        List<Peo> peos = Lists.newArrayList();
        peos.add(new Peo(15,"A", Arrays.asList("1元", "5元")));
        peos.add(new Peo(25,"B", Arrays.asList("10元", "50元")));
        peos.add(new Peo(21,"C", Arrays.asList("100元")));
//        peos.stream().map(peo -> peo.getMoney()).forEach(System.out::println);

        peos.stream().flatMap(peo -> peo.getMoney().stream()).forEach(System.out::println);
    }

    //Stream的终端操作
    //终端操作执行中间操作链，并返回结果。
    // 终端操作我们就不一一介绍了，只介绍一下常用的操作。详细可看java.util.stream.Stream接口中的方法。

    static void terminalTest(){
        List<Peo> users = Lists.newArrayList();
//        users.add(new Peo(15, "A", ImmutableList.of("1元", "5元")));
//        users.add(new Peo(25, "B", ImmutableList.of("10元", "50元")));
//        users.add(new Peo(21, "C", ImmutableList.of("100元")));
        //收集名称到List
        List<String> nameList = users.stream().map(Peo::getName).collect(Collectors.toList());
        //收集名称到List
        Set<String> nameSet = users.stream().map(Peo::getName).collect(Collectors.toSet());
        //收集到map,名字作为key,user对象作为value
        Map<String, Peo> userMap = users.stream()
                .collect(Collectors.toMap(Peo::getName, Function.identity(), (k1, k2) -> k2));
        System.out.println(userMap);
    }

    //Fork/Join框架
    static void forkJoin(){

    }

    public static void main(String[] args){
        terminalTest();
    }


}

class Peo{
    int age;
    String name;
    List<String> money;
    public Peo(int age, String name, List<String> money){
        this.age = age;
        this.name = name;
        this.money = money;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMoney() {
        return money;
    }

    public void setMoney(List<String> money) {
        this.money = money;
    }
}*/
