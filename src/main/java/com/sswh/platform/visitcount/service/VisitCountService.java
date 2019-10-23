package com.sswh.platform.visitcount.service;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import com.sswh.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by wangchengcheng on 2019/9/15
 */

@Service("visitCountService")
public class VisitCountService {

    @Autowired
    ShardedJedisPool shardedJedisPool;

    public Integer countVisit(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        ShardedJedis jedis = shardedJedisPool.getResource();
        IpUtil.getIpAddress(request);
        String nowDate = DateUtil.format(new Date(), "yyyy-MM-dd");
        if (!jedis.exists("VC" + nowDate)) {
            jedis.set("VC" + nowDate, "0");
        }
        jedis.incrBy("VC" + nowDate, 1);
        System.out.println("数量" + jedis.get("VC" + nowDate));
        return Convert.toInt(jedis.get("VC"+nowDate));
    }


}
