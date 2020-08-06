package com.sswh.platform.controller;

import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;
import com.sswh.entity.RecruitEntity;
import com.sswh.platform.service.RecruitService;
import com.sswh.utils.JsonQResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台招聘信息后台维护列表控制器
 * @author Aaron
 * @date 2020/3/6 22:49
 */

@RestController
@RequestMapping("recruit")
public class ListRecruitController {

    /**
     * 招聘业务层
     */
    @Autowired
    private RecruitService recruitService;

    @GetMapping("recruit-data")
    public JsonQResult combineData(String title,String endTime,String createTime,int page,int limit){
        JsonQResult jsonQResult = JsonQResult.getInstance();
        List<RecruitEntity> allRecruit;
        if (StrUtil.isEmpty(title)) {
            allRecruit = recruitService.findAllRecruit();
        } else {
            allRecruit = recruitService.findByTitle(title);
        }
        jsonQResult.setCode(0);
        jsonQResult.setCount(allRecruit==null?0:allRecruit.size());
        jsonQResult.setMsg("返回成功");
        jsonQResult.setData(recruitResult(page, limit, allRecruit)==null ? null:recruitResult(page, limit, allRecruit));
        return jsonQResult;
    }

    private List<RecruitEntity> recruitResult(int page, int limit, List<RecruitEntity> allRecruit) {
        int total = 0;
        if (!allRecruit.isEmpty()) {
            total = allRecruit.size();
        }else{
            return null;
        }
        int totalPage = PageUtil.totalPage(total, limit);
        if ((page == totalPage)) {
            allRecruit = allRecruit.subList((page-1)*limit,total);
        }else{
            allRecruit = allRecruit.subList((page-1)*limit,(page*limit));
        }
        return allRecruit;
    }

}
