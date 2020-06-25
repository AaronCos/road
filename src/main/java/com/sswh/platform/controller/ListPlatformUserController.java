package com.sswh.platform.controller;

import com.sswh.platform.service.impl.PlatformUserServiceImpl;
import com.sswh.utils.JsonQResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author nuanfeng
 * @date 2020/6/9 5:53
 */
@RestController
@RequestMapping("puser")
public class ListPlatformUserController {


    @Resource
    PlatformUserServiceImpl platformUserService;

    /**
     * 招聘业务层
     */
    @Autowired
    public ListPlatformUserController(PlatformUserServiceImpl platformUserService){
        Assert.notNull(platformUserService, "worker must not be null!");
        this.platformUserService = platformUserService;
    }

    @GetMapping("puser-data")
    public JsonQResult combineData(String username,int page, int limit){
        return platformUserService.combineData(username, page, limit);
    }

}
