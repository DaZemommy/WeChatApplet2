package org.wechatapplet.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wechatapplet.model.ListResult;
import org.wechatapplet.service.DetailService;
import org.wechatapplet.service.ZixunService;

@Controller
@RequestMapping(value = "/api")
public class NewsAPIController {
	
	
	@Autowired
	private ZixunService zixunService;
	
	@Autowired
	private DetailService detailService;
	
	
	@RequestMapping("/newsCataList")
	@ResponseBody
	public ListResult newsCataList(int pageNum,int pageSize,HttpServletRequest request,Integer uid) throws IOException{
		return zixunService.showListNoQuery(pageNum, pageSize,uid);
		
	}
	
	@RequestMapping("/newsList")
	@ResponseBody
	public ListResult newsList(int dzid,int pageNum,int pageSize,HttpServletRequest request) throws IOException{
		return detailService.showListNoQuery(pageNum, pageSize,dzid);
	}
	
	@RequestMapping("/newsListByApi")
	@ResponseBody
	public ListResult newsList(int dzid,int pageNum,int pageSize,HttpServletRequest request,int userid) throws IOException{
		return detailService.showListByApi(pageNum, pageSize,dzid,userid);
	}
	
	/**
	 * 资讯分类接口
	 * @return 
	 */
	@RequestMapping("/showZixunList")
	@ResponseBody
	public Object showZixunList(Integer pageNum, Integer pageSize, Integer uid){
		return zixunService.showZixunList(pageNum, pageSize, uid);
	}
	
	/**
	 * 资讯详情接口(返回对应分类下的所有资讯详情)
	 */
	@RequestMapping("/showDetailList")
	@ResponseBody
	public Object showDetailList(Integer pageNum, Integer pageSize, Integer zid){
		return detailService.showDetailList(pageNum, pageSize, zid);
	}
	
	/**
	 * 根据资讯详情did返回对应的资讯详情对象
	 */
	@RequestMapping("/showDetail")
	@ResponseBody
	public Object showDetail(Integer did){
		return detailService.showDetail(did);
	}
	

}
