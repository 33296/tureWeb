package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping(value="loginPage" ,method=RequestMethod.GET)
	public String loginPage (){
		return "jsp/login1";
	}
	
	@RequestMapping("registPage")
	public String registPage(){
		return "jsp/regist";
	}
	
	@RequestMapping("admintop")
	public String admintop(){
		return "admin/top";
	}
	
	@RequestMapping("adminleft")
	public String adminleft(){
		return "admin/left";
	}
	
	@RequestMapping("adminwelcome")
	public String adminwelcome(){
		return "admin/welcome";
	}
	
	@RequestMapping("adminbottom")
	public String adminbottom(){
		return "admin/bottom";
	}
	
	@RequestMapping("addCategory")
	public String addCategory(){
		return "../admin/category/add";
	}
	
	
}
