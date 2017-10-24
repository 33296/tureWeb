package com.shop.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.bean.Errors;
import com.shop.bean.User;
import com.shop.biz.IOrderItemBiz;
import com.shop.biz.IUserBiz;


@Controller
public class UserController {

	@Resource
	public IUserBiz userBiz;
	
	@Resource
	public IOrderItemBiz oib;
	
	
	
	//用户登录
	@RequestMapping("userlogin")
	public String loginPage(User user, HttpSession session) throws Exception{
		
		User u  = userBiz.login(user);
		if(u != null){
			if(u.getState()!=null && u.getState()==1){
				session.setAttribute("u", u);
				return "redirect:index.do";
			}else{
				return "jsp/login1";
			}
		}else{
			return "jsp/login1";
		}
		
	}
	
	//用户退出
	@RequestMapping("exit")
	public String exit(HttpSession session){
		session.removeAttribute("u");
//		session.invalidate();
		return "redirect:index.do";
	}
	
	//注册用户
	@RequestMapping("regist")
	public String regist(HttpSession session, HttpServletRequest request, User user, Errors errors) throws Exception{
		String code = (String) session.getAttribute("code");
		
		if(user.getCode().equalsIgnoreCase(code)){
			User u = userBiz.findUserByUsername(user);
			if(u==null){
				userBiz.add(user);
				return "jsp/msg";
				
			}else{
				String errorUsername = "用户名已存在!";
				request.setAttribute("user", user);
				errors.setErrorUsername(errorUsername);
			}
			
			return "jsp/regist";
		}else{
			
			String errorCode = "验证码不正确!";
			errors.setErrorCode(errorCode);
			request.setAttribute("user", user);
			request.setAttribute("errors", errors);
			return "jsp/regist";
		}
	}
	
	//查找orders
//	@RequestMapping("findOrderByUid")
//	public String findOrderByUid(Page page, HttpServletRequest request, HttpSession session){
//		User user = (User) session.getAttribute("u");
//		List<Orders> orderList = userBiz.findOrderByUid(user);
//		page.setObjList(orderList);
//		return "orderList";
//	}
	
	//查询orderItem
//	@RequestMapping("queryOrderItemByOid")
//	public String queryOrderItemByOid(){
//		
//		return "orderList";
//	}
}
