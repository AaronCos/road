package com.sswh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/8/31 21:51
 */

@Configuration
public class RedisPoolConfig {

    @Bean
    public ShardedJedisPool shardedJedisPool(JedisPoolConfig jedisPoolConfig, List<JedisShardInfo> jedisShardInfos){
        return new ShardedJedisPool(jedisPoolConfig, jedisShardInfos);
    }
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(20);
        jedisPoolConfig.setMaxWaitMillis(5000);
        jedisPoolConfig.setTestOnBorrow(true);
        return jedisPoolConfig;
    }
    @Bean
    public List<JedisShardInfo> jedisShardInfoDefault(){
        List<JedisShardInfo> jedisShardInfos = new ArrayList<>();
        jedisShardInfos.add(new JedisShardInfo("127.0.0.1",6379,"127.0.0.1"));
        return jedisShardInfos;
    }
}

@Component
class TestRedis{

    @Autowired
    ShardedJedisPool shardedJedisPool;

   // @PostConstruct
    public void testRedis(){
        try (ShardedJedis jedis = shardedJedisPool.getResource()) {//使用try-with-resource可以自动关闭jedis
            jedis.set("gggg", "qwert");
            jedis.set("kkkk", "yuiop");
            //assertEquals(jedis.get("wife"), "zhangqingqin");
            Client wife = jedis.getShard("wife").getClient();
            System.out.println("port"+wife.getPort()+";host:"+wife.getHost());
            ShardedJedisPipeline pipelined = jedis.pipelined();
            jedis.set("son","girl");
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
