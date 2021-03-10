package mycom.net;

import org.junit.Test;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWorkDemo {
    @Test
    public void test2() {
        System.out.println(System.getenv("user.dir"));
        System.out.println(System.getProperty("user.home"));
        System.out.println( System.getProperty("os.name").toLowerCase());
        System.getenv().forEach((k,v)->{
            System.out.println(k + ":" + v);
        });
    }

    @Test
    public void test1() {
//        String demoimg = "static/one_3.txt";
//        ClassPathResource tempResource = new ClassPathResource(demoimg);
//        try {
//            String path = tempResource.getURI().getPath();
//            System.out.println(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println( addr.getAddress() +"IP地址：" + addr.getHostAddress() + "，主机名：" + addr.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
