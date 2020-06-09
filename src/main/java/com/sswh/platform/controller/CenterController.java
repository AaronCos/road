package com.sswh.platform.controller;

import com.sswh.front.entity.FrontUserEntity;
import com.sswh.platform.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Aaron
 * @Description: 后台管理界面入口
 * @Date Created in 23:35 2019/12/16
 * @Modeified by:
 */
@Controller
@RequestMapping("manager/center")
public class CenterController {

    @Autowired
    MemberService memberService;

    @RequestMapping("index")
    public String centershow() {
        return "sswh/platform/center/index";
    }

    @RequestMapping("welcome1")
    public String welcome1show() {
        return "sswh/platform/center/welcome1";
    }

    @RequestMapping("welcome")
    public String welcomeshow() {
        return "sswh/platform/center/welcome";
    }

    /**
     * 会员管理
     *
     * @return
     */
    @RequestMapping("memberlist")
    public String membershow() {
        return "sswh/platform/center/member-list";
    }

    /**
     * 会员列表（动态列表）
     *
     * @return
     */
    @RequestMapping("memberlist1")
    public String memebershow() {
        return "sswh/platform/center/member-list1";
    }

    @RequestMapping("memberadd")
    public String addshow() {
        return "sswh/platform/center/member-add";
    }



    @RequestMapping("memberpassword")
    public String passwordshow() {
        return "sswh/platform/center/member-password";
    }

    @RequestMapping(value="/memberedit")
    public ModelAndView editshow(String iid) {

        ModelAndView modelAndView = new ModelAndView("sswh/platform/center/member-add");
        FrontUserEntity frontuser = memberService.findFrontUserByIid(iid);
        modelAndView.addObject("frontuser",frontuser);
        return modelAndView;
    }

    /**
     * 招聘列表页面
     * @return
     */
    @RequestMapping("recruitlist")
    public ModelAndView showRecruitPage(){
        ModelAndView mv = new ModelAndView("sswh/platform/center/recruit-list");
        mv.addObject("cite","招聘信息");
        return mv;
    }


    /**
     * 管理员管理-角色管理列表
     * @return
     */
    @RequestMapping("rolelist")
    public ModelAndView showRolePage(){
        ModelAndView mv = new ModelAndView("sswh/platform/center/role-list");
        mv.addObject("cite","角色管理");
        return mv;
    }
}
