package com.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args  -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 * @author lizhijiang
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
