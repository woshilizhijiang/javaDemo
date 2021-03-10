package mycom.stream.lambda.analyse;

/**
 * Created by 20013649 on 2020/6/28.
 */
public class StreamTest {
    public static void main(String[] args){
        printString("hello Lambda",s -> System.out.println(s));
    }

    static void printString(String printStr, Print<String> print){
        print.print(printStr);
    }
}
