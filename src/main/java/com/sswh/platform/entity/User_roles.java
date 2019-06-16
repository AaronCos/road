package com.sswh.platform.entity;

/**
 * Created by wangchengcheng on 2019/6/10
 */
public class User_roles {
    private Integer iid;
    private String username;
    private String role_name;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
