package com.sswh.exchange.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (RememberList)实体类
 *
 * @author makejava
 * @since 2020-08-05 19:18:44
 */
public class RememberList implements Serializable {
    private static final long serialVersionUID = -10578718870804653L;
    
    private Integer iid;
    
    private Integer userid;
    
    private String title;
    
    private Object content;
    
    private Date createtime;
    
    private Date updatetime;


    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

}