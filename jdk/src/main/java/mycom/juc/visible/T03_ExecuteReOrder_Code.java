package mycom.juc.visible;

public class T03_ExecuteReOrder_Code {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getId());
        int i = 0;
        for (;;) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread t1 = new Thread(() -> {
                a = 1;
                x = a;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = b;
            });
            System.out.println("t1 " + t1.getId());
            System.out.println("t2 " + t2.getId());
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            String result = "第" + i + "次执行，x=" + x + "y=" + y;
            if (x==0 && y==0){
                System.out.println(result);
                break;
            }
        }
    }
}
