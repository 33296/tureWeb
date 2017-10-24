package com.shop.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.bean.Cart;
import com.shop.bean.User;
import com.shop.biz.ICartBiz;

@Controller
public class CartController {

	@Resource
	private ICartBiz cb;
	
	
	@RequestMapping("addCart")
	public String addCart(Cart cart,HttpSession session, HttpServletRequest request){
		User u = (User) session.getAttribute("u");
		if(u!=null){
			int i = 0;
			double  total = 0;
			List<Cart> cartList = cb.cartList(cart);
			for (Cart c : cartList) {
				if(c.getPid().equals(cart.getPid()) && c.getUid().equals(cart.getUid())){
					c.setCount(c.getCount()+1);
					try {
						cb.addAgain(c);
					} catch (Exception e) {
						return "jsp/cart";
					}
					i++;
					break;
				}
			}
			
			if(i==0){
				try {
					cb.addCart(cart);
				} catch (Exception e) {
					return "jsp/cart";
				}
			}
			cartList = cb.cartList(cart);
			for (Cart c : cartList) {
				total += (c.getProduct().getShop_price()*c.getCount());
			}
			request.setAttribute("cartList", cartList);
			return "redirect:index.do";
		}else{
			return "jsp/login";
		}
		
	}
	
	@RequestMapping("myCart")
	public String myCart(Cart cart,HttpSession session, HttpServletRequest request){
		User u = (User) session.getAttribute("u");
		if(u!=null){
			List<Cart> cartList = cb.cartList(cart);
			request.setAttribute("cartList", cartList);
			return "jsp/cart";
		}else{
			return "jsp/login";
		}
	}
	
	@RequestMapping("clearCart")
	public String clearCart(Cart cart, HttpSession session, HttpServletRequest request){
		User user = (User) session.getAttribute("u");
		cart.setUid(user.getUid());
		try {
			cb.clearCart(cart);
		} catch (Exception e) {
			return "jsp/cart";
		}
		List<Cart> cartList = cb.cartList(cart);
		request.setAttribute("cartList", cartList);
		return "jsp/cart";
	}
	
	@RequestMapping("removeCart")
	public String removeCart(Cart cart, HttpServletRequest request){
		try {
			cb.removeCart(cart);
		} catch (Exception e) {
			return "jsp/cart";
		}
		List<Cart> cartList = cb.cartList(cart);
		request.setAttribute("cartList", cartList);
		return "jsp/cart";
	}
}
