package org.wechatapplet.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wechatapplet.dao.ZixunDao;
import org.wechatapplet.model.Detail;
import org.wechatapplet.model.ListResult;
import org.wechatapplet.model.Zixun;
import org.wechatapplet.model.ZixunExample;
import org.wechatapplet.model.ZixunExample.Criteria;
import org.wechatapplet.service.ZixunService;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("ZixunService")
public class ZixunServiceImpl<V> implements ZixunService {

	@Autowired
	private ZixunDao zixunDao;

	/**
	 * 资讯分类分页(有条件查询)
	 */
	@Override
	public ListResult showList(int pageNum, int pageSize,String sousuo, Integer uid) {
		PageHelper.startPage(pageNum+1, pageSize);
		ZixunExample zixunExample = new ZixunExample();
		Criteria criteria = zixunExample.createCriteria();
		criteria.andZuidEqualTo(uid);
		criteria.andZnameLike("%"+sousuo+"%");
		List<Zixun> list = zixunDao.selectByExample(zixunExample);
		PageInfo<Zixun> pageInfo = new PageInfo<Zixun>(list);
		ListResult listResult = new ListResult();
		listResult.setList(pageInfo.getList());
		listResult.setTotal((int)pageInfo.getTotal());
		return listResult;
	}

	/**
	 * 资讯分类分页(无查询条件)
	 */
	@Override
	public ListResult showListNoQuery(int pageNum, int pageSize, Integer uid) {
		PageHelper.startPage(pageNum+1, pageSize);
		ZixunExample zixunExample = new ZixunExample();
		Criteria criteria = zixunExample.createCriteria();
		criteria.andZuidEqualTo(uid);
		List<Zixun> list = zixunDao.selectByExample(zixunExample);
		PageInfo<Zixun> pageInfo = new PageInfo<Zixun>(list);
		ListResult listResult = new ListResult();
		listResult.setList(pageInfo.getList());
		listResult.setTotal((int)pageInfo.getTotal());
		return listResult;
	}
	
	
	/**
	 * 删除资讯分类
	 */
	@Override
	public void delZixun(Zixun zixun) {
		ZixunExample zixunExample = new ZixunExample();
		Criteria criteria = zixunExample.createCriteria();
		criteria.andZnameEqualTo(zixun.getZname());
		zixunDao.deleteByExample(zixunExample);
	}

	/**
	 * 资讯添加判断重复
	 */
	
	@Override
	public Zixun findReplace(Zixun zixun) {
		ZixunExample zixunExample = new ZixunExample();
		Criteria criteria = zixunExample.createCriteria();
		criteria.andZuidEqualTo(zixun.getZuid());
		criteria.andZnameEqualTo(zixun.getZname());
		List<Zixun> list = zixunDao.selectByExample(zixunExample);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 添加资讯分类
	 */
	@Override
	public void addZixun(Zixun zixun) {
		zixunDao.insert(zixun);
	}

	@Override
	public void editZixun(Zixun zixun) {
		zixunDao.updateByPrimaryKey(zixun);
	}

	@Override
	public Zixun findOne(Integer dzid) {
		 return zixunDao.selectByPrimaryKey(dzid);
	}


	/**
	 * 资讯分类接口
	 * @return 
	 */
	public Object showZixunList(Integer pageNum, Integer pageSize, Integer uid){
		PageHelper.startPage(pageNum, pageSize);
		ZixunExample zixunExample = new ZixunExample();
		Criteria criteria = zixunExample.createCriteria();
		criteria.andZuidEqualTo(uid);
		List<Zixun> list = zixunDao.selectByExample(zixunExample);
		PageInfo<Zixun> pageInfo = new PageInfo<Zixun>(list);
		HashMap<Object,Object> mapJSON = new HashMap<Object, Object>();
		mapJSON.put("data", pageInfo);
		return JSON.toJSON(mapJSON);
	}
	
	
	

}
