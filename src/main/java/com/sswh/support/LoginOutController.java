package com.sswh.support;

import cn.hutool.core.util.StrUtil;
import com.sswh.dao.PlatformUserDao;
import com.sswh.entity.PlatformUser;
import com.sswh.platform.service.LoginOutService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制台控制层
 * Created by AaronCos on 2019/3/9
 */
@Controller
@RequestMapping(value = "support")
public class LoginOutController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginOutService loginOutService;


    @Autowired
    PlatformUserDao platformUserDao;

    /**
     * 打开控制台登录界面控制层
     * @param request
     * @return 控制台登录界面视图
     */
    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("support/login");
        //读取用户名的cookie，用于回填，提升用户体验
        Cookie[] cookies = request.getCookies();
        PlatformUser platformUser = new PlatformUser();
        if (cookies != null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if(name.equals("username_cookie")){
                    platformUser.setUsername(cookie.getValue());
                    mv.addObject("platformUser", platformUser);
                }
            }
        }
        //若当前用户已经登陆，直接跳转到工作台，无法进入登陆页面
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (StrUtil.isNotEmpty(username)) {
            RedirectView redirectView = new RedirectView(request.getContextPath() + "/manager/center/index.do");
            mv.setView(redirectView);
        }
        mv.addObject("url", "dologin.do");
        return mv;
    }

    /**
     * 控制台登录信息提交验证
     * @param user 后台用户信息
     * @param request 请求
     * @param verifyCode 验证码
     * @param gotoUrl 登录成功后回跳地址
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ModelAndView subLogin(PlatformUser user, String verifyCode, String gotoUrl, HttpServletRequest request, HttpServletResponse response) {
        //TODO:CSRF校验

        log.info("username is:{} and password is:{}", user.getUsername(), user.getPassword());
        ModelAndView mv = new ModelAndView("/manager/center/index.do");
        RedirectView redirectView = new RedirectView(request.getContextPath() + "/manager/center/index.do");
        mv.setView(redirectView);
        //TODO:验证码校验功能

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            Cookie cookie = new Cookie("username_cookie",user.getUsername());
            response.addCookie(cookie);
        } catch (AuthenticationException e) {
            //FIXME:登录失败跳转页面
            redirectView = new RedirectView(request.getContextPath() + "/exception_show.do?exception=用户名或者密码错误");
            mv.setView(redirectView);
            return mv;
        }
        return mv;
    }

    /**
     * 打开注册页面控制层
     * @return
     */
    @RequestMapping(value = "regist")
    public ModelAndView registUserShow() {
        ModelAndView mv = new ModelAndView("support/regist");
        mv.addObject("url", "doregist.do");
        return mv;
    }

    /**
     * 使用ajax注册信息验证及提交
     * @param user
     * @return
     */
    @RequestMapping(value = "doregist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String registUser(PlatformUser user) {
        //TODO:csrf校验

        String message = "添加失败";
        if (user == null) {
            message = "请填写用户信息";
            return message;
        }
        //判断此用户名称是否已经存在
        Integer count = platformUserDao.findCountByUsername(user.getUsername());
        if (count > 0) {
            message = "当前用户名已存在，请重新输入";
            return message;
        }
        String password_salt = StrUtil.uuid();
        user.setPasswordSalt(password_salt);
        user.setPassword(new Md5Hash(user.getPassword(), password_salt).toString());
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
    public String testWang(@RequestParam(value = "wang",required = false) String name) {

        UsernamePasswordToken token = new UsernamePasswordToken(name, "qwer1234");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
        return "登陆成功";
    }

    @RequestMapping(value = "permis")
    @RequiresPermissions("user:add")
    public String testPermission(){
        System.out.println("good morning");

        return "有权限";
    }
}
