package com.sswh.platform.controller;

import cn.hutool.core.util.StrUtil;
import com.sswh.entity.PlatformGroup;
import com.sswh.platform.service.GroupService;
import com.sswh.utils.JsonQResult;
import com.sswh.utils.PageQUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PlatformGroup)表控制层
 *
 * @author makejava
 * @since 2020-06-14 13:51:41
 */
@RestController
@RequestMapping("group")
public class ListGroupController {
    /**
     * 服务对象
     */
    @Resource
    private GroupService groupService;

    @GetMapping("group-data")
    public JsonQResult combineData(String title, String endTime, String createTime, int page, int limit){
        JsonQResult jsonQResult = JsonQResult.getInstance();
        PlatformGroup platformGroup = new PlatformGroup();
        List<PlatformGroup> allGroups;
        if (StrUtil.isEmpty(title)) {
            allGroups = groupService.queryAllByLimit(0,100000);
        } else {
            allGroups = groupService.queryAll(platformGroup);
        }

        int total = allGroups.size();
        PageQUtil<PlatformGroup> groupPageQUtil = new PageQUtil<>();
        return groupPageQUtil.setPageData(allGroups,page,limit);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PlatformGroup selectOne(Integer id) {
        return this.groupService.queryById(id);
    }

}