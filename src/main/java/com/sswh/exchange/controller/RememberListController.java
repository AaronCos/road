package com.sswh.exchange.controller;

import com.sswh.exchange.entity.RememberList;
import com.sswh.exchange.service.RememberListService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RememberList)表控制层
 *
 * @author makejava
 * @since 2020-08-05 19:18:52
 */
@RestController
@RequestMapping("rememberList")
public class RememberListController {
    /**
     * 服务对象
     */
    @Resource
    private RememberListService rememberListService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RememberList selectOne(Integer id) {
        return this.rememberListService.queryById(id);
    }

}