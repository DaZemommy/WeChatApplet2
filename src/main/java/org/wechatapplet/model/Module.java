package org.wechatapplet.model;

import java.util.Date;

public class Module extends ModuleExtend{
    private Long id;

    private String moduleName;

    private Long cateId;

    private String filePath;

    private Short status;

    private Date createDate;

    private String remark;

    private Long top;

    private String attrs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getTop() {
        return top;
    }

    public void setTop(Long top) {
        this.top = top;
    }

    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs == null ? null : attrs.trim();
    }

	@Override
	public String toString() {
		return "Module [id=" + id + ", moduleName=" + moduleName + ", cateId=" + cateId + ", filePath=" + filePath
				+ ", status=" + status + ", createDate=" + createDate + ", remark=" + remark + ", top=" + top
				+ ", attrs=" + attrs + ", releaseStatus="+getReleaseStatus()+", name="+getName()+"]";
	}
    
}