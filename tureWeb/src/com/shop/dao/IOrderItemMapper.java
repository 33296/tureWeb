package com.shop.dao;

import java.util.List;

import com.shop.bean.OrderItem;
import com.shop.bean.Orders;

public interface IOrderItemMapper {
	
	public int saveOrderItem(OrderItem orderItem) throws Exception;
	
	public List<OrderItem> orderItemList();

	public List<OrderItem> queryOrderItemByOid(Orders orders);
}
