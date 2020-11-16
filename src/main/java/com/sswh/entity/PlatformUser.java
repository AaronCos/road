package com.sswh.entity;

/**
 * 后台用户pojo
 * @author Aaron
 */
public class PlatformUser {

    private Integer iid;

    /**
     * 所属机构id
     */
    private Integer groupIid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 加密后的密码
     */
    private String password;
    /**
     * 手机号
     */
    private String mobilePhone;
    /**
     * 个人身份证号
     */
    private String idCard;
    /**
     * 盐值
     */
    private String passwordSalt;



    public PlatformUser() {
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getGroupIid() {
        return groupIid;
    }

    public void setGroupIid(Integer groupIid) {
        this.groupIid = groupIid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    @Override
    public String toString() {
        return "PlatformUser{" +
                "iid=" + iid +
                ", groupIid=" + groupIid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                '}';
    }
}
