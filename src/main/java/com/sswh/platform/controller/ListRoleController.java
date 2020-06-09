package com.sswh.platform.controller;

import cn.hutool.core.util.StrUtil;
import com.sswh.entity.PlatformRoles;
import com.sswh.platform.service.RoleService;
import com.sswh.utils.JsonQResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/6/9 5:53
 */
@RestController
@RequestMapping("role")
public class ListRoleController {

    RoleService roleService;

    /**
     * 招聘业务层
     */
    @Autowired
    public ListRoleController(RoleService roleService){
        Assert.notNull(roleService, "worker must not be null!");
        this.roleService = roleService;
    }

    @GetMapping("role-data")
    public JsonQResult combineData(String rolename,int page, int limit){
        JsonQResult jsonQResult = new JsonQResult();
        List<PlatformRoles> allRoles;
        if (StrUtil.isEmpty(rolename)) {
            allRoles = roleService.findAllRoles();
        } else {
            allRoles = roleService.findByName(rolename);
        }
        jsonQResult.setCode(0);
        jsonQResult.setCount(allRoles==null?0:allRoles.size());
        jsonQResult.setMsg("返回成功");
        jsonQResult.setData(roleService.currentPageResult(page, limit, allRoles)==null ? null:roleService.currentPageResult(page, limit, allRoles));
        return jsonQResult;
    }

}
