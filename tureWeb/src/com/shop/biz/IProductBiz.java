package com.shop.biz;

import java.util.List;

import com.shop.bean.Category;
import com.shop.bean.CategorySecond;
import com.shop.bean.Product;

public interface IProductBiz {
	
	public List<Product> findProductByCid(Category category);
	
	public List<Product> findproductByCsid(CategorySecond cs);
	
	public List<Product> findHotProduct();
	
	public List<Product> findNowProduct();
	
	public Product findProductByPid(Product p);
}
