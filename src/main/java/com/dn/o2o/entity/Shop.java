package com.dn.o2o.entity;

import java.util.Date;

/**
 * 店铺实体类
 * 
 * @author dn
 *
 */
public class Shop {
	private Long shopId;
	private String shopName;
	/**
	 * 店铺的描述
	 */
	private String shopDesc;
	/**
	 * 店铺的具体地址
	 */
	private String shopAddr;
	/**
	 * 店铺的电话
	 */
	private String phone;
	/**
	 * 店铺的缩略图地址
	 */
	private String shopImg;
	/**
	 * 店铺的权重
	 */
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;
	/**
	 * 店铺的状态 -1：表示不可用，0：表示审核中，1：表示可用
	 */
	private Integer enableStatus;
	/**
	 * 超级管理员给店家的建议
	 */
	private String advice;
	/**
	 * 店铺的所属区域
	 */
	private Area area;
	/**
	 * 店铺的创建者，也就是老板
	 */
	private PersonInfo owner;
	/**
	 * 店铺的所属类别
	 */
	private ShopCategory shopCategory;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDesc() {
		return shopDesc;
	}

	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public PersonInfo getOwner() {
		return owner;
	}

	public void setOwner(PersonInfo owner) {
		this.owner = owner;
	}

	public ShopCategory getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(ShopCategory shopCategory) {
		this.shopCategory = shopCategory;
	}
}
