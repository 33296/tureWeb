package com.shop.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.bean.OrderItem;
import com.shop.bean.Orders;
import com.shop.biz.IOrderItemBiz;
import com.shop.dao.IOrderItemMapper;

@Service
public class OrderItemBizImpl implements IOrderItemBiz {

	@Resource
	private IOrderItemMapper oim;

	public List<OrderItem> orderItemList() {
		// TODO Auto-generated method stub
		return oim.orderItemList();
	}

	

	public int saveOrderItem(OrderItem orderItem) throws Exception {
		// TODO Auto-generated method stub
		return oim.saveOrderItem(orderItem);
	}



	public List<OrderItem> queryOrderItemByOid(Orders order) {
		// TODO Auto-generated method stub
		return oim.queryOrderItemByOid(order);
	}



	
	

	

}
