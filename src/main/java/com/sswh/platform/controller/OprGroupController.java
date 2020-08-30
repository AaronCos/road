package com.sswh.platform.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.sswh.entity.PlatformGroup;
import com.sswh.enumpackage.ResultState;
import com.sswh.platform.service.GroupService;
import com.sswh.utils.JsonQResult;
import com.sswh.utils.core.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nuanfeng
 * @date 2020/5/5 16:17
 */
@Controller
@RequestMapping("group")
public class OprGroupController {

    @Autowired
    GroupService groupService;


    @RequestMapping("showadd")
    public ModelAndView showAdd() {
        ModelAndView mv = new ModelAndView("sswh/platform/center/group-opr");
        mv.addObject("url", "add.do");
        mv.addObject("groupUrl", "group");
        return mv;
    }

    @RequestMapping("showedit")
    public ModelAndView showEdit(int iid) {
        ModelAndView mv = new ModelAndView("sswh/platform/center/group-opr");
        PlatformGroup group = groupService.queryById(iid);
        JSONObject groupJsonObject = (JSONObject) JSONObject.toJSON(group);
        groupJsonObject.put("createTime", DateUtil.format(groupJsonObject.getDate("createTime"), "yyyy-MM-dd"));
        groupJsonObject.put("endTime", DateUtil.format(groupJsonObject.getDate("endTime"), "yyyy-MM-dd"));
        mv.addObject("group", groupJsonObject);
        mv.addObject("groupUrl", "group-edit");
        mv.addObject("url", "edit.do");
        return mv;
    }

    @RequestMapping("add")
    @ResponseBody
    public JsonQResult addRecruit(PlatformGroup groupEntity) {
        JsonQResult instance = JsonQResult.getInstance();
        ResultState message = ResultState.ERROR;
        PlatformGroup insert = groupService.insert(groupEntity);
        if (insert != null) {
            message = ResultState.SUCCESS;
        }
        instance.setMsg(StrUtil.toString(message.getStateCode()));
        return instance;
    }

    @RequestMapping("delete")
    @ResponseBody
    public JsonQResult deleteRecruit(String ids) {
        JsonQResult instance = JsonQResult.getInstance();
        ResultState state = ResultState.ERROR;
        boolean b = groupService.deleteByIds(ids);
        if (b) {
            state = ResultState.SUCCESS;
        }
        instance.setMsg(StrUtil.toString(state.getStateCode()));
        return instance;
    }

    @RequestMapping("edit")
    @ResponseBody
    public JsonQResult editRecruit(PlatformGroup groupEntity) {
        JsonQResult instance = JsonQResult.getInstance();
        ResultState state = ResultState.ERROR;
        PlatformGroup newGroup = groupService.update(groupEntity);
        if (newGroup != null) {
            state = ResultState.SUCCESS;
        }
        instance.setMsg(StrUtil.toString(state.getStateCode()));
        instance.setData(newGroup);
        return instance;
    }

}
