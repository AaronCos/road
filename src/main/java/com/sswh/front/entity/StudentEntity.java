package com.sswh.front.entity;

import java.util.Map;

/**
 * Created by wangchengcheng on 2019/6/26
 */
public class StudentEntity {
    private String iid;
    private String userName;
    private String realName;
    private String zym;//座右铭
    private String age;//由出生年月退出
    private String sx;//生肖
    private String xz;//星座
    private String hobbies;//兴趣特长,最多200个字
    private Map<String,Float> beginGrade;//入学时各科目成绩
    private String aim;//目标和梦想，一年可以维护一次
    private String parent_talk;//家长寄语
    private ImgEntity imgEntity;

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSx() {
        return sx;
    }

    public void setSx(String sx) {
        this.sx = sx;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, Float> getBeginGrade() {
        return beginGrade;
    }

    public void setBeginGrade(Map<String, Float> beginGrade) {
        this.beginGrade = beginGrade;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getParent_talk() {
        return parent_talk;
    }

    public void setParent_talk(String parent_talk) {
        this.parent_talk = parent_talk;
    }

    public ImgEntity getImgEntity() {
        return imgEntity;
    }

    public void setImgEntity(ImgEntity imgEntity) {
        this.imgEntity = imgEntity;
    }
}
