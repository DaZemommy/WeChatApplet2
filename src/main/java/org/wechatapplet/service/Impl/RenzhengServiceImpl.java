package org.wechatapplet.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wechatapplet.dao.RenzhengDao;
import org.wechatapplet.model.ListResult;
import org.wechatapplet.model.Renzheng;
import org.wechatapplet.model.RenzhengExample;
import org.wechatapplet.model.RenzhengExample.Criteria;
import org.wechatapplet.service.RenzhengService;
import org.wechatapplet.utils.RandomUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service("RenzhengService")
public class RenzhengServiceImpl implements RenzhengService {

	@Autowired
	private RenzhengDao renzhengDao;

	@Override
	public void addRenzheng(Renzheng renzheng) {
		String rKey = "XCX"+RandomUtil.getResult();
		RenzhengExample renzhengExample = new RenzhengExample();
		Criteria criteria = renzhengExample.createCriteria();
		criteria.andRkeyEqualTo(rKey);
		List<Renzheng> list = renzhengDao.selectByExample(renzhengExample);
		if (list.size()>0) {
			renzheng.setRkey("XCX"+RandomUtil.getResult());
			renzhengDao.insert(renzheng);
		}
		//自动生成证书
		renzheng.setRkey(rKey);
		renzhengDao.insert(renzheng);
	}
	
	/**
	 * 认证显示(有条件)
	 */
	@Override
	public ListResult showList(int pageNum, int pageSize, String sousuo) {
		PageHelper.startPage(pageNum+1, pageSize);
		RenzhengExample renzhengExample = new RenzhengExample();
		Criteria criteria = renzhengExample.createCriteria();
		criteria.andRnameLike("%"+sousuo+"%");
		List<Renzheng> list = renzhengDao.selectByExample(renzhengExample);
		if (list.size()>0) {
			PageInfo<Renzheng> pageInfo = new PageInfo<Renzheng>(list);
			pageInfo.setList(list);
			ListResult listResult = new ListResult();
			listResult.setList(pageInfo.getList());
			listResult.setTotal((int)pageInfo.getTotal());
			return listResult;
		}
		return showList2(pageNum, pageSize, sousuo);
	}
	//模糊查询证书(上面方法的子方法)
	public ListResult showList2(int pageNum, int pageSize, String sousuo) {
		PageHelper.startPage(pageNum+1, pageSize);
		RenzhengExample renzhengExample = new RenzhengExample();
		Criteria criteria = renzhengExample.createCriteria();
		criteria.andRkeyLike("%"+sousuo+"%");
		List<Renzheng> list = renzhengDao.selectByExample(renzhengExample);
		if (list.size()>0) {
			PageInfo<Renzheng> pageInfo = new PageInfo<Renzheng>(list);
			pageInfo.setList(list);
			ListResult listResult = new ListResult();
			listResult.setList(pageInfo.getList());
			listResult.setTotal((int)pageInfo.getTotal());
			return listResult;
		}
		return null;
	}
	

	/**
	 * 认证显示(无条件)
	 */
	@Override
	public ListResult showListNoQuery(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum+1, pageSize);
		RenzhengExample renzhengExample = new RenzhengExample();
		List<Renzheng> list = renzhengDao.selectByExample(renzhengExample);
		PageInfo<Renzheng> pageInfo = new PageInfo<Renzheng>(list);
		ListResult listResult = new ListResult();
		listResult.setList(pageInfo.getList());
		listResult.setTotal((int)pageInfo.getTotal());
		return listResult;
	}

	@Override
	public void delRenzheng(Renzheng renzheng) {
		RenzhengExample renzhengExample = new RenzhengExample();
		Criteria criteria = renzhengExample.createCriteria();
		criteria.andRnameEqualTo(renzheng.getRname());
		renzhengDao.deleteByExample(renzhengExample);
	}

	@Override
	public Renzheng findOne(Renzheng renzheng) {
		RenzhengExample renzhengExample = new RenzhengExample();
		Criteria criteria = renzhengExample.createCriteria();
		criteria.andRnameEqualTo(renzheng.getRname());
		List<Renzheng> list = renzhengDao.selectByExample(renzhengExample);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void editRenzheng(Renzheng renzheng) {
		renzhengDao.updateByPrimaryKeySelective(renzheng);
	}
	
	
	
}
