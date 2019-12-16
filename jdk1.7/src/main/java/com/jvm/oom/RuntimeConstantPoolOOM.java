package com.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM  Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author lizj11
 *
 * VM 8 Args: -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }

    }
}
