package com.sswh.platform.visitcount.entity;

import java.util.Date;

/**
 * Created by wangchengcheng on 2019/9/15
 */
public class VisitEveryDayEntity {

    private String uuid;  //uuid主键

    private Integer visitNumber; //每天的访问数量

    private Date date;//日期格式：yyyy-MM-dd 用于按天统计访问次数


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(Integer visitNumber) {
        this.visitNumber = visitNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "VisitEveryDayEntity{" +
                "uuid='" + uuid + '\'' +
                ", visitNumber=" + visitNumber +
                ", date=" + date +
                '}';
    }
}
