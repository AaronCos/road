package com.sswh.platform.visitcount.servlet;

import com.sswh.platform.visitcount.service.VisitCountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by wangchengcheng on 2019/9/15
 */
@Component
public class VisitCountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {


        ServletContext sc = httpSessionEvent.getSession().getServletContext();
        VisitCountService visitCountService = (VisitCountService) this.getObjectFromApplication(sc, "visitCountService");
        visitCountService.countVisit();

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }

    private Object getObjectFromApplication(ServletContext servletContext, String beanname) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext application = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return applicationContext.getBean(beanname);
    }

}
