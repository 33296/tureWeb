package com.shop.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.bean.Category;
import com.shop.bean.CategorySecond;
import com.shop.bean.Product;
import com.shop.biz.ICategoryBiz;
import com.shop.biz.ICategorySecondBiz;
import com.shop.biz.IProductBiz;




@Controller
public class IndexController {
	
	@Resource
	private ICategoryBiz cb;
	
	@Resource
	private IProductBiz pb;
	
	@Resource
	private ICategorySecondBiz csb;
	
	@RequestMapping("index")
	public String indexView(HttpSession session, HttpServletRequest request){
		
		List<Category> cList = cb.cList();
		List<Product> hpList = pb.findHotProduct();
		List<Product> npList = pb.findNowProduct();
		List<CategorySecond> csList = csb.castegorySeconds();
		session.setAttribute("csList", csList);
		session.setAttribute("cList", cList);
		request.setAttribute("hpList", hpList);
		request.setAttribute("npList", npList);
		return "jsp/index";
	}
	
}
