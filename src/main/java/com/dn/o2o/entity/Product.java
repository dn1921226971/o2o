package com.dn.o2o.entity;

import java.util.Date;
import java.util.List;

/**
 * 商品实体类
 * 
 * @author dn
 *
 */
public class Product {
	private Long productId;
	private String productName;
	private String productDesc;
	/**
	 * 商品的缩略图的地址
	 */
	private String imgAddr;
	/**
	 * 商品的原价
	 */
	private String normalPrice;
	/**
	 * 商品的折扣价
	 */
	private String promotionPrice;
	private String priority;
	private Date createTime;
	private Date lastEditTime;
	/**
	 * 商品的状态 0：表示下架，1：表示在前端系统展示
	 */
	private Integer enableStatus;
	/**
	 * 商品的详情图片列表
	 */
	private List<ProductImg> productImgList;
	/**
	 * 商品的所属类别
	 */
	private ProductCategory productcategory;
	/**
	 * 商品的所属店铺
	 */
	private Shop shop;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(String normalPrice) {
		this.normalPrice = normalPrice;
	}

	public String getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(String promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
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

	public List<ProductImg> getProductImgList() {
		return productImgList;
	}

	public void setProductImgList(List<ProductImg> productImgList) {
		this.productImgList = productImgList;
	}

	public ProductCategory getProductcategory() {
		return productcategory;
	}

	public void setProductcategory(ProductCategory productcategory) {
		this.productcategory = productcategory;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
