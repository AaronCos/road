package com.sswh.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangchengcheng on 2019/2/19
 */
@Controller
@RequestMapping("layui")
public class controller {
    @RequestMapping("{requrl}")
    public String layui_test(@PathVariable("requrl") String name){
       return "sswh/platform/"+name;
    }
}
