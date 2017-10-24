package com.shop.dao;

import java.util.List;

import com.shop.bean.Category;
import com.shop.bean.CategorySecond;

public interface ICategorySecondMapper {
	
	public List<CategorySecond> castegorySeconds();
	
	public List<CategorySecond> queryCategorySecondByCid(Category c);
}	
