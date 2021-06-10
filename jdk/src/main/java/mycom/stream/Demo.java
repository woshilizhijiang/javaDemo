package mycom.stream;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
        integerList.stream().filter(num ->{
            return num > 3;
        }).forEach(System.out::println);
    }
}
