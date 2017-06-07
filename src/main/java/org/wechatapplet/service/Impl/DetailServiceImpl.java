package org.wechatapplet.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wechatapplet.dao.DetailDao;
import org.wechatapplet.model.Detail;
import org.wechatapplet.model.DetailExample;
import org.wechatapplet.model.ZixunExample;
import org.wechatapplet.model.DetailExample.Criteria;
import org.wechatapplet.model.ListResult;
import org.wechatapplet.service.DetailService;
import org.wechatapplet.utils.ImgUtils;
import org.wechatapplet.utils.StringUtil;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("DetailService")
public class DetailServiceImpl implements DetailService{

	@Autowired
	private DetailDao detailDao;
	
	
	/**
	 * 资讯详情分页(无查询条件)
	 */
	@Override
	public ListResult showListNoQuery(int pageNum, int pageSize, int dzid) {
		PageHelper.startPage(pageNum+1, pageSize);
		DetailExample detailExample = new DetailExample();
		Criteria criteria = detailExample.createCriteria();
		criteria.andDzidEqualTo(dzid);
		List<Detail> list = detailDao.selectByExampleWithBLOBs(detailExample);
		PageInfo<Detail> pageInfo = new PageInfo<Detail>(list);
		ListResult listResult = new ListResult();
		List<Detail> list2 = pageInfo.getList();
		for (Detail detail : list2) {
			if (detail.getPics()!=null) {
				String pics = detail.getPics();
				if (StringUtils.containsAny(pics, ',')) {
					detail.setPics(pics.split(",")[0]);
				}
			}
		}
		listResult.setList(list2);
		listResult.setTotal((int)pageInfo.getTotal());
		return listResult;
	}
	
	@Override
	public ListResult showListByApi(int pageNum, int pageSize, int dzid,int userid) {
		PageHelper.startPage(pageNum+1, pageSize);
		DetailExample detailExample = new DetailExample();
		Criteria criteria = detailExample.createCriteria();
		criteria.andDzidEqualTo(dzid);
		List<Detail> list = detailDao.selectByExampleWithBLOBs(detailExample);
		PageInfo<Detail> pageInfo = new PageInfo<Detail>(list);
		ListResult listResult = new ListResult();
		List<Detail> list2 = pageInfo.getList();
		listResult.setList(list2);
		listResult.setTotal((int)pageInfo.getTotal());
		return listResult;
	}


	@Override
	public void delDetail(Detail detail) {
		DetailExample detailExample = new DetailExample();
		Criteria criteria = detailExample.createCriteria();
		criteria.andDnameEqualTo(detail.getDname());
		criteria.andPicsEqualTo(detail.getPics());
		detailDao.deleteByExample(detailExample);
	}


	@Override
	public Detail findOne(Integer did) {
		return detailDao.selectByPrimaryKey(did);
	}


	@Override
	public void addDetail(Detail detail) {
		detailDao.insert(detail);
	}


	@Override
	public void editDetail(Detail detail) {
		detailDao.updateByPrimaryKeySelective(detail);
	}


	@Override
	public Detail findByDname(String dname) {
		DetailExample detailExample = new DetailExample();
		Criteria criteria = detailExample.createCriteria();
		criteria.andDnameEqualTo(dname);
		List<Detail> list = detailDao.selectByExample(detailExample);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Object showDetailList(Integer pageNum, Integer pageSize, Integer zid) {
		PageHelper.startPage(pageNum, pageSize);
		DetailExample detailExample = new DetailExample();
		Criteria criteria = detailExample.createCriteria();
		criteria.andDzidEqualTo(zid);
		List<Detail> list = detailDao.selectByExampleWithBLOBs(detailExample);
		PageInfo<Detail> pageInfo = new PageInfo<Detail>(list);
		HashMap<Object,Object> mapJSON = new HashMap<Object, Object>();
		mapJSON.put("data", pageInfo);
		return JSON.toJSON(mapJSON);
	}

	@Override
	public Object showDetail(Integer did) {
		Detail detail = detailDao.selectByPrimaryKey(did);
		HashMap<Object,Object> mapJSON = new HashMap<Object, Object>();
		mapJSON.put("data", detail);
		return JSON.toJSON(mapJSON);
	}

	
	
	
	
	
	
	
	
	
}
