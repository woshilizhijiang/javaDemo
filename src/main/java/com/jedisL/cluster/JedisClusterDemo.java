package com.jedisL.cluster;

import redis.clients.jedis.*;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class JedisClusterDemo {
    private static JedisPool jedisPool;
    private static JedisPoolConfig poolConfig = new JedisPoolConfig();

    /**
     * 问题：
     * 动态获取配置如何解决
     */
    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(10);
        poolConfig.setMaxTotal(20);
        poolConfig.setMaxWaitMillis(10000);
        poolConfig.setTestOnBorrow(false);
    }

    public static void redisSingleOne(){
        jedisPool = new JedisPool(poolConfig,"",28001);
        Jedis jedis = jedisPool.getResource();
        String key = "configapp:QUOTAINFORULE_CYCLE";
        String value = jedis.get(key);
        System.out.println(value);
    }
    public static void redisCluster(){

        Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
        nodes.add(new HostAndPort("10.218.34.15", 28001));
        nodes.add(new HostAndPort("10.218.34.15", 28002));
        nodes.add(new HostAndPort("10.218.34.15", 28003));
        nodes.add(new HostAndPort("10.218.34.15", 28004));
        nodes.add(new HostAndPort("10.218.34.15", 28005));
        nodes.add(new HostAndPort("10.218.34.15", 28006));

        JedisCluster cluster = new JedisCluster(nodes,poolConfig);
        Map<String,JedisPool> clusterNodes = cluster.getClusterNodes();
        String keyM = "AOP_DEV_INDEX_USERINFO:UID*";
        TreeSet<String> keys = new TreeSet<String>();
        /**
         * 这部分代码有问题
         */
        for (String k:clusterNodes.keySet()) {
            JedisPool jp = clusterNodes.get(k);
            Jedis connection = jp.getResource();
            try {
                keys.addAll(connection.keys(keyM));
            }finally {
                connection.close();
            }
        }

        for(String key:keys){
            cluster.del(key);
        }
        System.out.println("删除成功");

    }




}
