package com.shop.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.bean.Orders;
import com.shop.bean.User;
import com.shop.biz.IOrdersBiz;
import com.shop.dao.IOrdersMapper;

@Service
public class OrdersBizImpl implements IOrdersBiz {

	@Resource
	private IOrdersMapper om;
	
	public int saveOrder(Orders order) throws Exception {
		// TODO Auto-generated method stub
		return om.saveOrder(order);
	}

	public Orders findOrdersByorder(Orders order) {
		// TODO Auto-generated method stub
		return om.findOrdersByorder(order);
	}

	public int findMaxOid() {
		// TODO Auto-generated method stub
		return om.findMaxOid();
	}

	public List<Orders> findOidByUid(User u) {
		// TODO Auto-generated method stub
		return om.findOidByUid(u);
	}

	public int orderState(Orders order) throws Exception {
		// TODO Auto-generated method stub
		return om.orderState(order);
	}

}
