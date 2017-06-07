package org.wechatapplet.service;

import org.wechatapplet.model.User;
import org.wechatapplet.model.UserExample;

public interface UserService {

	User login(User user);

	int countByExample(UserExample example);

	int insertSelective(User user);
}
