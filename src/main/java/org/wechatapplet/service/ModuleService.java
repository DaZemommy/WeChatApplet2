package org.wechatapplet.service;

import java.util.Map;

import org.wechatapplet.model.Module;

import com.github.pagehelper.PageInfo;

/**
 * 模块业务层接口
 * @author lenovo
 */
public interface ModuleService {

	/**
	 * 根据用户id，查询用户所拥有的模块
	 * @param userId
	 * @return
	 */
	public PageInfo<Module> findModuleByUserId(Long userId,int pageSize,int pageNum);
	/**
	 * 查询所有的模块
	 * @param userId
	 * @return
	 */
	public PageInfo<Module> findModules(int pageSize,int pageNum,Long cateId);
	public Map<String, Object> findModules(Map<String, Object> paras); 
	
	
	/**
	 * 根据模块ID查询模块
	 * @param userId
	 * @return
	 */
	public Module findModuleById(Long moduleId);
	
}
