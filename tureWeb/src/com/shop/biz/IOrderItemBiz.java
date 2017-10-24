package com.shop.biz;

import java.util.List;

import com.shop.bean.OrderItem;
import com.shop.bean.Orders;

public interface IOrderItemBiz {
	
	public int saveOrderItem(OrderItem orderItem) throws Exception;
	
	public List<OrderItem> orderItemList();

	public List<OrderItem> queryOrderItemByOid(Orders orders);
}
