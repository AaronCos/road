package com.sswh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewResolver {
	/*
	 *@PathVariable("pageName")
	 *是springmvc提供的一种restful格式的请求方式
	 *它会将请求的路径中{pageName}锁标识的字符串作为参数传递给有@PathVariable注解
	 * 
	 * 使用restful风格必须配置视图解析器
	 * 
	 * */
	@RequestMapping("/page/{name}")
	public String forwardPage(@PathVariable("name") String page){
		System.out.println(page);
		return page;
	}
	
	

}
