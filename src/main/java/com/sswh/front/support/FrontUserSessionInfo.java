package com.sswh.front.support;

import com.sswh.front.entity.CurrentFrontUserEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangchengcheng on 2019/6/29
 */
public class FrontUserSessionInfo {


    public static CurrentFrontUserEntity getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        CurrentFrontUserEntity currentFrontUser = (CurrentFrontUserEntity) request.getSession().getAttribute("currentFrontUser");
        if (currentFrontUser == null) {
            return null;
        }
        return currentFrontUser;
    }
}
