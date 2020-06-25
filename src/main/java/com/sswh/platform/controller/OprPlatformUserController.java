package com.sswh.platform.controller;

import com.sswh.entity.PlatformUser;
import com.sswh.platform.service.impl.PlatformUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO: 后台用户管理
 *
 * @author nuanfeng
 * @date 2020/3/6 22:51
 */
@Controller
@RequestMapping("puser")
public class OprPlatformUserController {

    @Autowired
    PlatformUserServiceImpl puserService;


    @RequestMapping("showadd")
    public ModelAndView showAdd() {
        ModelAndView mv = new ModelAndView("sswh/platform/center/puser-opr");
        mv.addObject("url", "add.do");
        mv.addObject("puserurl","puser");
        return mv;
    }

    @RequestMapping("showedit")
    public ModelAndView showEdit(int iid) {
        ModelAndView mv = new ModelAndView("sswh/platform/center/puser-opr");
        PlatformUser puser = puserService.findByIid(iid);
        mv.addObject("puserurl","puser-edit");
        mv.addObject("url", "edit.do");
        return mv;
    }

    @RequestMapping("add")
    @ResponseBody
    public String addPlatformUser(PlatformUser puserEntity) {
        int i = puserService.addByEntity(puserEntity);
        return "success";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String deleteByIds(String ids) {
        puserService.deleteByIds(ids);
        return "success";
    }

    @RequestMapping("edit")
    @ResponseBody
    public String editByPlatformUser (PlatformUser puserEntity) {
        puserService.updateByEntity(puserEntity);
        return "success";
    }



}
