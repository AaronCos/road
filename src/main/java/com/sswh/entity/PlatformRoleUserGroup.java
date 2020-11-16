package com.sswh.entity;

import java.io.Serializable;

/**
 * (PlatformRoleUserGroup)实体类
 *
 * @author AaronCos
 * @since 2020-10-15
 */
public class PlatformRoleUserGroup implements Serializable {
    private static final long serialVersionUID = 900794765149308683L;

    private Integer iid;

    private Integer roleid;

    private Integer userid;

    private Integer groupid;


    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

}