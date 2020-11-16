package com.sswh.entity;

import java.io.Serializable;

/**
 * (PlatformPermission)实体类
 *
 * @author AaronCos
 * @since 2020-10-15
 */
public class PlatformPermission implements Serializable {
    private static final long serialVersionUID = 342416345729356277L;

    private Integer iid;

    private String name;

    private String specify;


    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecify() {
        return specify;
    }

    public void setSpecify(String specify) {
        this.specify = specify;
    }

}