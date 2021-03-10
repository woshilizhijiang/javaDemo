package net;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.SubnetUtils;

public class NetDemo {
    public static void main(String[] args) {
        SubnetUtils subnetUtils = new SubnetUtils(StringUtils.trim("10.237.29.137"), StringUtils.trim("255.255.255.255"));
        System.out.println(subnetUtils.getInfo().getLowAddress());

        String highIp = subnetUtils.getInfo().getHighAddress();
        int highIpInt = subnetUtils.getInfo().asInteger(highIp);
        int endIpInt = highIpInt - 1;
        System.out.println(format(toArray(endIpInt)));
    }

    private static String format(int[] octets) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < octets.length; ++i) {
            str.append(octets[i]);
            if (i != octets.length - 1) {
                str.append(".");
            }
        }
        return str.toString();
    }

    private static int[] toArray(int val) {
        int[] ret = new int[4];
        for (int j = 3; j >= 0; --j) {
            ret[j] |= ((val >>> 8 * (3 - j)) & (0xff));
        }
        return ret;
    }
}
