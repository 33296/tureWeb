package com.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shop.bean.AdminUser;
import com.shop.bean.Category;
import com.shop.bean.CategorySecond;
import com.shop.bean.OrderItem;
import com.shop.bean.Orders;
import com.shop.bean.Product;
import com.shop.bean.User;
import com.shop.biz.IAdminUserBiz;
import com.shop.biz.ICategorySecondBiz;
import com.shop.biz.IOrderItemBiz;

@Controller
public class AdminUserController {
	
	@Resource
	public IAdminUserBiz adminBiz;
	
	@Resource
	public IOrderItemBiz itemBiz;
	
	@Resource
	public ICategorySecondBiz csb;
	
	@RequestMapping("adminlogin")
	public String adminlogin(AdminUser admin,HttpSession session){
		AdminUser adminuser = adminBiz.login(admin);
		if(adminuser != null){
			session.setAttribute("admin", adminuser);
			List<Category> categoryList = adminBiz.findAllAdminCategory();
			session.setAttribute("categoryList", categoryList);
			return "../admin/home";
		}else {
			return "jsp/login1";
		}
	}
	
	@RequestMapping("findAllUser")
	public String findAllAdmin(HttpServletRequest request){
		List<User> userList = adminBiz.findAllAdmin();
		request.setAttribute("userList", userList);
		return "../admin/user/list";
	}
	
	@RequestMapping("findUserByUid")
	public String findUserByUid(User user, HttpServletRequest request){
		User u = adminBiz.findUserByUid(user);
		request.setAttribute("u", u);
		return "../admin/user/edit";
	}
	
	@RequestMapping("editUser")
	public String editUser(User user){
		try {
			adminBiz.editUser(user);
			return "redirect:findAllUser.do";
		} catch (Exception e) {
			return "redirect:findUserByUid.do";
		}
		
	}
	
	@RequestMapping("deleteUser")
	public String deleteUser(User user){
		try {
			adminBiz.deleteUser(user);
			return "redirect:findAllUser.do";
		} catch (Exception e) {
			return "redirect:findAllUser.do";
		}
	}
	
	@RequestMapping("findAllAdminCategory")
	public String findAllAdminCategory(HttpServletRequest request){
		List<Category> categoryList = adminBiz.findAllAdminCategory();
		request.setAttribute("categoryList", categoryList);
		return "../admin/category/list";
	}
	
	@RequestMapping("saveCategory")
	public String saveCategory(Category category){
		try {
			adminBiz.saveCategory(category);
			return "redirect:findAllAdminCategory.do";
		} catch (Exception e) {
			return "redirect:findAllAdminCategory.do";
		}
	}
	
	@RequestMapping("findCategoryByCid")
	public String findCategoryByCid(Category category, HttpServletRequest request){
		Category c = adminBiz.findCategoryByCid(category);
		request.setAttribute("c", c);
		return "../admin/category/edit";
	}
	
	@RequestMapping("editCategory")
	public String editCategory(Category category){
		try {
			adminBiz.editCategory(category);
			return "redirect:findAllAdminCategory.do";
		} catch (Exception e) {
			return "redirect:findAllAdminCategory.do";
		}
	}
	
	@RequestMapping("deleteCategory")
	public String deleteCategory(Category category){
		try {
			adminBiz.deleteCategory(category);
			return "redirect:findAllAdminCategory.do";
		} catch (Exception e) {
			return "redirect:findAllAdminCategory.do";
		}
	}
	
	@RequestMapping("findAllCategorySecond")
	public String findAllCategorySecond(HttpServletRequest request){
		
		List<CategorySecond> categorySecondList = adminBiz.findAllCategorySecond();
		request.setAttribute("csList", categorySecondList);
		return "../admin/categorysecond/list";
	}
	
	@RequestMapping(value="queryCategorySecondByCid",method={RequestMethod.GET})
	public @ResponseBody List<CategorySecond> queryCategorySecondByCid(Category c){
		List<CategorySecond> csList = csb.queryCategorySecondByCid(c);
		return csList;
	}
	
	@RequestMapping("addCategorySecond")
	public String addCategorySecond(HttpServletRequest request){
		List<Category> categoryList = adminBiz.findAllAdminCategory();
		request.setAttribute("categoryList", categoryList);
		return "../admin/categorysecond/add";
	}
	
	@RequestMapping("saveCategorySecond")
	public String saveCategorySecond(CategorySecond categorySecond){
		try {
			adminBiz.saveCategorySecond(categorySecond);
			return "redirect:findAllCategorySecond.do";
		} catch (Exception e) {
			return "redirect:findAllCategorySecond.do";
		}
	}
	
