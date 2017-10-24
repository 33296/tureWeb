package com.shop.biz;

import java.util.List;

import com.shop.bean.Cart;

public interface ICartBiz {
	
	public int addCart(Cart cart) throws Exception;
	
	public int addAgain(Cart cart) throws Exception;
	
	public List<Cart> cartList(Cart cart);
	
	public Cart queyCartByPid(Cart cart);
	
	public int clearCart(Cart cart) throws Exception;
	
	public int removeCart(Cart cart) throws Exception;
	
}
