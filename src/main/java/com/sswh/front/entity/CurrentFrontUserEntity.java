package com.sswh.front.entity;

/**
 * Created by wangchengcheng on 2019/6/29
 */
public class CurrentFrontUserEntity {
    private String loginname;
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }
}
