package com.sswh.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Aaron
 * @Description: 后台管理界面入口
 * @Date Created in 23:35 2019/12/16
 * @Modeified by:
 */
@Controller
@RequestMapping("manager/center")
public class CenterController {
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

    @RequestMapping("memberedit")
    public String editshow() {
        return "sswh/platform/center/member-edit";
    }

    @RequestMapping("memberpassword")
    public String passwordshow() {
        return "sswh/platform/center/member-password";
    }
}
