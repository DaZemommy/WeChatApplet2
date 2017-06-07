package org.wechatapplet.model;

import java.util.Date;

public class ModuleCate {
    private Integer id;

    private String name;

    private Integer parentId;

    private Short status;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "ModuleCate [id=" + id + ", name=" + name + ", parentId=" + parentId + ", status=" + status
				+ ", createTime=" + createTime + "]";
	}
    
    
}