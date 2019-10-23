package com.sswh.platform.visitcount.controller;

import cn.hutool.extra.servlet.ServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangchengcheng on 2019/9/15
 */
@Controller
public class VisitCountController {
    @Autowired
    ShardedJedisPool shardedJedisPool;

    @RequestMapping("helloRedis")
    public void hello(HttpServletRequest request){

        String clientIP = ServletUtil.getClientIP(request);
        System.out.println(clientIP);

        if (shardedJedisPool!=null) {
            ShardedJedis jedis = shardedJedisPool.getResource();
            System.out.println(jedis.get("pv"));
            System.out.println("gggggggggg");
        }

    }
}
