package com.sswh.entity;


import java.util.List;

public class CurrentUser extends PlatformUser{

    /**
     * 拥有的角色
     */
    private List<Integer> roleIds;
    /**
     * 用户所拥有的所有权限
     */
    private List<Integer> rightsIds;

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public List<Integer> getRightsIds() {
        return rightsIds;
    }

    public void setRightsIds(List<Integer> rightsIds) {
        this.rightsIds = rightsIds;
    }
}
