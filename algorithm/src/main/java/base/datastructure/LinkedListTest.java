package base.datastructure;

import org.junit.Test;

import java.util.LinkedList;

public class LinkedListTest {

    @Test
    public void readTest(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);

        list.add(2);
        for (int i = 0; i < 100; i++) {
            System.out.println(list.get(1));
        }

    }
}
