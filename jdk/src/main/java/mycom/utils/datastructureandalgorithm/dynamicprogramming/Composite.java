package mycom.utils.datastructureandalgorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * f(0)=1   n=1
 * f(n)=2f(n-1)+1  n>1
 * Created by 20013649 on 2020/7/13.
 */
public class Composite {
    public static void main(String[] args) {
        int[] arr={1,10,100,1000};
        List<Integer> aList=new ArrayList<>();
        List<Integer> bList=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            aList.add(arr[i]);
        }
        getSonSet1(0,aList,bList);
        getByte(arr,arr.length);
    }

    public static void getSonSet1(int i,List<Integer> aList,List<Integer> bList){
        if(i>aList.size()-1){
            if(bList.size()<=0){
            }else {
                int sum = 0;
                for(int m=0;m<bList.size();m++){
                    sum += bList.get(m);
                }
                System.out.print(sum + ",");
            }
        }else {
            bList.add(aList.get(i));
            getSonSet1(i+1, aList, bList);
            int bLen=bList.size();
            bList.remove(bLen-1);
            getSonSet1(i+1, aList, bList);
        }
    }

    public static void getByte(int[] arr, int length){
        int mark = 0;
        int nEnd = 1 << length;
        boolean bNullSet = false;

        for (mark = 0; mark < nEnd;mark++){
            bNullSet = true;
            for (int i = 0; i < length; i++) {
                if (((1<<i)&mark) != 0){
                    bNullSet = false;
                    System.out.print(arr[i] + ", ");
                }
            }
            if (bNullSet){
                System.out.print("@");
            }
            System.out.println();
        }
    }

}
