package org.wechatapplet.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wechatapplet.dao.AdminDao;
import org.wechatapplet.model.Admin;
import org.wechatapplet.model.AdminExample;
import org.wechatapplet.model.AdminExample.Criteria;
import org.wechatapplet.service.AdminService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

@Service("AdminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;

	public String getAdminList() {
		Set<String> set=new HashSet<String>();
		System.out.println("11111");
		List<Admin> list=adminDao.selectAdminList();
		System.out.println("list===="+list.size());
		return JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
	}

	public Admin selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return (Admin) adminDao.selectByPrimaryKey(id);
	}

	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(admin.getUsername());
		criteria.andPasswordEqualTo(admin.getPassword());
		List<Admin> list = adminDao.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	

}
