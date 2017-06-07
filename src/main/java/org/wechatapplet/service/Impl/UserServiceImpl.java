package org.wechatapplet.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wechatapplet.dao.UserDao;
import org.wechatapplet.model.User;
import org.wechatapplet.model.UserExample;
import org.wechatapplet.model.UserExample.Criteria;
import org.wechatapplet.service.UserService;
@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 用户登陆
	 */
	@Override
	public User login(User user) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPasswordEqualTo(user.getPassword());
		List<User> userList = userDao.selectByExample(userExample);
		List<User> list = userDao.selectByExample(new UserExample());
		if (userList!=null && userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public int countByExample(UserExample example) {
		// TODO Auto-generated method stub
		return userDao.countByExample(example);
	}

	@Override
	public int insertSelective(User user) {
		// TODO Auto-generated method stub
		return userDao.insertSelective(user);
	}


	
	
	

}
