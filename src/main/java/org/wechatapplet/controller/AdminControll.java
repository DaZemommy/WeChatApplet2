package org.wechatapplet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wechatapplet.model.Admin;
import org.wechatapplet.service.AdminService;
import org.wechatapplet.utils.ValidateCode;

@Controller
@RequestMapping(value = "/admin")
public class AdminControll {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/getOtherList",produces="text/html;charset=UTF-8" ) 
	@ResponseBody
	private String getOtherList(){
		String json=adminService.getAdminList();
		return json;
	}
	
	@RequestMapping("/test2")  
    public String test2(Model model) {  
        return "/admin/test";  
    }   
	
	 @RequestMapping("/helloWorld")  
	    public ModelAndView helloWorld(ModelAndView mv) {  
	        String message = "欢迎你的到来！";  
	        mv = new ModelAndView("/admin/test", "message", message);  
	       return mv;  
	    } 
	 
	//跳转到登陆页面
		@RequestMapping("/adminLogin")
		public String toLogin(){
			return "/admin/login";
		}
		
		 /** 
	     * 响应验证码页面 
	     * @return 
	     */  
	    @RequestMapping(value="/validateCode")  
	    public String validateCode(HttpServletRequest request,HttpServletResponse response) throws Exception{  
	        // 设置响应的类型格式为图片格式  
	        response.setContentType("image/jpeg");  
	        //禁止图像缓存。  
	        response.setHeader("Pragma", "no-cache");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setDateHeader("Expires", 0);  
	      
	        HttpSession session = request.getSession();  
	      
	        ValidateCode vCode = new ValidateCode(100,40,4,100);  
	        session.setAttribute("code", vCode.getCode());  
	        vCode.write(response.getOutputStream());  
	        return null;  
	    }  
	    
	  //用户登陆
		@RequestMapping("/login") 
		public String login(Admin admin,HttpServletRequest request){
		    String code = request.getParameter("code");  
		    HttpSession session = request.getSession();  
		    String sessionCode = (String) session.getAttribute("code");  
		    if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {  //忽略验证码大小写  
		        //throw new RuntimeException("验证码对应不上code=" + code + "  sessionCode=" + sessionCode);
		    	request.setAttribute("msg", "验证码有误!");
		    	return "forward:/admin/adminLogin";
		    }  
			
			
			Admin existUser = adminService.login(admin);
			//如果existUser不为空,登陆成功
			if (existUser == null) {
				request.setAttribute("msg", "用户名或密码错误!");
				return "forward:/admin/adminLogin";
			}
			request.setAttribute("existUser", existUser);
			return "/admin/index";
		}
		@RequestMapping("/createApplets")
		public String createApplets(){
			
		  return "/admin/createApplets";
			
		}
}
