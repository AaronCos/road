package com.sswh.front.support;

import com.sswh.front.dao.IFrontUserDao;
import com.sswh.front.entity.CurrentFrontUserEntity;
import com.sswh.front.entity.FrontUserEntity;
import com.sswh.utils.StringUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangchengcheng on 2019/6/26
 */
@RestController
@RequestMapping("front")
public class FrontLoginOutController {
    @Autowired
    IFrontUserDao frontUserDao;

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView("front/login");
        mv.addObject("url", "dologin.do");
        CurrentFrontUserEntity currentUser = FrontUserSessionInfo.getCurrentUser();
        FrontUserEntity frontUserEntity = new FrontUserEntity();
        String username = null;
        if (currentUser != null) {
            username = currentUser.getUsername();
            frontUserEntity.setUsername(currentUser.getUsername());
        }
        if (StringUtil.isEmpty(username)) {
            mv.addObject("frontUser", frontUserEntity);
        } else {
            mv.addObject("frontUser", frontUserEntity);
        }

        // mv.addObject("platformUser",currentUser);
        return mv;
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String validateFrontUser(FrontUserEntity user, HttpSession session) {
        CurrentFrontUserEntity currentFrontUserEntity = new CurrentFrontUserEntity();
        List<String> messages = new ArrayList<>();
        if (user == null) {
            messages.add("请输入用户信息");
            return messages.get(0);
        }
        FrontUserEntity resultUser = findByUserName(user.getUsername());
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), resultUser.getPassword_salt());
        if (resultUser == null) {
            messages.add("用户不存在，请重新输入");
            return messages.get(0);
        }
        if (resultUser.getPassword().equals(md5Hash.toString())) {
            currentFrontUserEntity.setUsername(resultUser.getUsername());
            session.setAttribute("currentFrontUser", currentFrontUserEntity);
            return "登陆成功";
        }else {
            return "用户不存在，请重新输入";
        }

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
        //1. 判断此用户名称是否已经存在
        Integer count = frontUserDao.findCountByUsername(user.getUsername());
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

        message = "注册成功，欢迎：" + user.getUsername();
        return message;
    }

    private FrontUserEntity findByUserName(String username) {
        FrontUserEntity frontUser = frontUserDao.findBaseUserInfo(username);
        return frontUser;
    }


}
