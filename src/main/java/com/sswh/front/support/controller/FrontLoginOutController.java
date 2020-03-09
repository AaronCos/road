package com.sswh.front.support.controller;

import cn.hutool.core.util.StrUtil;
import com.sswh.front.entity.CurrentFrontUserEntity;
import com.sswh.front.entity.FrontUserEntity;
import com.sswh.front.support.service.FrontLoginOutService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron on 2019/6/26
 *
 * @author mirac
 */
@Controller
@RequestMapping("front")
public class FrontLoginOutController {
    @Autowired
    FrontLoginOutService frontLoginOutService;


    @RequestMapping("login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("front/login");
        mv.addObject("url", "jumpToIndex.do");
        return mv;
    }

    @RequestMapping(value = "/dologin", produces = "application/json;charset=utf-8")
    @ResponseBody
    private Map validateFrontUser(FrontUserEntity user, String checkCode,HttpSession session) {
        Map<String, String> map = new HashMap<>();
        if (StrUtil.isEmpty(checkCode)) {
            map.put("code", "04");
            map.put("msg", "请输入验证码");
        }else{
            String verycode =(String) session.getAttribute("verycode");
            if (!StrUtil.equals(checkCode,verycode)) {
                map.put("code", "05");
                map.put("msg", "验证码输入错误");
                return map;
            }
        }
        CurrentFrontUserEntity currentFrontUserEntity = new CurrentFrontUserEntity();

        if (user == null || StrUtil.isEmpty(user.getLoginname()) || StrUtil.isEmpty(user.getPassword())) {
            map.put("code", "00");
            map.put("msg", "请输入用户名和密码");
            return map;
        }
        FrontUserEntity resultUser = frontLoginOutService.findByLoginname(user.getLoginname());
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), resultUser.getPassword_salt());
        if (resultUser.getPassword().equals(md5Hash.toString())) {
            currentFrontUserEntity.setLoginname(resultUser.getLoginname());
            session.setAttribute("currentFrontUser", currentFrontUserEntity);
            map.put("code", "01");
            map.put("msg", "登陆成功");
        } else {
            map.put("code", "03");
            map.put("msg", "用户名或密码错误");
        }
        return map;
    }

    @RequestMapping("jumpToIndex")
    private String jumpToIndex(HttpServletRequest request) {
        System.gc();
        return "redirect:/support/tab/index.do";
    }

    @RequestMapping(value = "regist")
    public ModelAndView registUserShow() {
        ModelAndView mv = new ModelAndView("front/regist");
        mv.addObject("url", "doregist.do");
        return mv;
    }

    @RequestMapping(value = "doregist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map registUser(FrontUserEntity user,String checkCode,HttpSession session) {
        Map<String, String> map = new HashMap<>();
        if (StrUtil.isEmpty(checkCode)) {
            map.put("code", "0003");
            map.put("msg", "请输入验证码");
        }else{
            String verycode =(String) session.getAttribute("verycode");
            if (!StrUtil.equals(checkCode,verycode)) {
                map.put("code", "0004");
                map.put("msg", "验证码输入错误");
                return map;
            }
        }

        if (user == null) {
            map.put("code","0003");
            map.put("msg","请填写用户信息");
            return map;
        }
        //1. 判断此登录名称是否已经存在
        Integer count = frontLoginOutService.findCountByLoginname(user.getLoginname());
        if (count > 0) {
            map.put("code","0005");
            map.put("msg","当前登录名已存在，请重新输入");
            return map;
        }
        String password_salt = StrUtil.uuid();
        user.setPassword_salt(password_salt);
        user.setPassword(new Md5Hash(user.getPassword(), password_salt).toString());

        //2. 加密入库
        Integer registSuccessful = frontLoginOutService.registUser(user);
        if (registSuccessful < 1) {
            map.put("code","0002");
            map.put("msg","注册失败");
            return map;
        }
        map.put("code","0001");
        map.put("msg","注册成功，欢迎：" + user.getLoginname());
        return map;
    }

    private FrontUserEntity findByUserName(String username) {
        FrontUserEntity frontUser = frontLoginOutService.findByLoginname(username);
        return frontUser;
    }

    @RequestMapping("logout")
    private String logout(HttpSession session) {
        if (null != session.getAttribute("currentFrontUser")) {
            session.removeAttribute("currentFrontUser");
        }
        return "redirect:/support/tab/index.do";
    }

}
