package com.sswh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Aspect
public class SessionValidateFilter {



    @Pointcut("execution(* com.sswh.front.support.FrontLoginOutController.login())")
    private void frontMethod() {
    }

    @Before("frontMethod()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("@Before:开始添加--order=3");
    }

}
