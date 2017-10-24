package com.shop.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.bean.Cart;
import com.shop.biz.ICartBiz;
import com.shop.dao.ICartMapper;

@Service
public class CartBizImpl implements ICartBiz {

	@Resource
	private ICartMapper cm;
	
	public int addCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		return cm.addCart(cart);
		
	}

	public List<Cart> cartList(Cart cart) {
		// TODO Auto-generated method stub
		return cm.cartList(cart);
	}

	public Cart queyCartByPid(Cart cart) {
		// TODO Auto-generated method stub
		return cm.queyCartByPid(cart);
	}

	public int addAgain(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		return cm.addAgain(cart);
	}

	public int clearCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		return cm.clearCart(cart);
	}

	public int removeCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		return cm.removeCart(cart);
	}

}
