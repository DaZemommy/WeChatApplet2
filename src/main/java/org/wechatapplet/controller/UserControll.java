package org.wechatapplet.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wechatapplet.model.User;
import org.wechatapplet.service.UserService;
import org.wechatapplet.service.ZixunService;
import org.wechatapplet.utils.ValidateCode;



@Controller
@RequestMapping(value = "/user")
public class UserControll {

	@Autowired
	private UserService userService;
	
	
	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
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
	public String login(User user,HttpServletRequest request){
	    String code = request.getParameter("code");  
	    HttpSession session = request.getSession();  
	    String sessionCode = (String) session.getAttribute("code");  
	    if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {  //忽略验证码大小写  
	        //throw new RuntimeException("验证码对应不上code=" + code + "  sessionCode=" + sessionCode);
	    	request.setAttribute("msg", "验证码有误!");
	    	return "forward:/user/toLogin";
	    }
	    
		User existUser = userService.login(user);
		//如果existUser不为空,登陆成功
		if (existUser == null) {
			request.setAttribute("msg", "用户名或密码错误!");
			return "forward:/user/toLogin";
		}
		session.setAttribute("existUser", existUser);
		session.setMaxInactiveInterval(30*60*3);
		return "redirect:/index.jsp";
	}
	
	
	
	/**
	 * 跳转到认证登陆页面
	 * @return
	 */
	@RequestMapping("/torzLogin")
	public String torzLogin(){
		return "renzheng/login";
	}
	
	/**
	 * 认证登陆
	 */
	@RequestMapping("/rzLogin")
	public String rzLogin(User user,HttpServletRequest request){
		if (user.getUsername() != null && user.getUsername() != "") {
			String username = user.getUsername();
			if (username.equals("admin1")|| username.equals("admin2")) {
				User login = userService.login(user);
				if (login != null) {
					return "renzheng/list";
				}
			}
		}
		request.setAttribute("rzmsg", "用户名或密码错误!");
		return "renzheng/login";
	}
	
	@RequestMapping("/testFile")
	public String test(){
	
		return "test.jsp";
	}
	
	
}
