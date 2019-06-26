package com.sswh.support;

import com.sswh.platform.entity.PlatformUser;
import com.sswh.platform.entity.Users;
import com.sswh.platform.service.IUsersService;
import com.sswh.platform.service.LoginOutService;
import com.sswh.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
    IUsersService usersService;


    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse respose, HttpSession session) {
        ModelAndView mv = new ModelAndView("support/login");
        mv.addObject("url", "dologin.do");
        PlatformUser platformUser = new PlatformUser();
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (StringUtil.isEmpty(username)) {
            platformUser.setUserName("");
            platformUser.setPassword("");
            mv.addObject("platformUser", platformUser);
        } else {
            platformUser.setUserName(username);
            platformUser.setPassword("");
            mv.addObject("platformUser", platformUser);
        }

        // mv.addObject("platformUser",currentUser);
        return mv;
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String subLogin(PlatformUser user, String gotoUrl) {
        log.debug("username is:{} and password is:{}", user.getUserName(), user.getPassword());
        String url = null;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
        /*subject.checkRoles("admin");
        subject.checkPermission("user:select");*/
        return "登陆成功";
    }

    @RequestMapping(value = "regist")
    public ModelAndView registUserShow() {
        ModelAndView mv = new ModelAndView("support/regist");
        mv.addObject("url", "doregist.do");
        return mv;
    }

    @RequestMapping(value = "doregist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String registUser(Users user) {
        String message = "添加失败";
        if (user == null) {
            message = "请填写用户信息";
            return message;
        }
        //1. 判断此用户名称是否已经存在
        int userNum = usersService.findByUserName(user.getUsername());
        if (userNum > 0) {
            message = "当前用户名已存在，请重新输入";
            return message;
        }
        //2. 加密入库
        boolean registSuccessful = usersService.registUsers(user);
        if (!registSuccessful) {
            message = "注册失败";
            return message
                    ;
        }

        message = "注册成功，欢迎：" + user.getUsername();
        return message;
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

}
