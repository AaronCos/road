package com.sswh.util.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.ehcache.Cache;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * redis缓存工具类，
 * 目的：便于存放对象到redis缓存中
 * 前提：注册bean ShardedJedisPool
 * 模式：单例模式
 *
 * @author Aaron
 */
public class RedisCacheUtil implements CacheManual {

    private static RedisCacheUtil redisCacheUtil;

    static ShardedJedisPool shardedJedisPool;

    static {
        shardedJedisPool = shardedJedisPool(jedisPoolConfig(), jedisShardInfos());
    }

    public static ShardedJedisPool shardedJedisPool(JedisPoolConfig jedisPoolConfig, List<JedisShardInfo> jedisShardInfos) {
        return new ShardedJedisPool(jedisPoolConfig, jedisShardInfos);
    }

    public static JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(20);
        jedisPoolConfig.setMaxWaitMillis(5000);
        jedisPoolConfig.setTestOnBorrow(true);
        return jedisPoolConfig;
    }

    public static  List<JedisShardInfo> jedisShardInfos() {
        List<JedisShardInfo> jedisShardInfos = new ArrayList<>();
        jedisShardInfos.add(new JedisShardInfo("127.0.0.1", 6379, "127.0.0.1"));
        return jedisShardInfos;
    }

    private RedisCacheUtil() {

    }

    public static RedisCacheUtil getInstance() {
        if (redisCacheUtil == null) {
            redisCacheUtil = new RedisCacheUtil();
        }
        return redisCacheUtil;
    }

    public ShardedJedis getJedisResource() {
        try (ShardedJedis resource = shardedJedisPool.getResource()) {
            return resource;
        }
    }

    /**
     * 存放对象
     *
     * @param key 键
     * @param obj 存放对象可以是json对象
     * @return true存放成功
     */
    public static boolean putObject(String key, Object obj) {
        ShardedJedis jedisResource = getInstance().getJedisResource();
        byte[] bytes1 = key.getBytes();
        byte[] bytes = JSONObject.toJSONBytes(obj);
        String set = jedisResource.set(bytes1, bytes);
        return "OK".equals(set);
    }


    /**
     * 获取各种类型的数据
     *
     * @param key 键
     * @param typeReference 返回值类型
     * @param <T> 返回值类型
     * @return 对象
     */
    public static <T> T getObject(String key, TypeReference<T> typeReference) throws IOException {
        ShardedJedis jedisResource = getInstance().getJedisResource();
        String result = jedisResource.get(key);
        return JSON.parseObject(result, typeReference);
    }

}
