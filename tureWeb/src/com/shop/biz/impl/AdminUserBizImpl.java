package com.shop.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.bean.AdminUser;
import com.shop.bean.Category;
import com.shop.bean.CategorySecond;
import com.shop.bean.Orders;
import com.shop.bean.Product;
import com.shop.bean.User;
import com.shop.biz.IAdminUserBiz;
import com.shop.dao.IAdminUserMapper;

@Service
public class AdminUserBizImpl implements IAdminUserBiz {

	@Resource
	public IAdminUserMapper adminMapper;
	
	public AdminUser login(AdminUser admin) {
		// TODO Auto-generated method stub
		return adminMapper.login(admin);
	}

	public List<User> findAllAdmin() {
		// TODO Auto-generated method stub
		return adminMapper.findAllUser();
	}

	public User findUserByUid(User user) {
		// TODO Auto-generated method stub
		return adminMapper.findUserByUid(user);
	}

	public int editUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.editUser(user);
	}

	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.deleteUser(user);
	}

	public List<Category> findAllAdminCategory() {
		// TODO Auto-generated method stub
		return adminMapper.findAllAdminCategory();
	}

	public int saveCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.saveCategory(category);
	}

	public Category findCategoryByCid(Category category) {
		// TODO Auto-generated method stub
		return adminMapper.findCategoryByCid(category);
	}

	public int editCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.editCategory(category);
	}

	public int deleteCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.deleteCategory(category);
	}

	public List<CategorySecond> findAllCategorySecond() {
		// TODO Auto-generated method stub
		return adminMapper.findAllCategorySecond();
	}

	public int saveCategorySecond(CategorySecond categorySecond) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.saveCategorySecond(categorySecond);
	}

	public CategorySecond findCategorySecondByCsid(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		return adminMapper.findCategorySecondByCsid(categorySecond);
	}

	public int editCategorySecond(CategorySecond categorySecond) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.editCategorySecond(categorySecond);
	}

	public int deleteCategorySecond(CategorySecond categorySecond) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.deleteCategorySecond(categorySecond);
	}

	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return adminMapper.findAllProduct();
	}

	public int saveProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.saveProduct(product);
	}

	public Product findAdminProductByPid(Product product) {
		// TODO Auto-generated method stub
		return adminMapper.findAdminProductByPid(product);
	}

	public int editProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.editProduct(product);
	}

	public int deleteProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.deleteProduct(product);
	}

	public List<Orders> findAllAdminOrder() {
		// TODO Auto-generated method stub
		return adminMapper.findAllAdminOrder();
	}

	public int updateAdminOrderState(Orders order) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.updateAdminOrderState(order);
	}

	public List<Product> queryProductByCsid(CategorySecond cs) {
		// TODO Auto-generated method stub
		return adminMapper.queryProductByCsid(cs);
	}


}
