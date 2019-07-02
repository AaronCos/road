package com.sswh.front.entity;

import java.util.Date;

/**
 * Created by wangchengcheng on 2019/6/30
 */
public class StudentGradeEntity {
    private Integer iid;
    private String username;
    private String mainSequence;//同一批次考试不同学生
    private String sequence;
    private Date submitTime;
    private Float scores;
    private String mainSubjcet;
    private String realName;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMainSequence() {
        return mainSequence;
    }

    public void setMainSequence(String mainSequence) {
        this.mainSequence = mainSequence;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Float getScores() {
        return scores;
    }

    public void setScores(Float scores) {
        this.scores = scores;
    }

    public String getMainSubjcet() {
        return mainSubjcet;
    }

    public void setMainSubjcet(String mainSubjcet) {
        this.mainSubjcet = mainSubjcet;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
