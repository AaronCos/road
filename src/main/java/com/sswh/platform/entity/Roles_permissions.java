package com.sswh.platform.entity;

/**
 * Created by wangchengcheng on 2019/6/10
 */
public class Roles_permissions {
    private Integer iid;
    private String role_name;
    private String permission;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
