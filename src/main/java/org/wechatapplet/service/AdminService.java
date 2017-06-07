package org.wechatapplet.service;

import org.wechatapplet.model.Admin;

public interface AdminService {
	
	public String getAdminList();  
	
	Admin selectByPrimaryKey(Integer id);
	
	Admin login(Admin admin);

}
