package com.sswh.model.servlet;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Created by wangchengcheng on 2019/6/28
 */
public class MyHttpSessionActiveListener implements HttpSessionActivationListener {
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {

    }
}
