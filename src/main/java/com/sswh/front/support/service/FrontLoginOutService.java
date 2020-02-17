package com.sswh.front.support.service;

import com.sswh.front.dao.IFrontUserDao;
import com.sswh.front.entity.FrontUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Aaron
 * @date 2020/2/16 22:30
 */
@Service
public class FrontLoginOutService {
    @Autowired
    IFrontUserDao frontUserDao;

    public FrontUserEntity findByLoginname(String loginname){
        FrontUserEntity frontUserEntity= null;
        try {
            frontUserEntity = frontUserDao.findByLoginName(loginname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frontUserEntity;
    }

    public int findCountByLoginname(String loginname){
       return frontUserDao.findCountByLoginname(loginname);
    }
    public int registUser(FrontUserEntity user){
        return frontUserDao.registUser(user);
    }


}
