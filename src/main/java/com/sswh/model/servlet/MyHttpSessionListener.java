package com.sswh.model.servlet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by wangchengcheng on 2019/6/27
 */
public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute("hello","good morning");
        System.out.println(httpSessionEvent.getSession().getAttribute("hello"));
        String id = httpSessionEvent.getSession().getId();
        System.out.println("id:"+id);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
