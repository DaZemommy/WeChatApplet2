package org.wechatapplet.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.wechatapplet.model.ModuleCate;
import org.wechatapplet.model.ModuleCateExample;
import org.wechatapplet.service.ModuleCateService;


@Service
public class ModuleCateServiceImpl extends BaseServiceImpl implements ModuleCateService {

	public List<ModuleCate> findModuleCates() {
		ModuleCateExample example = new ModuleCateExample();
		org.wechatapplet.model.ModuleCateExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo((short)1);
		LOG.info("查询所有模型分类数据，状态为："+ 1);
		List<ModuleCate> list = moduleCateDao.selectByExample(example);
		LOG.info("查询所有模型分类数据，结果为："+ list);
		return list;
	}

}
