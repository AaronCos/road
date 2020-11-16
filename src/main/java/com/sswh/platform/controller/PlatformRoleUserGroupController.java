package com.sswh.platform.controller;

import com.sswh.entity.PlatformRoleUserGroup;
import com.sswh.platform.service.PlatformRoleUserGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (PlatformRoleUserGroup)表控制层
 *
 * @author makejava
 * @since 2020-10-15 13:41:11
 */
@RestController
@RequestMapping("platformRoleUserGroup")
public class PlatformRoleUserGroupController {
    /**
     * 服务对象
     */
    @Resource
    private PlatformRoleUserGroupService platformRoleUserGroupService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PlatformRoleUserGroup selectOne() {
        return this.platformRoleUserGroupService.queryById();
    }

}