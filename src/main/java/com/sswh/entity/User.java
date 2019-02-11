package com.sswh.entity;

import java.util.Date;

public class User {
	private int iid;
	private String id;
	private String userName;
	private String passWord;
	private Integer sex;
	private Date birthday;
	private String identity;
	private String email;
	private String mobile;
	private String address;
	private Integer status;
	private String code;
	
	private String year;
	private String month;
	private String day;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int iid, String id, String userName, String passWord,
			Integer sex, Date birthday, String identity, String email,
			String mobile, String address, Integer status, String code,
			String year, String month, String day) {
		super();
		this.iid = iid;
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.sex = sex;
		this.birthday = birthday;
		this.identity = identity;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.status = status;
		this.code = code;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "User{" +
				"iid=" + iid +
				", id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", passWord='" + passWord + '\'' +
				", sex=" + sex +
				", birthday=" + birthday +
				", identity='" + identity + '\'' +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", address='" + address + '\'' +
				", status=" + status +
				", code='" + code + '\'' +
				", year='" + year + '\'' +
				", month='" + month + '\'' +
				", day='" + day + '\'' +
				'}';
	}
}
