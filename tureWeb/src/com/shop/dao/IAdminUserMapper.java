package com.shop.dao;

import java.util.List;

import com.shop.bean.AdminUser;
import com.shop.bean.Category;
import com.shop.bean.CategorySecond;
import com.shop.bean.Orders;
import com.shop.bean.Product;
import com.shop.bean.User;

public interface IAdminUserMapper {
	
	public AdminUser login(AdminUser admin);
	
	public List<User> findAllUser();
	
	public User findUserByUid(User user);
	
	public int editUser(User user) throws Exception;
	
	public int deleteUser(User user) throws Exception;
	
	public List<Category> findAllAdminCategory();
	
	public int saveCategory(Category category) throws Exception;
	
	public Category findCategoryByCid(Category category);
	
	public int editCategory(Category category) throws Exception;
	
	public int deleteCategory(Category category) throws Exception;
	
	public List<CategorySecond> findAllCategorySecond();
	
	public int saveCategorySecond(CategorySecond categorySecond) throws Exception;
	
	public CategorySecond findCategorySecondByCsid(CategorySecond categorySecond);
	
	public int editCategorySecond(CategorySecond categorySecond) throws Exception;
	
	public int deleteCategorySecond(CategorySecond categorySecond) throws Exception;
	
	public List<Product> findAllProduct();
	
	public List<Product> queryProductByCsid(CategorySecond categorySecond);
	
	public int saveProduct(Product product) throws Exception;
	
	public Product findAdminProductByPid(Product product);
	
	public int editProduct(Product product) throws Exception;
	
	public int deleteProduct(Product product) throws Exception;
	
	public List<Orders> findAllAdminOrder();
	
	public int updateAdminOrderState(Orders order) throws Exception;
}
