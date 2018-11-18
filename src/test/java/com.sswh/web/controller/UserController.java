package com.sswh.web.controller;

import com.sswh.entity.User;
import com.sswh.service.UserService;
import com.sswh.utils.MD5;
import com.sswh.utils.String2Date;
import com.sswh.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	
	//从页面提交的数据到这里
	@RequestMapping("/regist")
	public String regist(User user, String veryCode, HttpSession session) throws Exception{
		System.out.println("hello");
		String veryCode1 = (String) session.getAttribute("verycode");
		//判断验证码
	/*	if(!veryCode1.equals(veryCode)){
			session.setAttribute("msg", "验证码输入错误！！！");
			session.setAttribute("registData", user);
			return "redirect:/page/register";
			
		}*/
		//将页面的年月日，传到birthday里面
		System.out.println("验证码相等");
		//设置id
		user.setId(UUIDUtils.getCode());
		//设置生日
		user.setBirthday(String2Date.getDate(user.getYear(), user.getMonth(), user.getDay()));
		//设置状态
		user.setStatus(0);
		//设置激活码
		user.setCode(UUIDUtils.getCode());
		//设置密码  MD5加密密码
		user.setPassWord(MD5.md5(user.getPassWord()));
		System.out.println(user);
		System.out.println("结果正常");
		userService.regist(user);
		return "/login";
	}
	
	//用户激活,页面请求可以直接过来
	@RequestMapping("/active")
	public String active(String code,String uid){
		
		
		
		return null;
		
	}
	
	
	

}
