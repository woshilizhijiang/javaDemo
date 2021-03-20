package com.jedisL.singleClient;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class JedisSingle {

    public static void main(String[] args){
        jedisDemo();
    }

    public static void jedisSingle(){
        Jedis Jedis = new Jedis("10.47.188.57",6379);
        Set<String> keys = Jedis.keys("userid:19*");
        System.out.println(keys);
    }

    public static void jedisDemo(){
        Jedis jedis = new Jedis("10.47.188.57",6379);
        jedis.multi();
        jedis.set("test","test");
        jedis.get("test");
        jedis.set("test1","test1");
        jedis.get("test1");
        jedis.watch("test");
        jedis.multi().exec();
    }

}
