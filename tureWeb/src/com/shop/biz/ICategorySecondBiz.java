package com.shop.biz;

import java.util.List;

import com.shop.bean.Category;
import com.shop.bean.CategorySecond;

public interface ICategorySecondBiz {

	public List<CategorySecond> castegorySeconds();
	
	public List<CategorySecond> queryCategorySecondByCid(Category c);
}
