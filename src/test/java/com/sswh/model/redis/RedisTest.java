package com.sswh.model.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * JedisApi
 * @author nuanfeng
 * @date 2020/9/1 23:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件
public class RedisTest {


    @Autowired
    ShardedJedisPool shardedJedisPool;

    @Test
    public void testPush(){
        try (ShardedJedis resource = shardedJedisPool.getResource()) {
            //resource.lpush("hello","world");
            resource.set("hello","world");
            System.out.println(resource.get("hello"));
            for (int i = 0; i < 100; i++) {
                resource.lindex("circle",i);
            }


        }

    }


}
