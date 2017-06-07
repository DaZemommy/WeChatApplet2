package org.wechatapplet.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.wechatapplet.dao.ModuleCateDao;
import org.wechatapplet.dao.ModuleDao;
import org.wechatapplet.dao.UserModuleDao;


/**
 * 基业务层接口类
 * @author lenovo
 */
public class BaseServiceImpl {
	
	/**
	 * 固定掩值
	 */
	public static final String SALT = "TX_WXAPPLET_";
	
	/**
	 * 日志对象
	 */
	protected Logger LOG = Logger.getLogger(BaseServiceImpl.class);
	
	@Autowired
	protected UserModuleDao UserModuleDao;
	@Autowired
	protected ModuleDao moduleDao;
	@Autowired
	protected ModuleCateDao moduleCateDao;
	@Autowired
	protected UserModuleDao userModuleDao;
	

}
