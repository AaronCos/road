package com.sswh.exchange.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (RememberLog)实体类
 *
 * @author makejava
 * @since 2020-08-06 10:41:59
 */
public class RememberLog implements Serializable {
    private static final long serialVersionUID = 788070791993171761L;
    
    private Integer iid;
    
    private Integer rememberListIid;
    
    private Date sendtime; //可以直接获取到数据库中Datetime类型
    /**
    * 1、pc
2、wx小程序
3、wx公众号
4、支付宝小程序
5、短信
    */
    private Integer client;
    
    private Integer result;
    /**
    * 1、已读
0、未读 default

    */
    private Integer finished;


    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getRememberListIid() {
        return rememberListIid;
    }

    public void setRememberListIid(Integer rememberListIid) {
        this.rememberListIid = rememberListIid;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

}