package com.jacksonFormat;


import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws Exception {
        String json = "{\"result\":{\"Name\":\"lyx\",\"Confidence\":\"0.9514213216304779\",\"Faceid\":\"12212\",\"Position\":\"广州\",\"Company\":\"lyx\",\"Department\":\"as\"},\"respcode\":\"0\",\"respdesc\":\"成功\",\"resptype\":\"0\"}";

//        Map<String,String> map = new HashMap<>();
//        map.put("aa","1");
//        map.put("vv","cad");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> tmpMap=mapper.readValue(json, Map.class);



        System.out.println(mapper.writeValueAsString(tmpMap));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tmpMap));

    }

    public String jsonFormat(String rest){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> tmpMap = null;
        String rst = null;
        try {
            tmpMap = mapper.readValue(rest, Map.class);
            rst = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tmpMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rst;
    }
}
