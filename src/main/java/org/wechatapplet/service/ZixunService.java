package org.wechatapplet.service;

import org.wechatapplet.model.ListResult;
import org.wechatapplet.model.Zixun;


public interface ZixunService {

	ListResult showList(int pageNum, int pageSize,String sousuo, Integer uid);

	void delZixun(Zixun zixun);

	ListResult showListNoQuery(int pageNum, int pageSize, Integer uid);

	Zixun findReplace(Zixun zixun);

	void addZixun(Zixun zixun);

	void editZixun(Zixun zixun);

	Zixun findOne(Integer dzid);

	Object showZixunList(Integer pageNum, Integer pageSize, Integer uid);

}
