package com.sswh.platform.controller;

import cn.hutool.json.JSONObject;
import com.sswh.front.entity.FrontUserEntity;
import com.sswh.platform.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Aaron
 * @Description:
 * @Date Created in 6:49 2019/12/25
 * @Modeified by:
 */
@RequestMapping("manager/opr")
@RestController
public class OprMemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("useradd")
    public Map<String, Object> addUser(FrontUserEntity frontUser) {
        HashMap<String, Object> map = new HashMap<>();
        String area[] = frontUser.getCity_picker().split("/");
        frontUser.setProvince(area[0]);
        frontUser.setCity(area[1]);
        frontUser.setDistrict(area[2]);
        Integer count = null;
        try {
            count = memberService.addMember(frontUser);
        } catch (Exception e) {
            map.put("success", 0);
            map.put("code","000");
            map.put("message", "添加失败");
        }
        if (count < 1) {
            map.put("success", 0);
            map.put("code","001");
            map.put("message", "添加失败");
        }
        map.put("success", 1);
        map.put("code","111");
        map.put("message", "添加成功");
        return map;
    }

    @RequestMapping(value="/userdel")
    @ResponseBody
    public JSONObject deleteFrontUser(String ids) {

        boolean success =  memberService.deleteFrontUser(ids);
        JSONObject json = new JSONObject();
        json.put("success",success);
        return json;
    }
}
