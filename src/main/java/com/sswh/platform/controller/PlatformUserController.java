package com.sswh.platform.controller;

import com.sswh.platform.dao.PlatformUserDao;
import com.sswh.platform.entity.PlatformUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangchengcheng on 2019/2/22
 */
@Controller
public class PlatformUserController {
    @Autowired
    PlatformUserDao dao;

    @RequestMapping("haha")
    public void test() {
        PlatformUserEntity puser = new PlatformUserEntity("wang", "qwer");
        puser.setMobilePhone("1373220933");
        puser.setIdCard("3209211992");
        dao.registUser(puser);
    }

}
