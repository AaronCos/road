package com.sswh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Aspect
@Component
public class SessionValidateFilter {



    @Pointcut("execution(* com.sswh.front.support.*(..)) || execution(* com.sswh.platform.controller.*(..))")
    private void frontMethod() {
    }

    @Before("frontMethod()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("@Before:开始添加--order=3");
    }

    @AfterReturning("execution(* com.sswh.front.support.*(..))")
    public void doAfterReturning(JoinPoint joinPoint) {

        System.out.println("Completed: " + joinPoint);

    }

    //声明例外通知
    @AfterThrowing(pointcut = "frontMethod()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        System.out.println("@AfterThrowing:例外通知--order=3");
        System.out.println(e.getMessage());
    }

    //声明最终通知
    @After("frontMethod()")
    public void doAfter() {
        System.out.println("@After:最终通知--order=3");
    }



    /**
     * 声明环绕通知
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("frontMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        HttpSession session = null;
        session.getAttribute("currentFrontUser");
        long begin = System.nanoTime();
        Object obj = pjp.proceed();
        long end = System.nanoTime();
        System.out.println("调用Mapper方法：{"+pjp.getSignature().toString()+"}，参数：{"+ Arrays.toString(pjp.getArgs())+"}，执行耗时：{"+(end - begin)+"}纳秒，耗时：{"+(end - begin) / 1000000+"}毫秒");
       // log.info("调用Mapper方法：{"+pjp.getSignature().toString()+"}，参数：{"+ Arrays.toString(pjp.getArgs())+"}，执行耗时：{"+(end - begin)+"}纳秒，耗时：{"+(end - begin) / 1000000+"}毫秒") ;
        return obj;
    }
}
