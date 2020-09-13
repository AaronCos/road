package com.sswh.userpivot.controller;

import com.sswh.userpivot.entity.WeuiUser;
import com.sswh.userpivot.service.WeuiUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (WeuiUser)微信控制层
 *
 * @author makejava
 * @since 2020-08-17
 */
@RestController
@RequestMapping("weuiUser")
public class WeuiUserController {
    /**
     * 服务对象
     */
    @Resource
    private WeuiUserService weuiUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WeuiUser selectOne(Integer id) {
        return this.weuiUserService.queryById(id);
    }

}