package com.sswh.model.servlet;

import cn.hutool.cron.CronUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by wangchengcheng on 2019/6/27
 */
public class MyServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        CronUtil.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
