package com.sswh.model.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangchengcheng on 2019/6/27
 */
@Controller
@RequestMapping("listener")
public class ListenerTester {
    @RequestMapping("dog")
   public void test(HttpServletRequest req, HttpServletResponse response){
       ServletContext servletContext = req.getServletContext();
        DogEntity dog = (DogEntity) servletContext.getAttribute("dog");
        System.out.println(dog.toString());

    }
}
