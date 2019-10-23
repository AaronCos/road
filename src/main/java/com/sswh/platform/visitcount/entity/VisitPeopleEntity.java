package com.sswh.platform.visitcount.entity;

import java.util.Date;

/**
 * Created by wangchengcheng on 2019/9/15
 * 访问级数 亿级
 */
public class VisitPeopleEntity {


    private String uuid;
    private String ip;
    private Integer userid;
    private Date visitTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    @Override
    public String toString() {
        return "VisitPeopleEntity{" +
                "uuid='" + uuid + '\'' +
                ", ip='" + ip + '\'' +
                ", userid=" + userid +
                ", visitTime=" + visitTime +
                '}';
    }
}
