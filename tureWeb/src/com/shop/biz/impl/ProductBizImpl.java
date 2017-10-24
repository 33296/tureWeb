package com.shop.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.bean.Category;
import com.shop.bean.CategorySecond;
import com.shop.bean.Product;
import com.shop.biz.IProductBiz;
import com.shop.dao.IProductMapper;

@Service
public class ProductBizImpl implements IProductBiz {

	@Resource
	private IProductMapper pm;
	public List<Product> findProductByCid(Category category) {
		// TODO Auto-generated method stub
		return pm.findProductByCid(category);
	}
	
	public List<Product> findproductByCsid(CategorySecond cs) {
		// TODO Auto-generated method stub
		return pm.findproductByCsid(cs);
	}

	public List<Product> findHotProduct() {
		// TODO Auto-generated method stub
		return pm.findHotProduct();
	}

	public List<Product> findNowProduct() {
		// TODO Auto-generated method stub
		return pm.findNowProduct();
	}

	public Product findProductByPid(Product p) {
		// TODO Auto-generated method stub
		return pm.findProductByPid(p);
	}

}
