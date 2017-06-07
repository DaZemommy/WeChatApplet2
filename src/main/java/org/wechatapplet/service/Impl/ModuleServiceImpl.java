package org.wechatapplet.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.wechatapplet.model.Module;
import org.wechatapplet.model.ModuleExample;
import org.wechatapplet.model.ModuleExample.Criteria;
import org.wechatapplet.service.ModuleService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ModuleServiceImpl extends BaseServiceImpl implements ModuleService {

	public PageInfo<Module> findModuleByUserId(Long userId,int pageSize,int pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		LOG.info("根据用户ID查询用户模型数据，参数为："+ userId);
		List<Module> modules = moduleDao.selectByUserId(userId);
		LOG.info("根据用户ID查询用户模型数据，结果为："+ modules);
		PageInfo<Module> pageInfo = new PageInfo<Module>(modules);
		return pageInfo;
	}

	public PageInfo<Module> findModules(int pageSize, int pageNum, Long cateId) {
		LOG.info("根据分类ID查询模型数据，参数为："+ cateId);
		PageHelper.startPage(pageNum, pageSize);
		List<Module> list = moduleDao.selectByCateId(cateId);
		LOG.info("根据分类ID查询模型数据，结果为："+ list);
		PageInfo<Module> pageInfo = new PageInfo<Module>(list);
		return pageInfo;
	}

	public Module findModuleById(Long moduleId) {
		LOG.info("根据模型ID查询模型数据，参数为："+ moduleId);
		Module module = moduleDao.selectByPrimaryKey(moduleId);
		LOG.info("根据模型ID查询模型数据，结果为："+ module);
		return module;
	}

	@Override
	public Map<String, Object> findModules(Map<String, Object> paras) {
		ModuleExample example = new ModuleExample();
		Criteria criteria = example.or();
		if((long) paras.get("cateId")>0){
			criteria.andCateIdEqualTo((long) paras.get("cateId"));
		}
		if(paras.get("keywords").toString().trim().length()>0){
			criteria.andModuleNameLike(paras.get("keywords").toString());
		}
		Long cateId = (long) paras.get("cateId");
		LOG.info("根据分类ID查询模型数据，参数为："+ cateId);
		PageHelper.startPage((Integer)paras.get("pageNum"), (Integer)paras.get("pageSize"));
//		List<Module> list = moduleDao.selectByCateId(cateId);
		List<Module> list = moduleDao.selectByExample(example);
		LOG.info("根据分类ID查询模型数据，结果为："+ list);
		PageInfo<Module> page = new PageInfo<Module>(list);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", page);
		return result;
	
	}

}
