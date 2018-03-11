package com.dn.o2o.entity;

import java.util.Date;

/**
 * 头条实体类
 * 
 * @author dn
 *
 */
public class HeadLine {
	private Long lineId;

	/** 头条的名称 */
	private String lineName;

	/** 头条的链接 */
	private String lineLink;

	/** 头条的图片 */
	private String lineImg;

	/** 头条的权重 */
	private Integer priority;

	/**
	 * 头条的状态 0：表示不可用，1：表示可用
	 */
	private Integer enableStatus;
	
	private Date createTime;
	private Date lastEditTime;

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLineLink() {
		return lineLink;
	}

	public void setLineLink(String lineLink) {
		this.lineLink = lineLink;
	}

	public String getLineImg() {
		return lineImg;
	}

	public void setLineImg(String lineImg) {
		this.lineImg = lineImg;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
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
