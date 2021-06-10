package mycom.utils;

import org.junit.Test;

import java.util.Stack;

public class StackTest {
    @Test
    public void demo01(){
        Stack<Integer> st = new Stack<>();
        st.push(42);
        st.push(66);
        st.push(99);
        System.out.println(st);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println("****************************");
        st.stream().forEach(st1->{
            System.out.println(st1.intValue());
        });

    }
}
