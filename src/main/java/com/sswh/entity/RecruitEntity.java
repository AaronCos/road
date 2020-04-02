package com.sswh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/***
 * @description 招聘信息实体
 * @return
 * @author nuanfeng
 * @date 2020/3/22 22:28
 */
public class RecruitEntity {
    private int iid;
    /**
     * 招聘标题
     */
    private String title;
    /**
     * 招聘科目
     */
    private int subject;
    /**
     * 招聘内容
     */
    private String content;
    /**
     * 联系人
     */
    private String humanResource;
    /**
     * 联系人电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 图片数组
     */
    private String image;
    /**
     * 招聘记录创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    /**
     * 招聘截止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 底薪，薪酬范围下限
     */
    private float salaryLow;
    /**
     * 高薪，薪酬范围上限
     */
    private float salaryHigh;

    private int pageshow;

    private int orderid;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHumanResource() {
        return humanResource;
    }

    public void setHumanResource(String humanResource) {
        this.humanResource = humanResource;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public float getSalaryLow() {
        return salaryLow;
    }

    public void setSalaryLow(float salaryLow) {
        this.salaryLow = salaryLow;
    }

    public float getSalaryHigh() {
        return salaryHigh;
    }

    public void setSalaryHigh(float salaryHigh) {
        this.salaryHigh = salaryHigh;
    }

    public int getPageshow() {
        return pageshow;
    }

    public void setPageshow(int pageshow) {
        this.pageshow = pageshow;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
}
