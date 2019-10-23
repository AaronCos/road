package com.sswh.platform.usercenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangchengcheng on 2019/9/13
 */
@Controller
@RequestMapping("userinfo")
public class UserInfoController {

    @RequestMapping(value={"addshow"})
    public ModelAndView showAdd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sswh/platform/usercenter/userinfo");
        return mv;
    }
}
