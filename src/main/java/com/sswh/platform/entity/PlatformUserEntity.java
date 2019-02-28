package com.sswh.platform.entity;

import com.sswh.utils.MD5;
import com.sswh.utils.StringUtil;

/**
 * Created by wangchengcheng on 2019/2/22
 */
public class PlatformUserEntity {
    private long iid;
    private String userName;
    private String password;
    private String mobilePhone;
    private String idCard;//个人身份证

    public PlatformUserEntity() {
    }

    public PlatformUserEntity(String userName, String password) {
        this.userName = userName;
        if (StringUtil.isEmpty(password)){
            password = "123456";
        }
        this.password = MD5.md5(password);
    }

    public long getIid() {
        return iid;
    }

    public void setIid(long iid) {
        this.iid = iid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "PlatformUserEntity{" +
                "iid=" + iid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
