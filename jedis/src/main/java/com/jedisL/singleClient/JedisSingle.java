package com.jedisL.singleClient;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class JedisSingle {

    public static void main(String[] args){
        jedisSingle();
    }

    public static void jedisSingle(){
        Jedis Jedis = new Jedis("10.218.34.15",28001);
        Set<String> keys = Jedis.keys("userid:19*");
        System.out.println(keys);
    }

}
