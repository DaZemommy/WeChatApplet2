package org.wechatapplet.service;

import java.util.List;

import org.wechatapplet.model.ModuleCate;


/**
 * 模块分类业务层
 * @author lenovo
 */
public interface ModuleCateService {

	public List<ModuleCate> findModuleCates();
	
}
