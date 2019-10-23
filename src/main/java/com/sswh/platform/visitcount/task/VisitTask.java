package com.sswh.platform.visitcount.task;

import cn.hutool.core.util.StrUtil;
import com.sswh.platform.visitcount.entity.VisitEveryDayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Date;

/**
 * Created by wangchengcheng on 2019/9/15
 */
@Component
public class VisitTask {


    @Autowired
    ShardedJedisPool shardedJedisPool;


    public void permanentVisitData(){
        System.out.println("进入定时任务----");

     /*   ShardedJedis jedis = shardedJedisPool.getResource();

        String nowDate = DateUtil.format(new Date(), "yyyy-MM-dd");
        if (!jedis.exists("VC" + nowDate)) {
           //什么都不做
        }*/
        VisitEveryDayEntity ve = new VisitEveryDayEntity();
        ve.setUuid(StrUtil.uuid());
        ve.setVisitNumber(123);
        ve.setDate(new Date());
        System.out.println(ve);
    }
}
