package com.sswh.platform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sswh.platform.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WangChengCheng
 * @Description: 会员管理
 * @Date Created in 23:30 2019/12/16
 * @Modeified by:
 */
@RestController
@RequestMapping("manager/data")
public class ListMemberController {

    @Autowired
    public MemberService memberService;


    /**
     * 获取用户数据
     * @return
     */
    @GetMapping("members")
    public JSONObject findmember(String page,String limit) {
        String users = memberService.organizeMemberJson();
        System.out.println(users);
        JSONObject jsonObject = JSON.parseObject(users);
        return jsonObject;
    }


}
