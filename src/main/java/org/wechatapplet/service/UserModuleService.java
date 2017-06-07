package org.wechatapplet.service;

import java.util.Map;

import org.wechatapplet.model.Module;
import org.wechatapplet.model.UserModule;


/**
 * 用户模板业务层
 * @author lenovo
 */
public interface UserModuleService {

	public UserModule findUserModuleById(Long id);
	
	/**
	 * 使用模型
	 * @param module
	 * @param userId 
	 * @return
	 */
	public int addUserModule(Module module, Long userId);
	
	public Map<String, Object> getUserModelList(Map<String, Object> paras); 
	
	public int updateByPrimaryKeySelective(UserModule record);
}
