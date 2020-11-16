package com.sswh.platform.controller;

import com.sswh.entity.PlatformRolesPermissions;
import com.sswh.platform.service.PlatformRolesPermissionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (PlatformRolesPermissions)表控制层
 *
 * @author makejava
 * @since 2020-10-15 23:33:57
 */
@RestController
@RequestMapping("platformRolesPermissions")
public class PlatformRolesPermissionsController {
    /**
     * 服务对象
     */
    @Resource
    private PlatformRolesPermissionsService platformRolesPermissionsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PlatformRolesPermissions selectOne(Integer id) {
        return this.platformRolesPermissionsService.queryById(id);
    }

}