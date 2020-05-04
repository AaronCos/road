package com.sswh.noraml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.*;

import java.util.List;

/**
 * 专门用于测试ShardJedis和使用jedis的api
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件
public class RedisTest {


    @Autowired
    ShardedJedisPool shardedJedisPool;

    @Test
    public void testConnection(){
        try (ShardedJedis jedis = shardedJedisPool.getResource()) {//使用try-with-resource可以自动关闭jedis
            jedis.set("wife", "zhangqingqing");
            jedis.set("husband", "wangchengcheng");
            //assertEquals(jedis.get("wife"), "zhangqingqin");
            Client wife = jedis.getShard("wife").getClient();
            System.out.println("port"+wife.getPort()+";host:"+wife.getHost());
            ShardedJedisPipeline pipelined = jedis.pipelined();
            jedis.set("son","girl","nx","ex",12);
            Jedis son = jedis.getShard("son");
            System.out.println(son.get("son"));
            jedis.lpop("list");

            List<String> list = jedis.lrange("list", 0, 11);
            for (String one: list) {
                System.out.println("value:"+one);
            }


        }


    }



}
