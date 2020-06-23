package com.sswh.platform.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.sswh.entity.RecruitEntity;
import com.sswh.platform.service.RecruitService;
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
    RecruitService groupService;


    @RequestMapping("showadd")
    public ModelAndView showAdd() {
        ModelAndView mv = new ModelAndView("sswh/platform/center/group-opr");
        mv.addObject("url", "add.do");
        mv.addObject("groupUrl","group");
        return mv;
    }

    @RequestMapping("showedit")
    public ModelAndView showEdit(int iid) {
        ModelAndView mv = new ModelAndView("sswh/platform/center/group-opr");
        RecruitEntity group = groupService.findByIid(iid);
        JSONObject groupJsonObject = (JSONObject) JSONObject.toJSON(group);
        groupJsonObject.put("createTime", DateUtil.format(groupJsonObject.getDate("createTime"),"yyyy-MM-dd"));
        groupJsonObject.put("endTime",DateUtil.format(groupJsonObject.getDate("endTime"),"yyyy-MM-dd"));
        mv.addObject("group", groupJsonObject);
        mv.addObject("groupUrl","group-edit");
        mv.addObject("url", "edit.do");
        return mv;
    }

    @RequestMapping("add")
    @ResponseBody
    public String addRecruit(RecruitEntity groupEntity) {
        int i = groupService.addRecruit(groupEntity);
        return "success";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String deleteRecruit(String ids) {
        groupService.deleteRecruit(ids);
        return "success";
    }

    @RequestMapping("edit")
    @ResponseBody
    public String editRecruit(RecruitEntity groupEntity) {
        groupService.updateRecruit(groupEntity);
        return "success";
    }

    @RequestMapping("changepageshow")
    @ResponseBody
    public String changepageshow(String iid, String pageshow) {
        return StrUtil.toString(groupService.changepageshow(iid, pageshow));
    }



}
