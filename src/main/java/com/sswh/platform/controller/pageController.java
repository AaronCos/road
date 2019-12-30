package com.sswh.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面的转发
 * Created by wangchengcheng on 2019/2/19
 */
@Controller
@RequestMapping("layui")
public class pageController {
    /*@RequestMapping("{requrl}")
    public String layui_test(@PathVariable("requrl") String name) {
        return "sswh/platform/" + name;
    }*/

   @RequestMapping("hello")
    public String test(){
       return "sswh/platform/center/index";
    }

    @RequestMapping("hello1")
    public String testmember(){
        return "sswh/platform/center/member-list1";
    }
    @RequestMapping("hello/{requrl}")
    public ModelAndView tesRe(@PathVariable("requrl") String name) {
        System.out.println("hello world");
        return new ModelAndView("sswh/platform/" + name + "");
    }

    ;
    @RequestMapping("bad")
    public String page(){
        return "sswh/platform/layui_test";

    }

    @RequestMapping("good")
    public String redirectPage(){
        return "redirect:bad.do";
    }

}
