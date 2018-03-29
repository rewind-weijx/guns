package com.weilai.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;

public class RenovationDetail {

	private String id;
	@TableField(value="renovation_id")
	private String renovationId; 
	private String title;
	private String content; 
	private String image;
	@TableField(value="create_time")
	private Date createTime; 
	@TableField(value="create_by")
	private String createBy;
	@TableField(value="del_flag")
	private String delFlag;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRenovationId() {
		return renovationId;
	}
	public void setRenovationId(String renovationId) {
		this.renovationId = renovationId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
}
