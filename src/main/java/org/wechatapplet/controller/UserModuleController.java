package org.wechatapplet.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wechatapplet.model.UserExample.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.wechatapplet.model.Module;
import org.wechatapplet.model.User;
import org.wechatapplet.model.UserExample;
import org.wechatapplet.model.UserModule;

import com.alibaba.fastjson.JSON;



/**
 * 用户模块控制层
 * @author lenovo
 */
@Controller
@RequestMapping(value = "/userModule")
public class UserModuleController extends BaseController{

	@RequestMapping(value="addNewWxappletIndex.htm",method=RequestMethod.GET)
	public String addNewWxappletIndex(HttpServletRequest request,Model model){
		return null;
		
	}
	
	
	@RequestMapping(value="editWxappletIndex.htm",method=RequestMethod.GET)
	public String editWxappletIndex(HttpServletRequest request,Model model,Long userModuleId){
		return null;
		
	}
	
	/***
	 * 获取用户模板列表
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/getUserModuleList")
	@ResponseBody
	public Map<String,Object> getUserModuleList(
			@RequestParam(value="pageSize", defaultValue="0") Integer pageSize,//总页数
			@RequestParam(value="pageNum", defaultValue="0") Integer pageNum, //当前页数
			@RequestParam(value="keywords", defaultValue="") String keywords
			) {//每页个数
		Map<String,Object> result = new HashMap<String, Object>();
		int ok = -1;
		int code = 500;
		String msg = "请求失败";
		try {
			Map<String, Object> paras = new HashMap<String, Object>();
			paras.put("pageSize", pageSize);
			paras.put("pageNum", pageNum);
			paras.put("keywords", keywords);
			result = userModuleService.getUserModelList(paras);
			ok = 1;
			code = 200;
			msg = "请求成功";
		} catch (Exception e) {
		} finally {
			result.put("ok", ok);
			result.put("code", code);
			result.put("msg", msg);
		}
		return result;
	}
	
	/***
	 * 获取模板列表
	 * @param pageSize
	 * @param pageNum
	 * @param cateId
	 * @param keywords
	 * @return
	 */
	@RequestMapping("/getModuleList")
	@ResponseBody
	public Map<String,Object> getModuleList(
			@RequestParam(value="pageSize", defaultValue="0") Integer pageSize,//总页数
			@RequestParam(value="pageNum", defaultValue="0") Integer pageNum, //当前页数
			@RequestParam(value="cateId", defaultValue="0") Long cateId,
			@RequestParam(value="keywords", defaultValue="") String keywords
			) {
			Map<String,Object> result = new HashMap<String, Object>();
			Map<String, Object> paras = new HashMap<String, Object>();
			paras.put("pageSize", pageSize);
			paras.put("pageNum", pageNum);
			paras.put("cateId", cateId);
			paras.put("keywords", keywords);
//			result = userModuleService.getUserModelList(paras);
			result = moduleService.findModules(paras);
		return result;
	}
	
