package com.sswh.entity;

/**
 * Created by wangchengcheng on 2019/2/22
 */
public class PlatformUser {
    private long iid;
    private String userUuid;
    private String username;
    private String password;
    private String mobilePhone;
    private String idCard;//个人身份证
    private String password_salt;//盐值


    public PlatformUser() {
    }

    public long getIid() {
        return iid;
    }

    public void setIid(long iid) {
        this.iid = iid;
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

    public String getPassword_salt() {
        return password_salt;
    }

    public void setPassword_salt(String password_salt) {
        this.password_salt = password_salt;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    @Override
    public String toString() {
        return "PlatformUser{" +
                "iid=" + iid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", password_salt='" + password_salt + '\'' +
                '}';
    }
}
