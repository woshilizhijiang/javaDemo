package Interview;

public class FinallyTest {
    public static void main(String[] args) {
        FinallyTest finallyTest = new FinallyTest();
        System.out.println(finallyTest.test2());
    }
    //1,2 bb
    public String test(){
        try{
            System.out.println("1");
            return "aa";
        }finally {
            System.out.println("2");
            return "bb";
        }
    }
    //1 2 aa 已经压栈
    public String test2(){
        String a = "";
        try{
            System.out.println("1");
            a = "aa";
            return a;
        }finally {
            System.out.println("2");
            a = "bb";
        }
    }
}
