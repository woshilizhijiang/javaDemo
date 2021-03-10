package mycom.source;

import org.junit.Test;

import java.util.LinkedHashMap;

public class MapAnalyse {
    @Test
    public void linkedHashMap(){
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>(2);
        linkedHashMap.put("001","用户1信息");
        linkedHashMap.put("002","用户2信息");
        linkedHashMap.get("001");
        linkedHashMap.put("003","用户3信息");
        System.out.println(linkedHashMap.get("001"));
    }
}
