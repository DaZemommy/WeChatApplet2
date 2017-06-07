package org.wechatapplet.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wechatapplet.model.ListResult;
import org.wechatapplet.model.User;
import org.wechatapplet.model.Zixun;
import org.wechatapplet.service.ZixunService;

@Controller
@RequestMapping(value = "/zixun")
public class ZixunControll {

	@Autowired
	private ZixunService zixunService;
	
	/*
	 * 资讯分类分页
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public ListResult showList(int pageNum,int pageSize,@RequestParam(defaultValue="LaP49PitK95Chhpv4W9QF80Rx84n7Wk")String sousuo,HttpServletRequest request) throws IOException{
		User user = (User) request.getSession().getAttribute("existUser");
		Integer uid = user.getUid();
		if (!"LaP49PitK95Chhpv4W9QF80Rx84n7Wk".equals(sousuo)) {
			return zixunService.showList(pageNum,pageSize,sousuo,uid);
		}else{
			return zixunService.showListNoQuery(pageNum, pageSize,uid);
		}
		
	}
	
	/**
	 * 资讯分类删除
	 */
	@RequestMapping("/delZixun")
	@ResponseBody
	public Boolean delZixun(Zixun zixun) throws IOException{
		try {
			zixunService.delZixun(zixun);
			return true;
		} catch (Exception e) {
			System.err.println("资讯删除失败");
			return false;
		}
	}
	
	
	/*
	 * 资讯分类(添加)和(编辑)
	 */
	@RequestMapping("/addOrEditZixun")
	public String addZixun(Zixun zixun,HttpServletRequest request,HttpServletResponse response) throws IOException{
		User user = (User) request.getSession().getAttribute("existUser");
		zixun.setZuid(user.getUid());
		if (zixun.getZid()!=null) {
			zixunService.editZixun(zixun);
			return "index";
		}
		Zixun existZixun = zixunService.findReplace(zixun);
		//若存在重复资讯分类
		if (existZixun != null) {
			request.setAttribute("msg", "不能添加重复数据!");
			return "index";
		}
		try {
			zixunService.addZixun(zixun);
			request.setAttribute("msg", "添加成功!");
			return "index";
			
		} catch (Exception e) {
			request.setAttribute("msg", "添加失败!");
			return "index";
		}
		
	}
	
	
	
	
	

}
