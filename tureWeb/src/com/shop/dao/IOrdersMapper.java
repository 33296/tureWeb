package com.shop.dao;

import java.util.List;

import com.shop.bean.Orders;
import com.shop.bean.User;

public interface IOrdersMapper {
	
	public int saveOrder(Orders order)  throws Exception;
	
	public Orders findOrdersByorder(Orders order);
	
	public int findMaxOid();
	
	public List<Orders> findOidByUid(User u);
	
	public int orderState(Orders order)  throws Exception;
	
}
