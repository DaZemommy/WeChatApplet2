package org.wechatapplet.model;

public class UserModuleExtend {

	/**
	 * 模版名称
	 */
	private String moduleName;
	
	/**
	 * 模板分类名称
	 */
	private String cateName;
	
	/**
	 * 模板位置路径
	 */
	private String filePath;

	/**
	 * @return the 模版名称
	 */
	public String getModuleName() {
		return moduleName;
	}
	

	/**
	 * @param 模版名称 the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	

	/**
	 * @return the 模板分类名称
	 */
	public String getCateName() {
		return cateName;
	}
	

	/**
	 * @param 模板分类名称 the cateName to set
	 */
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	

	/**
	 * @return the 模板位置路径
	 */
	public String getFilePath() {
		return filePath;
	}
	

	/**
	 * @param 模板位置路径 the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
