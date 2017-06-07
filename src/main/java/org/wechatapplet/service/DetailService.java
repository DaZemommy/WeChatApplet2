package org.wechatapplet.service;

import org.wechatapplet.model.Detail;
import org.wechatapplet.model.ListResult;

public interface DetailService {

	ListResult showListNoQuery(int pageNum, int pageSize, int dzid);

	void delDetail(Detail detail);

	Detail findOne(Integer did);

	void addDetail(Detail detail);

	void editDetail(Detail detail);

	Detail findByDname(String dname);
	
	ListResult showListByApi(int pageNum, int pageSize, int dzid,int userid);

	Object showDetailList(Integer pageNum, Integer pageSize, Integer zid);

	Object showDetail(Integer did);

}
