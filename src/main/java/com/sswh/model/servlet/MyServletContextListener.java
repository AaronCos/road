package com.sswh.model.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by wangchengcheng on 2019/6/27
 */
public class MyServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext sc = servletContextEvent.getServletContext();
        String dog = sc.getInitParameter("dog");
        DogEntity dogEntity = new DogEntity(dog);
        sc.setAttribute("dog",dogEntity);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
