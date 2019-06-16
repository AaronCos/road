package com.sswh;

import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangchengcheng on 2019/1/12
 */
public class JunitRedisTest {
    public static Jedis jedis = null;

    @BeforeClass
    public static void beforeClass() {
        jedis = new Jedis("localhost");
        System.out.println("Connection to server");
        System.out.println("server is runnning" + jedis.ping());
    }

    @Test
    public void testString() {
        for (int i = 0; i < 100; i++) {
            jedis.set("trtorial-name", "Redis tutorial"+i);
          //  jedis.set("tutor-name", "wangcheng"+i);
            String cache = jedis.get("trtorial-name");
            System.out.println(cache+"缓存中的value");
            //jedis.del("tutor-name");
        }
    }

    /**
     * HashMap
     */
    @Test
    public void testMap(){
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("name","yc");
        map.put("age","22");
        map.put("qq","821658917");
//删除map中的某个键值
        jedis.hdel("user", "age");
        System.out.println(jedis.hmget("user", "age"));//因为删除了，所以返回的是Null
        System.out.println(jedis.hlen("user"));//返回key为user的键中存放的值的个数2
        System.out.println(jedis.exists("user"));//是否存在key为user的记录，返回true
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            System.out.println(key+":" + jedis.hmget("user", key));
        }

        jedis.hmset("user",map);

        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);


    }
}
