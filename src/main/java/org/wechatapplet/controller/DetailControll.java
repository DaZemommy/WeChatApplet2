package org.wechatapplet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wechatapplet.model.Detail;
import org.wechatapplet.model.ListResult;
import org.wechatapplet.model.User;
import org.wechatapplet.model.Zixun;
import org.wechatapplet.service.DetailService;
import org.wechatapplet.service.ZixunService;
import org.wechatapplet.utils.ImgUtils;
import org.wechatapplet.utils.StringUtil;


@Controller
@RequestMapping(value = "/detail")
public class DetailControll {

	@Autowired
	private DetailService detailService;
	
	@Autowired
	private ZixunService zixunService;
	
	
	@RequestMapping("/toDetail")
	public String toDetail(Detail detail,HttpServletRequest request){
		Zixun zixun = zixunService.findOne(detail.getDzid());
		request.setAttribute("zixun",zixun);
		return "detail";
	}
	
	
	@RequestMapping("/toAddDetail")
	public String toAddDetail(Detail detail,HttpServletRequest request){
		Zixun zixun = zixunService.findOne(detail.getDzid());
		request.setAttribute("zxn", zixun);
		return "adddetail";
	}
	
	/*
	 * 资讯详情分页
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public ListResult showList(int dzid,int pageNum,int pageSize,HttpServletRequest request) throws IOException{
		return detailService.showListNoQuery(pageNum, pageSize,dzid);
	}
	
	
	/**
	 * 资讯详情删除
	 */
	@RequestMapping("/delDetail")
	@ResponseBody
	public Boolean delDetail(Detail detail) throws IOException{
		try {
			detailService.delDetail(detail);
			return true;
		} catch (Exception e) {
			System.err.println("资讯删除失败");
			return false;
		}
	}
	
	@RequestMapping("/toEditDetail")
	public String toEditDetail(Detail detail,HttpServletRequest request){
		Detail exdetail = detailService.findOne(detail.getDid());
		Zixun zixun = zixunService.findOne(exdetail.getDzid());
		request.setAttribute("zxn1", zixun);
		request.setAttribute("dt", exdetail);
		return "editdetail";
	}
	
	@RequestMapping(value = "/addDetail", method={ RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public ModelAndView addDetail(@ModelAttribute Detail detail,HttpServletRequest request) throws IllegalStateException, IOException{
		Detail existDetail = detailService.findByDname(detail.getDname());
		if (existDetail==null) {
			if (detail.getContent()!=null) {
				List list = ImgUtils.getImageSrc(detail.getContent());
				if (list.size()>0) {
					String fpic = list.get(0).toString().substring(14);
					detail.setFpic(fpic);
					List picslist = new ArrayList<>();
					if (list.size()>1) {
						for (int i = 1; i < list.size(); i++) {
							picslist.add(list.get(i).toString().substring(14));
						}
						String pics = StringUtil.listToString(picslist, ',');
						detail.setPics(pics);
					}
				}
			}
			detailService.addDetail(detail);
		}
		return new ModelAndView("redirect:/detail/toDetail?dzid="+detail.getDzid());
	}
	
	
	
	@RequestMapping(value = "/editDetail", method={ RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public ModelAndView editDetail(@ModelAttribute Detail detail,HttpServletRequest request) throws IllegalStateException, IOException{
		if (detail.getContent()!=null) {
			List list = ImgUtils.getImageSrc(detail.getContent());
			if (list.size()>0) {
				String fpic = list.get(0).toString().substring(14);
				detail.setFpic(fpic);
				List picslist = new ArrayList<>();
				if (list.size()>1) {
					for (int i = 1; i < list.size(); i++) {
						picslist.add(list.get(i).toString().substring(14));
					}
					String pics = StringUtil.listToString(picslist, ',');
					detail.setPics(pics);
				}
			}
		}
		detailService.editDetail(detail);
		return new ModelAndView("redirect:/detail/toDetail?dzid="+detail.getDzid());
	}

	
	
	
	
	
}
