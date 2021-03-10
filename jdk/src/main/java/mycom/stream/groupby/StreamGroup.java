package mycom.stream.groupby;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamGroup {
    public static void main(String[] args) {
        List<NetworkLimitParams> instanceCodeSelect = new ArrayList<>();
        NetworkLimitParams n1 = new NetworkLimitParams();
        n1.setServerInstanceCode("n1");
        n1.setServerIp("10.1.1.1");
        NetworkLimitParams n2 = new NetworkLimitParams();
        n2.setServerInstanceCode("ssh");
        n2.setServerIp("10.1.1.3");
        NetworkLimitParams n3 = new NetworkLimitParams();
        n3.setServerInstanceCode("ssh");
        n3.setServerIp("10.1.1.4");
        NetworkLimitParams n4 = new NetworkLimitParams();
        n4.setServerInstanceCode("ssh");
        n4.setServerIp("10.1.1.5");
        instanceCodeSelect.add(n1);
        instanceCodeSelect.add(n2);
        instanceCodeSelect.add(n3);
        instanceCodeSelect.add(n4);

        List<NetworkLimitParams> resultParams = new ArrayList<>();
        instanceCodeSelect.stream().collect(Collectors.groupingBy(NetworkLimitParams::getServerInstanceCode)).forEach((s, networkLimitParams) -> {
            NetworkLimitParams tmpParam = new NetworkLimitParams();
            tmpParam.setServerInstanceCode(s);
            StringBuilder ips = new StringBuilder();
            networkLimitParams.stream().forEach(nt1 -> {
                ips.append(nt1.getServerIp()).append(",");
            });
            tmpParam.setServerInstanceIp(ips.toString().substring(0,ips.toString().length()-1));
            resultParams.add(tmpParam);
        });
        resultParams.stream().forEach(tt -> {
            System.out.println(tt.getServerInstanceCode() + ":" + tt.getServerInstanceIp());
        });

    }

    @Test
    public void test(){
//        int total = 56;
//        int batchNum = 100;
//        System.out.println(total/batchNum);
    }

    @Test
    public void splitStr(){
//        String stdout = "10.243.4.0/24 8769 10000Kbit\n10.243.4.0/24 8121 1024Mbit\n10.243.4.0/24 8877 1000Kbit\n10.243.4.0/24 8827 1000000bit";
        String stdout = "10.243.4.0/24 8769 10000Kbit";
//        if (stdout.contains("\n")){
//            String[] sts = stdout.split("\n");
//            for (int i = 0; i < sts.length; i++) {
//                String[] stspace = sts[i].split(" ");
//                String oldUnitSize = stspace[stspace.length - 1];
//                if (oldUnitSize.endsWith("Kbit")){
//                    String sub = oldUnitSize.substring(0,oldUnitSize.indexOf("Kbit"));
//                    String subMbit = Integer.valueOf(sub)/1000 + "Mbit";
//                    stdout = stdout.replace(oldUnitSize,subMbit);
//                }
//
//                if (!oldUnitSize.endsWith("Mbit") && !oldUnitSize.endsWith("Kbit") && oldUnitSize.endsWith("bit")){
//                    String sub = oldUnitSize.substring(0,oldUnitSize.indexOf("bit"));
//                    String subMbit = Integer.valueOf(sub)/1000/1000 + "Mbit";
//                    stdout = stdout.replace(oldUnitSize,subMbit);
//                }
//            }
//        }
        stdout = changeUnit(stdout);

        System.out.println(stdout);
    }

    public String changeUnit(String stdout) {
//        if (stdout.contains("\n")){
            String[] sts = stdout.split("\n");
            for (int i = 0; i < sts.length; i++) {
                String[] stspace = sts[i].split(" ");
                String oldUnitSize = stspace[stspace.length - 1];
                if (oldUnitSize.endsWith("Kbit")){
                    String sub = oldUnitSize.substring(0,oldUnitSize.indexOf("Kbit"));
                    String subMbit = Integer.valueOf(sub)/1000 + "Mbit";
                    stdout = stdout.replace(oldUnitSize,subMbit);
                }

                if (!oldUnitSize.endsWith("Mbit") && !oldUnitSize.endsWith("Kbit") && oldUnitSize.endsWith("bit")){
                    String sub = oldUnitSize.substring(0,oldUnitSize.indexOf("bit"));
                    String subMbit = Integer.valueOf(sub)/1000/1000 + "Mbit";
                    stdout = stdout.replace(oldUnitSize,subMbit);
                }
            }
//        }
        return stdout;
    }
}
