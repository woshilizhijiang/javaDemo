package Interview;

import java.text.NumberFormat;

public class PerCent {
    public static void main(String[] args) {
        int diliverNum=3;//举例子的变量
        int queryMailNum=9;//举例子的变量
// 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
// 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float)diliverNum/(float)queryMailNum*100);
        System.out.println("diliverNum和queryMailNum的百分比为:" + result + "%");
    }
}
