package com.sswh.entity;

import java.io.Serializable;

/**
 * (PlatformGroup)实体类
 *
 * @author makejava
 * @since 2020-06-14 13:38:15
 */
public class PlatformGroup implements Serializable {
    private static final long serialVersionUID = 878478297746147864L;
    /**
    * 主键
    */
    private Integer iid;

    
    private String name;
    /**
     * 说明
     */
    private String spec;
    /**
     * 父级id
     */
    private Integer piid;
    
    private String codeid;
    
    private Integer orderid;
    
    private String pinyin;


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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getPiid() {
        return piid;
    }

    public void setPiid(Integer piid) {
        this.piid = piid;
    }

    public String getCodeid() {
        return codeid;
    }

    public void setCodeid(String codeid) {
        this.codeid = codeid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

}