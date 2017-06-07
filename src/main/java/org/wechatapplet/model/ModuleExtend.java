package org.wechatapplet.model;

/**
 * module扩展
 * @author lenovo
 */
public class ModuleExtend {

	/**
     * 发布状态
     */
    private Short releaseStatus;
    /**
     * 模块分类名称 
     */
    private String name;

	/**
	 * @return the 发布状态
	 */
	public Short getReleaseStatus() {
		return releaseStatus;
	}
	

	/**
	 * @param 发布状态 the releaseStatus to set
	 */
	public void setReleaseStatus(Short releaseStatus) {
		this.releaseStatus = releaseStatus;
	}


	/**
	 * @return the 模块分类名称
	 */
	public String getName() {
		return name;
	}
	


	/**
	 * @param 模块分类名称 the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
    
    
	
}
