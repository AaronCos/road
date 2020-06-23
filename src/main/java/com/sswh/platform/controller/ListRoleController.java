package com.sswh.platform.controller;

import com.sswh.platform.service.impl.RoleServiceImpl;
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
@RequestMapping("role")
public class ListRoleController {


    @Resource
    RoleServiceImpl roleService;

    /**
     * 招聘业务层
     */
    @Autowired
    public ListRoleController(RoleServiceImpl roleService){
        Assert.notNull(roleService, "worker must not be null!");
        this.roleService = roleService;
    }

    @GetMapping("role-data")
    public JsonQResult combineData(String rolename,int page, int limit){
        return roleService.combineData(rolename, page, limit);
    }

}
