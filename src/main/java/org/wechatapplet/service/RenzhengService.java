package org.wechatapplet.service;

import org.wechatapplet.model.ListResult;
import org.wechatapplet.model.Renzheng;

public interface RenzhengService {

	void addRenzheng(Renzheng renzheng);

	ListResult showList(int pageNum, int pageSize, String sousuo);

	ListResult showListNoQuery(int pageNum, int pageSize);

	void delRenzheng(Renzheng renzheng);

	Renzheng findOne(Renzheng renzheng);

	void editRenzheng(Renzheng renzheng);

}
