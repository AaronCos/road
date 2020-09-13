package com.sswh.userpivot.entity;

import java.io.Serializable;

/**
 * (WeuiUser)微信和表达
 *
 * @author makejava
 * @since 2020-08-17
 */
public class WeuiUser implements Serializable {
    private static final long serialVersionUID = -69461141865429372L;
    
    private Integer iid;
    
    private String weId;
    
    private String weName;
    
    private String complatUserid;


    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getWeId() {
        return weId;
    }

    public void setWeId(String weId) {
        this.weId = weId;
    }

    public String getWeName() {
        return weName;
    }

    public void setWeName(String weName) {
        this.weName = weName;
    }

    public String getComplatUserid() {
        return complatUserid;
    }

    public void setComplatUserid(String complatUserid) {
        this.complatUserid = complatUserid;
    }

}