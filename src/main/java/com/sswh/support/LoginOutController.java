package com.sswh.support;

import cn.hutool.core.util.StrUtil;
import com.sswh.dao.IPlatformUserDao;
import com.sswh.entity.PlatformUser;
import com.sswh.platform.service.LoginOutService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wangchengcheng on 2019/3/9
 */
@Controller
@RequestMapping(value = "support")
public class LoginOutController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginOutService loginOutService;


    @Autowired
    IPlatformUserDao platformUserDao;


    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse respose, HttpSession session) {
        ModelAndView mv = new ModelAndView("support/login");
        mv.addObject("url", "dologin.do");
        PlatformUser platformUser = new PlatformUser();
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (StrUtil.isEmpty(username)) {
            mv.addObject("platformUser", platformUser);
        } else {
            try {
                respose.sendRedirect(request.getContextPath() + "/support/managerpage.do");
            } catch (IOException e) {
                e.printStackTrace();
            }
            platformUser.setUsername(username);
            mv.addObject("platformUser", platformUser);
        }

        return mv;
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ModelAndView subLogin(PlatformUser user, String gotoUrl) {
        log.info("username is:{} and password is:{}", user.getUsername(), user.getPassword());
        ModelAndView mv = new ModelAndView("support/managerpage");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {

        }
        mv.addObject("username", token.getUsername());
        return mv;
    }

    @RequestMapping(value = "regist")
    public ModelAndView registUserShow() {
        ModelAndView mv = new ModelAndView("support/regist");
        mv.addObject("url", "doregist.do");
        return mv;
    }

    @RequestMapping(value = "doregist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String registUser(PlatformUser user) {
        String message = "添加失败";
        if (user == null) {
            message = "请填写用户信息";
            return message;
        }
        //1. 判断此用户名称是否已经存在
        Integer count = platformUserDao.findCountByUsername(user.getUsername());
        if (count > 0) {
            message = "当前用户名已存在，请重新输入";
            return message;
        }
        String password_salt = StrUtil.uuid();
        user.setPassword_salt(password_salt);
        user.setPassword(new Md5Hash(user.getPassword(), password_salt).toString());
        user.setUserUuid(StrUtil.uuid());
        //2. 加密入库
        Integer registSuccessful = platformUserDao.registUser(user);
        if (registSuccessful < 1) {
            message = "注册失败";
            return message;
        }
        message = "注册成功，欢迎：" + user.getUsername();
        return message;
    }

    @RequestMapping(value = "logout")
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        if (!username.isEmpty()) {
            subject.logout();
        }
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "testAdmino")
    @ResponseBody
    public String testAdmin() {
        return "has admin role";
    }

    @RequestMapping("tab/{taburl}")
    public String about(@PathVariable String taburl) {
        return "front/" + taburl;
    }

    @RequestMapping(value = "wang", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String testWang() {
        UsernamePasswordToken token = new UsernamePasswordToken("wang", "123456");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
        return "登陆成功";
    }
}
