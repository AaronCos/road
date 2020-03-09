package com.sswh.entity;

import java.util.Date;

/**
 * 招聘信息展示实体
 * @author Aaron
 * @date 2020/3/6 22:52
 */
public class RecruitEntity {
    private int iid;
    /**
     * 招聘标题
     */
    private String title;
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
    private String[] imgUrls;
    /**
     * 招聘记录创建时间
     */
    private Date createTime;
    /**
     * 招聘截止时间
     */
    private Date endTime;

    /**
     * 底薪，薪酬范围下限
     */
    private String salaryLow;
    /**
     * 高薪，薪酬范围上限
     */
    private String salaryHigh;


}
