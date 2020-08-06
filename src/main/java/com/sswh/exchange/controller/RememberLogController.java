package com.sswh.exchange.controller;

import com.sswh.exchange.entity.RememberLog;
import com.sswh.exchange.service.RememberLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RememberLog)表控制层
 *
 * @author makejava
 * @since 2020-08-06 10:42:05
 */
@RestController
@RequestMapping("rememberLog")
public class RememberLogController {
    /**
     * 服务对象
     */
    @Resource
    private RememberLogService rememberLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RememberLog selectOne(Integer id) {
        return this.rememberLogService.queryById(id);
    }

}