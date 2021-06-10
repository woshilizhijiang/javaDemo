package base.datastructure;

import org.junit.Test;

import java.util.Arrays;

public class ArrayTest {
    /**
     * 时间复杂度O(1)
     */
    @Test
    public void readTest(){
        int[] array = new int[]{3,1,2,5,4,9,7,2};
        System.out.println(array[3]);
    }

    /**
     * 时间复杂度O(1)
     */
    @Test
    public void updateTest(){
        int[] array = new int[]{3,1,2,5,4,9,7,2};
        System.out.println(array[5]);
        array[5]=10;
        System.out.println(array[5]);
    }
    /**
     * 时间复杂度O(n)
     * 尾部插入
     * 中间出入
     * 超范围插入
     */
    @Test
    public void insertTest(){
        int[] array = new int[9];
        array[8] = 8;
//        System.out.println(array[8]);
        Arrays.stream(array).forEach(System.out::println);
    }
    /**
     * 时间复杂度O(n)
     **/
    @Test
    public void deleteTest(){
        int[] array = new int[]{3,1,2,5,4,9,7,2};
    }

}