	/***
	 * 创建用户
	 * @param request
	 * @return
	 */
	@RequestMapping( value="/addUser"  , produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String,Object> addUser(HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String, Object>();
		int ok = -1;
		int code = 500;
		String msg = "请求失败";
		User user = new User();
		try {
			int num=ServletRequestUtils.getIntParameter(request, "num",0);//合同年限
			String customerName = ServletRequestUtils.getStringParameter(request, "customerName", ""); //客户姓名
			String telephone = ServletRequestUtils.getStringParameter(request, "telephone", "");//联系方式
			String orderid = ServletRequestUtils.getStringParameter(request, "orderid", "");//合同编号
			String keyword = ServletRequestUtils.getStringParameter(request, "keyword", "");//小程序关键词/名称
			String username = ServletRequestUtils.getStringParameter(request, "username", "");
			String password = ServletRequestUtils.getStringParameter(request, "password", "");
			int templateid=ServletRequestUtils.getIntParameter(request, "templateid",1);//模板id
			String name = ServletRequestUtils.getStringParameter(request, "name", "");
			
			
			UserExample userExample=new UserExample();  
	        Criteria conditionCri = userExample.createCriteria();  
	        conditionCri.andUsernameEqualTo(username);       
	        int count=userService.countByExample(userExample); 
			if(count>0){
				msg="用户名已存在!";
		        user=null;
			}else{
				user.setUsername(username);
				user.setPassword(password);
				user.setNum(num);
				user.setOrderid(orderid);
				user.setTelephone(telephone);
				user.setTemplateid(templateid);
				user.setKeyword(keyword);
				user.setCustomername(customerName);
				user.setName(name);
				int a = userService.insertSelective(user);
				if(a>0){
					code=200;
					ok=1;
					msg="添加成功";
				}else{
					code=500;
					ok=-1;
					msg="添加失败";
				}
			}
			
			
		} catch (Exception e) {
		} finally {
			result.put("ok", ok);
			result.put("code", code);
			result.put("msg", msg);
			result.put("data", user);
		}
		return result;
	}
	
	/***
	 * 增加用户模板
	 * @param request
	 * @return
	 */
	@RequestMapping( value="/addModule"  , produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String,Object> addModule(HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String, Object>();
		int ok = -1;
		int code = 500;
		String msg = "请求失败";
		Long moduleId=ServletRequestUtils.getLongParameter(request, "moduleId",1);//模板id
		Long userId=ServletRequestUtils.getLongParameter(request, "userId",1);
		Module module = moduleService.findModuleById(moduleId);
		try {
			
			//User user = (User) request.getSession().getAttribute(MessageConstants.USER_SESSION_KEY);
			int row = userModuleService.addUserModule(module,userId);
			System.out.println("row="+row);
			if(row > 0){
				msg="添加模板成功";
				code = 200;
				ok = 1;
			}else{
				msg="添加模板失败！";
				module=null;
				code = 500;
				ok = -1;
			}
			
			
		} catch (Exception e) {
		} finally {
			result.put("ok", ok);
			result.put("code", code);
			result.put("msg", msg);
			//result.put("data", module);
		}
		return result;
	}
	
	/***
	 * 更新用户模板
	 * @param request
	 * @return
	 */
	@RequestMapping( value="/updateUserModule"  , produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String,Object> updateUserModule(HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String, Object>();
		int ok = -1;
		int code = 500;
		String msg = "请求失败";
		try {
			Long moduleId=ServletRequestUtils.getLongParameter(request, "moduleId",0);
			String attrs = ServletRequestUtils.getStringParameter(request, "attrs", "");
//			String title = ServletRequestUtils.getStringParameter(request, "title", "");
//			String oldimgpath = ServletRequestUtils.getStringParameter(request, "oldimgpath", "");
//			String newimgpath = ServletRequestUtils.getStringParameter(request, "newimgpath", "");
			
			UserModule userModel = userModuleService.findUserModuleById(moduleId);
			userModel.setAttrs(attrs);
//			String img = FileUploadTool.fileUploadToPic_Str(request, FileUploadTool.TRAVELS_URI);
//			JSONObject
			int  b = userModuleService.updateByPrimaryKeySelective(userModel);
			if(b>0){
				ok = 1;
				code = 200;
				msg = "修改成功";	
			}else{
				ok = -1;
				code = 200;
				msg="修改失败";
			}
			
		} catch (Exception e) {
		} finally {
			result.put("ok", ok);
			result.put("code", code);
			result.put("msg", msg);
//			result.put("data", "");
		}
		return result;
	}
	
	 @RequestMapping("fileUpload1")
	 public String  fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {
	         
	   //用来检测程序运行时间
	        long  startTime=System.currentTimeMillis();
	        System.out.println("fileName："+file.getOriginalFilename());
	         
	        try {
	            //获取输出流
	            OutputStream os=new FileOutputStream("E:/"+new Date().getTime()+file.getOriginalFilename());
	            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
	            InputStream is=file.getInputStream();
	            int temp;
	            //一个一个字节的读取并写入
	            while((temp=is.read())!=(-1))
	            {
	                os.write(temp);
	            }
	           os.flush();
	           os.close();
	           is.close();
	         
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        long  endTime=System.currentTimeMillis();
	        System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
	        
	        return "test"; 
	    }
//	 @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	    public static String uploadImg(HttpServletRequest request,HttpServletResponse response) throws Exception {

	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
	        /** 构建文件保存的目录* */
	        String logoPathDir = "/upload/"
	                + dateformat.format(new Date());
	        /** 得到文件保存目录的真实路径* */
	        String logoRealPathDir = request.getSession().getServletContext()
	                .getRealPath(logoPathDir);
	        /** 根据真实路径创建目录* */
	        File logoSaveFile = new File(logoRealPathDir);
	        if (!logoSaveFile.exists())
	            logoSaveFile.mkdirs();
	        /** 页面控件的文件流* */
	        MultipartFile multipartFile = multipartRequest.getFile("file");
	        /** 获取文件的后缀* */
	        String suffix = multipartFile.getOriginalFilename().substring(
	                multipartFile.getOriginalFilename().lastIndexOf("."));
	        /** 使用UUID生成文件名称* */
	        String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
	        /** 拼成完整的文件保存路径加文件* */
	        String fileName = logoRealPathDir + File.separator + logImageName;
	        File file = new File(fileName);
	        try {
	            multipartFile.transferTo(file);
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        /** 打印出上传到服务器的文件的绝对路径* */
	        System.out.println("****************"+fileName+"**************");
//	        insertDate(fileName);
	        return fileName;
	    }

	 
	 @RequestMapping("/test")
		public String toLogin(){
			return "test";
		}
	 
	 /***
	  * 编辑分类图片上传
	  * @param request
	  * @param response
	  * @return
	  */
	 @RequestMapping( value="/uploadImg"  , produces = "application/json;charset=UTF-8")
		@ResponseBody
		public Object uploadImages(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> mapJSON=new HashMap<String, Object>();
			int ok=-1;//请求是否成功
			String msg="访问失败";
			int code=500;
//			Member member = new Member();
			String images = ServletRequestUtils.getStringParameter(request,"images","");
			try{
				 
				
				if(images!=null&&images.length()>0){
					msg = "上传成功";
					images = uploadImg(request, response);
					ok = 1;
					code = 200;
				}else{
					msg = "访问出错";
					images ="";
					ok = -1;
					code = 500;
				}
				 
			}catch (Exception e) {
			} finally {
				mapJSON.put("ok", ok);
				mapJSON.put("msg", msg);
				mapJSON.put("code", code);
				mapJSON.put("images", images);
			}
			return JSON.toJSON(mapJSON);
		}
	 
	   /***
	    * 基本设置
	    * @param request
	    * @param response
	    * @return
	    */
	 	@RequestMapping( value="/basicSettings"  , produces = "application/json;charset=UTF-8")
		@ResponseBody
		public Object basicSettings(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> mapJSON=new HashMap<String, Object>();
			int ok=-1;//请求是否成功
			String msg="访问失败";
			int code=500;
			UserModule userModel = new UserModule();
			try{
				Long moduleId=ServletRequestUtils.getLongParameter(request, "moduleId",0);
				String applyName = ServletRequestUtils.getStringParameter(request, "applyName", "");//应用名称
				String applyDescription = ServletRequestUtils.getStringParameter(request, "applyDescription", "");//应用描述
				String logo = applyName = ServletRequestUtils.getStringParameter(request, "logo", "");
				
				if(moduleId>0){
					userModel = userModuleService.findUserModuleById(moduleId);
					userModel.setApplyName(applyName);
					userModel.setApplyDescription(applyDescription);
					if(logo.equals("")){
						userModel.setLogo(userModel.getLogo());
					}else{
					 logo = uploadImg(request, response);
					 userModel.setLogo(logo);
					}
					int a = userModuleService.updateByPrimaryKeySelective(userModel);
					if(a>0){
						code=200;
						ok=1;
						msg="访问成功";
					}else{
						code=500;
						ok=-1;
						msg="访问失败";
					}
					
				}else{
					msg = "访问出错";
				}
				 
			}catch (Exception e) {
			} finally {
				mapJSON.put("ok", ok);
				mapJSON.put("msg", msg);
				mapJSON.put("code", code);
				mapJSON.put("data", userModel);
			}
			return JSON.toJSON(mapJSON);
		}
	
}
