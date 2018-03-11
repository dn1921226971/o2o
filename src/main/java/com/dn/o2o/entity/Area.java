package com.dn.o2o.entity;

import java.util.Date;

/**
 * 区域实体类
 * 
 * @author dn
 *
 */
public class Area {
	private Integer areaId;
	private String areaName;

	/** 区域的权重 */
	private Integer priority;

	/** 区域的创建时间 */
	private Date createTime;

	/** 区域的最后一次修改时间 */
	private Date lastEditTime;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
}
