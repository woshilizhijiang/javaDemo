package mycom.date;

import org.junit.Test;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {

        String strHash = "11.781112";

        String capValue =strHash.substring(0,strHash.indexOf(".")+2) ;
        System.out.println(capValue);
    }

    @Test
    public void test(){
        String cpuNum = null;
        String memSize = null;
        String spec = cpuNum + "/C"+memSize +"/G";
        System.out.println(spec);


        String tt = "20年818监控";
        System.out.println(tt.hashCode());
    }

    @Test
    public void test02(){
        String operContent = String.format("%s创建容量记录：容量版本%s容量规格%s", "33333fa","ttt",
                "test");
        System.out.println(operContent);
    }
}
