package mycom.lang;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //从键盘接收数据

        System.out.println("next方式接入:");
        System.out.println(scanner.hasNext());
        if (scanner.hasNext()){
            String str1 = scanner.next();
            System.out.println("输入的数据为："  + str1);
        }
        scanner.close();
    }
}
