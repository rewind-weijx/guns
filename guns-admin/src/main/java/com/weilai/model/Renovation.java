package com.weilai.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author weijx
 * @since 2017-12-10
 */
public class Renovation extends Model<Renovation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 装修类型：1：智能家居2：定制木门3：软装部
     */
	private String type;
    /**
     * 标题
     */
	private String title;
    /**
     * 内容
     */
	private String content;
    /**
     * 图片地址
     */
	private String image;
    /**
     * 查看次数
     */
	@TableField("read_count")
	private Long readCount;
    /**
     * 是否为热点文章：0：不是1：是
     */
	private String hot;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 创建人
     */
	@TableField("create_by")
	private String createBy;
    /**
     * 删除标志：0：正常1：已删除
     */
	@TableField("del_flag")
	private String delFlag;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Long getReadCount() {
		return readCount;
	}

	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}

	public String getHot() {
		return hot;
	}

	public void setHot(String hot) {
		this.hot = hot;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Renovation{" +
			"id=" + id +
			", type=" + type +
			", title=" + title +
			", content=" + content +
			", image=" + image +
			", readCount=" + readCount +
			", hot=" + hot +
			", createTime=" + createTime +
			", createBy=" + createBy +
			", delFlag=" + delFlag +
			"}";
	}
}
