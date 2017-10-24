package com.shop.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.bean.Cart;
import com.shop.bean.OrderItem;
import com.shop.bean.Orders;
import com.shop.bean.User;
import com.shop.biz.ICartBiz;
import com.shop.biz.IOrderItemBiz;
import com.shop.biz.IOrdersBiz;

@Controller
public class OrderController {
	
	@Resource
	private ICartBiz cartBiz;
	@Resource
	private IOrdersBiz orderBiz;
	
	@Resource
	private IOrderItemBiz itemBiz;
	
	@RequestMapping("saveOrder")
	public String saveOrder(String chooses, Double total, HttpSession session, HttpServletRequest request){
		User user = (User) session.getAttribute("u");
		//获取pid
		String choose[] = chooses.split(";");
		
		
		//orders
		Orders order = new Orders();
		
		order.setTotal(total);
		order.setOrdertime(new Date());
		order.setState(1);
		order.setName(user.getName());
		order.setPhone(user.getPhone());
		order.setAddr(user.getAddr());
		order.setUid(user.getUid());
		
		
		try {
			orderBiz.saveOrder(order);
			//pid uid 查询order
			int oid = orderBiz.findMaxOid();
			order.setOid(oid);
			
			for (String c : choose) {
				Cart cart = new Cart();
				Integer pid = Integer.parseInt(c);
				cart.setPid(pid);
				cart.setUid(user.getUid());
				
				Cart ct = cartBiz.queyCartByPid(cart);
				
			
				OrderItem oi = new OrderItem();
				
				oi.setOid(oid);
				oi.setCount(ct.getCount());
				oi.setSubtotal(ct.getProduct().getShop_price());
				oi.setPid(ct.getPid());
				oi.setProduct(ct.getProduct());
				oi.setOrders(order);
				
				itemBiz.saveOrderItem(oi);
				
				cartBiz.removeCart(cart);
			}
			
			List<OrderItem> orderItemList = itemBiz.queryOrderItemByOid(order);
			order.setItemList(orderItemList);
			request.setAttribute("total", total);
			request.setAttribute("order", order);
		} catch (Exception e) {
			return "jsp/order";
		}
		
		return "jsp/order";
	}
	
	
	@RequestMapping("findOrderItemByUid")
	public String findOrderByUid(User u, HttpServletRequest request){
		List<Orders> orderList = orderBiz.findOidByUid(u);
		for (Orders o : orderList) {
			List<OrderItem> orderItemList = itemBiz.queryOrderItemByOid(o);
			o.setItemList(orderItemList);
		}
		request.setAttribute("orderList", orderList);
		return "jsp/orderList";
	}
	
	@RequestMapping("payOrder")
	public String payOrder(Orders order){
		order.setState(2);
		try {
			orderBiz.orderState(order);
		} catch (Exception e) {
			return "redirect:findOrderItemByUid.do?uid="+order.getUid();
		}
		return "redirect:findOrderItemByUid.do?uid="+order.getUid();
	}
	
	@RequestMapping("updateState")
	public String updateState(Orders order){
		order.setState(4);
		try {
			orderBiz.orderState(order);
		} catch (Exception e) {
			return "redirect:findOrderItemByUid.do?uid="+order.getUid();
		}
		return "redirect:findOrderItemByUid.do?uid="+order.getUid();
	}
}
