package com.sswh.platform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sswh.entity.GradeConfig;
import com.sswh.entity.SubjectGrade;
import com.sswh.front.entity.FrontUserEntity;
import com.sswh.platform.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ResponseBody
    public JSONObject findmember(String page,String limit) {
        String users = memberService.organizeMemberJson();
        System.out.println("11111111111111111"+users);
        JSONObject jsonObject = JSON.parseObject(users);
        return jsonObject;
    }

    @RequestMapping(value="/updateStatusOrIsStudent")
    @ResponseBody
    public void updateStatusOrIsStudent(String iid,String name,String state) {

        memberService.updateStatusOrIsStudent(iid,name,state);

    }

    @RequestMapping(value="/findFrontUsers",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public cn.hutool.json.JSONObject findByFrontUsername(String start, String end, String username, int limit, int page) {

        List<FrontUserEntity> userList = memberService.findFrontUsers(username,start,end,(page-1)*limit,limit);
        int pageCount = memberService.findFrontUsersCount(username,start,end);
        cn.hutool.json.JSONObject json = new cn.hutool.json.JSONObject();
        json.put("code","0");
        json.put("msg","");
        json.put("count",pageCount);
        json.put("data", userList);

        return json;
    }


}
