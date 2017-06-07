package org.wechatapplet.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.wechatapplet.model.Module;
import org.wechatapplet.model.UserModule;
import org.wechatapplet.model.UserModuleExample;
import org.wechatapplet.model.UserModuleExample.Criteria;
import org.wechatapplet.service.UserModuleService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserModuleServiceImpl extends BaseServiceImpl implements UserModuleService {

	public UserModule findUserModuleById(Long id) {
		LOG.info("根据ID查询用户模型数据，参数为："+ id);
		try {
			UserModule userModule = userModuleDao.selectById(id);
			LOG.info("根据ID查询用户模型数据，结果为："+ userModule);
			return userModule;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addUserModule(Module module, Long userId) {
		LOG.debug("新增用户模型数据，参数为："+ module+","+userId);
		UserModule userModule = new UserModule();
		userModule.setCreateTime(new Date());
		userModule.setFilePath(module.getFilePath());
		userModule.setModuleId(module.getId());
		userModule.setUserId(userId);
//		int row = userModuleDao.insertSelective(userModule);
		int row = userModuleDao.insert(userModule);
		LOG.debug("新增用户模型数据，结果为："+ row);
		return row;
	}

	@Override
	public Map<String, Object> getUserModelList(Map<String, Object> paras) {
		// TODO Auto-generated method stub
		UserModuleExample example = new UserModuleExample();
		Criteria criteria = example.or();
		example.setOrderByClause("id DESC");
		if(paras.get("keywords").toString().trim().length()>0){
			criteria.andApplyNameLike(paras.get("keywords").toString());
		}
		PageHelper.startPage((Integer)paras.get("pageNum"), (Integer)paras.get("pageSize"));
		List<UserModule> aList = userModuleDao.selectByExample(example);
		PageInfo<UserModule> page = new PageInfo<UserModule>(aList);
		System.out.println("aList===="+aList.size());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", page);
		return result;
	
	}

	@Override
	public int updateByPrimaryKeySelective(UserModule record) {
		// TODO Auto-generated method stub
		return userModuleDao.updateByPrimaryKeySelective(record);
	}

}
