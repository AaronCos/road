package com.sswh.entity;

import java.io.Serializable;

/**
 * (PlatformRolesPermissions)实体类
 *
 * @author makejava
 * @since 2020-10-15 23:32:35
 */
public class PlatformRolesPermissions implements Serializable {
    private static final long serialVersionUID = -16528365489709489L;

    private Integer iid;

    private Integer roleid;

    private Integer permissionid;


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

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

}