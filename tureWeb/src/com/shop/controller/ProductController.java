package com.shop.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.bean.Category;
import com.shop.bean.CategorySecond;
import com.shop.bean.Product;
import com.shop.biz.ICategorySecondBiz;
import com.shop.biz.IProductBiz;

@Controller
public class ProductController {
	
	@Resource
	private IProductBiz pb;
	
	@RequestMapping("findProductByCid")
	public String findProductByCid(Category category, HttpServletRequest request){
		
		List<Product> pList = pb.findProductByCid(category);
		request.setAttribute("pList", pList);
		return "jsp/productList";
		
	}
	
	@RequestMapping("findproductByCsid")
	public String findproductByCsid(CategorySecond cs, HttpServletRequest request){
		List<Product> pList = pb.findproductByCsid(cs);
		request.setAttribute("pList", pList);
		return "jsp/productList";
	}
	
	@RequestMapping("findProductByPid")
	public String findProductByPid(Product product,HttpServletRequest request){
		Product p = pb.findProductByPid(product);
		request.setAttribute("p", p);
		return "jsp/product";
	}
	
}
