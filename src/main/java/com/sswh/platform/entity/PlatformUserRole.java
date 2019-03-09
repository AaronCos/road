package com.sswh.platform.entity;

/**
 * Created by wangchengcheng on 2019/3/9
 */
public class PlatformUserRole {


    /**
     * 主键
     */
    private Integer iid;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 机构id
     */
    private Integer groupId;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override public String toString() {
        return "PlatformRoleRelation{" + "iid=" + iid + ", roleId=" + roleId + ", userId=" + userId + ", groupId="
            + groupId + '}';
    }
}



