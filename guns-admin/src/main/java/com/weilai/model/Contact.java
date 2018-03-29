package com.weilai.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 
 * </p>
 *
 * @author weijx
 * @since 2017-12-10
 */
public class Contact extends Model<Contact> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.INPUT)
    private String id;
	private String name;
	private String mobile; 
	private String description; 
	@TableField("create_time")
	private Date createTime; 
	@TableField("read_state")
	private String readState;
	@TableField("del_flag")
	private String delFlag;
	
	@Override
	public String toString() {
		return "Renovation{" +
			"id=" + id +
			", name=" + name +
			", mobile=" + mobile +
			", description=" + description +
			", createTime=" +createTime +
			", readState=" + readState +
			", delFlag=" + delFlag +
			"}";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getReadState() {
		return readState;
	}

	public void setReadState(String readState) {
		this.readState = readState;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
