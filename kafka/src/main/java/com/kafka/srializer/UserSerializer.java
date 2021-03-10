package com.kafka.srializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;


import java.util.Map;


public class UserSerializer implements Serializer {
    private ObjectMapper objectMapper;

    @Override
    public void configure(Map configs, boolean isKey) {
        objectMapper = new ObjectMapper();
    }

    @Override
    public byte[] serialize(String topic, Object data) {
        byte[] ret = null;
        try {
            ret = objectMapper.writeValueAsString(data).getBytes("utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public void close() {

    }
}
