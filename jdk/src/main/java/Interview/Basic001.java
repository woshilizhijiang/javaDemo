package Interview;

import org.junit.Test;

public class Basic001 {
    @Test
    public void test001(){
        short s1 = 1;
        s1 = (short) (s1 + 1);//必须强行转换
        System.out.println(s1);
        s1 += 1;//自带强行转换
        System.out.println(s1);
    }

    @Test
    public void test002(){
        System.out.println(2<<1);
    }
}
