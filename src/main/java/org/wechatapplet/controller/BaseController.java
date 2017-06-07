package org.wechatapplet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.wechatapplet.service.ModuleCateService;
import org.wechatapplet.service.ModuleService;
import org.wechatapplet.service.UserModuleService;
import org.wechatapplet.service.UserService;

public class BaseController {

	@Autowired
	protected UserService userService;
	@Autowired
	protected ModuleService moduleService;
	@Autowired
	protected ModuleCateService moduleCateService;
	@Autowired
	protected UserModuleService userModuleService;
	
	
	public boolean validateIsNotNull(Object obj,String key,String msg,Model model){
		if(obj == null || "".equals(obj)){
			model.addAttribute(key, msg);
			return false;
		}
		return true;
	}
}
