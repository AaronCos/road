package com.sswh.support;

import com.sswh.platform.entity.PlatformUser;
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
import org.springframework.web.bind.annotation.*;
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
    public String subLogin(PlatformUser user,String gotoUrl) {
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
        subject.checkRoles("admin");
        subject.checkPermission("user:select");
        return "登陆成功";
    }
    @RequestMapping(value = "regist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ModelAndView registUserShow(PlatformUser user){

        return null;
    }
    @RequestMapping(value = "doregist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String registUser(PlatformUser user){

        return null;
    }



    @RequiresRoles("admin")
    @RequestMapping(value = "testAdmino")
    @ResponseBody
    public String testAdmin() {
        return "has admin role";
    }
    @RequestMapping("tab/{taburl}")
    public String about(@PathVariable String taburl){
        return "front/"+taburl;
    }

}
