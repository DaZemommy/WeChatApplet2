package org.wechatapplet.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wechatapplet.model.ListResult;
import org.wechatapplet.model.Renzheng;
import org.wechatapplet.model.User;
import org.wechatapplet.model.Zixun;
import org.wechatapplet.service.RenzhengService;

@Controller
@RequestMapping("/renzheng")
public class RenzhengControll {

	@Autowired
	private RenzhengService renzhengService;
	
	@RequestMapping("/addRenzheng")
	@ResponseBody
	public Boolean addRenzheng(Renzheng renzheng){
		//判断有没有重复的公司名称
		Renzheng existRenzheng = renzhengService.findOne(renzheng);
		if (existRenzheng==null) {
			try {
				renzhengService.addRenzheng(renzheng);
				return true;
			} catch (Exception e) {
				//发生异常添加失败
				return false;
			}
		}
		return false;
		
	}
	
	
	
	/**
	 * 认证公司分页显示
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public ListResult showList(int pageNum,int pageSize,@RequestParam(defaultValue="LaP49PitK95Chhpv4W9QF80Rx84n7Wk")String sousuo,HttpServletRequest request) throws IOException{
		if (!"LaP49PitK95Chhpv4W9QF80Rx84n7Wk".equals(sousuo)) {
			return renzhengService.showList(pageNum,pageSize,sousuo);
		}else{
			return renzhengService.showListNoQuery(pageNum, pageSize);
		}
		
	}
	
	
	/**
	 * 认证公司删除
	 */
	@RequestMapping("/delRenzheng")
	@ResponseBody
	public Boolean delRenzheng(Renzheng renzheng) throws IOException{
		try {
			renzhengService.delRenzheng(renzheng);
			return true;
		} catch (Exception e) {
			System.err.println("资讯删除失败");
			return false;
		}
	}
	
	
	/**
	 * 认证公司编辑
	 */
	@RequestMapping("/editRenzheng")
	@ResponseBody
	public Boolean editRenzheng(Renzheng renzheng){
		Renzheng existRenzheng = renzhengService.findOne(renzheng);
		if (existRenzheng==null) {
			try {
				renzhengService.editRenzheng(renzheng);
				return true;
			} catch (Exception e) {
				//发生异常添加失败
				return false;
			}
		}
		return false;
	}
	
	
	
}
