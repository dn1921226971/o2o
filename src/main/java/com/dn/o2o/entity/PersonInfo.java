package com.dn.o2o.entity;

import java.util.Date;

/**
 * 用户实体类
 * 
 * @author dn
 *
 */
public class PersonInfo {
	private Long userId;
	private String name;
	/**
	 * 用户的头像地址
	 */
	private String profileImg;
	private String email;
	/**
	 * 用户的性别
	 */
	private String gender;
	/**
	 * 用户的状态 0:禁止使用本平台,1:允许使用本平台
	 */
	private Integer enableStatus;
	/**
	 * 用户的身份标识 1：表示顾客，2：表示店家，3：表示超级管理员
	 */
	private Integer userType;
	/**
	 * 用户的创建时间
	 */
	private Date createTime;
	/**
	 * 用户的最后一次修改时间
	 */
	private Date lastEditTime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
}
