package com.sswh.model.loginmodel;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by wangchengcheng on 2019/7/30
 */
public class YcLogin {

    private ModelAndView login(String loginName) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        session.setAttribute("frontUser", loginName);
        delay(5000);
        return null;
    }

    private void delay(int time) {
        Timer timer = new Timer();// 实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("退出");
                this.cancel();
            }
        }, time);// 这里百毫秒
        System.out.println("本程序存在5秒后自动退出");
    }
}
