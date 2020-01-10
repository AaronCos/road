package com.sswh.front.support;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.sswh.front.dao.IFrontUserDao;
import com.sswh.front.entity.CurrentFrontUserEntity;
import com.sswh.front.entity.FrontUserEntity;
import com.sswh.utils.StringUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron on 2019/6/26
 */
@Controller
@RequestMapping("front")
public class FrontLoginOutController {
    @Autowired
    IFrontUserDao frontUserDao;

    @RequestMapping("login")
    public ModelAndView login() {
        System.out.println("33333333333");
        ModelAndView mv = new ModelAndView("front/login");
        mv.addObject("url", "jumpToIndex.do");
        return mv;
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private void validateFrontUser(FrontUserEntity user, HttpSession session, HttpServletResponse response) {
        System.out.println("44444444444");
        CurrentFrontUserEntity currentFrontUserEntity = new CurrentFrontUserEntity();
        Map<String,String> map = new HashMap<>();
        PrintWriter  writer  = null;
         try {
             response.setContentType("text/json;charset=utf-8");
             writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (user == null || StrUtil.isEmpty(user.getLoginname()) || StrUtil.isEmpty(user.getPassword())) {
            map.put("code","00");
            map.put("msg","请输入用户名和密码");
            String s = JSON.toJSONString(map);
            writer.write(s);
        }
        FrontUserEntity resultUser = findByUserName(user.getLoginname());
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), resultUser.getPassword_salt());
        if (resultUser.getPassword().equals(md5Hash.toString())) {
            currentFrontUserEntity.setLoginname(resultUser.getLoginname());
            session.setAttribute("currentFrontUser", currentFrontUserEntity);

            map.put("code","01");
            map.put("msg","登陆成功");
            String s = JSON.toJSONString(map);
            writer.write(s);
        }else {
            map.put("code","03");
            map.put("msg","登陆失败，请重新登录");
            String s = JSON.toJSONString(map);
            writer.write(s);
        }
        writer.close();
    }
    @RequestMapping("jumpToIndex")
    private String jumpToIndex(HttpServletRequest request){
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
    public String registUser(FrontUserEntity user) {
        String message = "注册失败";
        if (user == null) {
            message = "请填写用户信息";
            return message;
        }
        //1. 判断此登录名称是否已经存在
        Integer count = frontUserDao.findCountByLoginname(user.getLoginname());
        if (count > 0) {
            message = "当前登录名已存在，请重新输入";
            return message;
        }
        String password_salt = StringUtil.uuid();
        user.setPassword_salt(password_salt);
        user.setPassword(new Md5Hash(user.getPassword(), password_salt).toString());

        //2. 加密入库
        Integer registSuccessful = frontUserDao.registUser(user);
        if (registSuccessful < 1) {
            message = "注册失败";
            return message;
        }

        message = "注册成功，欢迎：" + user.getLoginname();
        return message;
    }

    private FrontUserEntity findByUserName(String username) {
        FrontUserEntity frontUser = frontUserDao.findByLoginName(username);

        return frontUser;
    }
   @RequestMapping("logout")
    private String logout(HttpSession session){
        if (null != session.getAttribute("currentFrontUser")) {
           session.removeAttribute("currentFrontUser");
        }
        return "redirect:/support/tab/index.do";
    }

}
