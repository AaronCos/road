package com.sswh.platform.service.impl;

import com.sswh.dao.PlatformUserDao;
import com.sswh.entity.PlatformUser;
import com.sswh.platform.service.LoginOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nuanfeng on 2019/3/10
 */
@Service
public class LoginOutServiceImpl implements LoginOutService {

    @Resource
    PlatformUserDao userDao;

    /**
     * jedis连接池
     */
    @Autowired
    ShardedJedisPool shardedJedisPool;

    public void initCacheUser(){
        int no = 1;
        int limit = 1000;
        List<PlatformUser> list = userDao.queryAllByLimit(no - 1, limit);
        List<PlatformUser> platformUsers = new ArrayList<>();
        while (list != null && list.size() > 0) {
            platformUsers.addAll(list);
            no++;
            list  = userDao.queryAllByLimit(no-1,limit);
        }
        try (ShardedJedis jedis = shardedJedisPool.getResource()) {
            jedis.lpush("","allUser");

        }

    }

    @Override
    public List<PlatformUser> findAllUser(){

        userDao.queryAllByLimit(0,1000);
        List<PlatformUser> allPlatformUser = userDao.findAllPlatformUser();
        return null;
    }

    @Override
    public PlatformUser findByUserName(String userName) {
        PlatformUser byUserName = userDao.findByUsername(userName);
        return byUserName;
    }
}
