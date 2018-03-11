package com.dn.o2o.entity;

import java.util.Date;

/**
 * 微信账号实体类
 * 
 * @author dn
 *
 */
public class WechatAuth {
	private Long wechatAuthId;

	/** openId是微信账号和公众号绑定的唯一标识 */
	private String openId;

	private Date createTime;
	private PersonInfo personInfo;

	public Long getWechatAuthId() {
		return wechatAuthId;
	}

	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
