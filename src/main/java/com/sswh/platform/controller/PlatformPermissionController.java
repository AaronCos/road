package com.sswh.platform.controller;

import com.sswh.entity.PlatformPermission;
import com.sswh.platform.service.PlatformPermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (PlatformPermission)表控制层
 *
 * @author AaronCos
 * @since 2020-10-16 00:08:27
 */
@RestController
@RequestMapping("platformPermission")
public class PlatformPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private PlatformPermissionService platformPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PlatformPermission selectOne(Integer id) {
        return this.platformPermissionService.queryById(id);
    }

}