	@RequestMapping("findCategorySecondByCsid")
	public String findCategorySecondByCsid(CategorySecond categorySecond,HttpServletRequest request){
		List<Category> categoryList = adminBiz.findAllAdminCategory();
		request.setAttribute("categoryList", categoryList);
		CategorySecond cs = adminBiz.findCategorySecondByCsid(categorySecond);
		request.setAttribute("cs", cs);
		return "../admin/categorysecond/edit";
	}
	
	@RequestMapping("editCategorySecond")
	public String editCategorySecond(CategorySecond categorySecond){
		try {
			adminBiz.editCategorySecond(categorySecond);
			return "forward:findAllCategorySecond.do";
		} catch (Exception e) {
			return "forward:findAllCategorySecond.do";
		}
	}
	
	@RequestMapping("deleteCategorySecond")
	public String deleteCategorySecond(CategorySecond categorySecond){
		try {
			adminBiz.deleteCategorySecond(categorySecond);
			return "forward:findAllCategorySecond.do";
		} catch (Exception e) {
			return "forward:findAllCategorySecond.do";
		}
	}
	
	@RequestMapping("findAllProduct")
	public String findAllProduct(HttpServletRequest request){
		List<Product> productList = adminBiz.findAllProduct();
		request.setAttribute("productList", productList);
		return "../admin/product/list";
	}
	
	@RequestMapping("queryProductByCsid")
	public String queryProductByCsid(CategorySecond cs,HttpServletRequest request){
		List<Product> productList = adminBiz.queryProductByCsid(cs);
		request.setAttribute("productList", productList);
		return "../admin/product/list";
	}
	
	@RequestMapping("addProduct")
	public String addProduct(HttpServletRequest request){
		List<CategorySecond> categorySecondList = adminBiz.findAllCategorySecond();
		request.setAttribute("csList", categorySecondList);
		return "../admin/product/add";
	}
	
	@RequestMapping("saveProduct")
	public String saveProduct(@RequestParam("upload") MultipartFile upload, Product product, HttpServletRequest request){
		Integer csid = product.getCsid();
		String savePath = request.getSession().getServletContext().getRealPath("/products/"+csid);
		File saveFile = new File(savePath+"/"+upload.getOriginalFilename());
		try {
			FileUtils.copyInputStreamToFile(upload.getInputStream(), saveFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String image = "products/"+csid+"/"+saveFile.getName();
		product.setImage(image);
		
		try {
			adminBiz.saveProduct(product);
			return "forward:findAllProduct.do";
		} catch (Exception e) {
			return "forward:findAllProduct.do";
		}
	}
	
	@RequestMapping("findAdminProductByPid")
	public String findAdminProductByPid(Product product, HttpServletRequest request){
		Product p = adminBiz.findAdminProductByPid(product);
		request.setAttribute("p", p);
		List<CategorySecond> categorySecondList = adminBiz.findAllCategorySecond();
		request.setAttribute("csList", categorySecondList);
		return "../admin/product/edit";
	}
	
	@RequestMapping("editProduct")
	public String editProduct(@RequestParam("upload") MultipartFile upload, Product product, HttpServletRequest request){
		if(upload.getSize()!=0){
			Integer csid = product.getCsid();
			String savePath = request.getSession().getServletContext().getRealPath("/products/"+csid);
			File saveFile = new File(savePath+"/"+upload.getOriginalFilename());
			try {
				FileUtils.copyInputStreamToFile(upload.getInputStream(), saveFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String image = "products/"+csid+"/"+saveFile.getName();
			product.setImage(image);
		}
		try {
			adminBiz.editProduct(product);
			return "forward:findAllProduct.do";
		} catch (Exception e) {
			return "forward:findAllProduct.do";
		}
	}
	
	@RequestMapping("deleteProduct")
	public String deleteProduct(Product product){
		try {
			adminBiz.deleteProduct(product);
			return "forward:findAllProduct.do";
		} catch (Exception e) {
			return "forward:findAllProduct.do";
		}
	}
	
	@RequestMapping("findAllAdminOrder")
	public String findAllAdminOrder(HttpServletRequest request){
		List<Orders> orderList = adminBiz.findAllAdminOrder();
		request.setAttribute("orderList", orderList);
		return "../admin/order/list";
	}
	
	@RequestMapping("queryOrderItemByOid")
	public String findOrderItemByOid(Orders order, HttpServletRequest request){
		List<OrderItem> orderItemList = itemBiz.queryOrderItemByOid(order);
		request.setAttribute("orderItemList", orderItemList);
		return "../admin/order/orderItem";
	}
	
	@RequestMapping("updateAdminOrderState")
	public String updateAdminOrderState(Orders order){
		try {
			adminBiz.updateAdminOrderState(order);
			return "forward:findAllAdminOrder.do";
		} catch (Exception e) {
			return "forward:findAllAdminOrder.do";
		}
	}
}
