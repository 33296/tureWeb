package com.shop.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.bean.Category;
import com.shop.bean.CategorySecond;
import com.shop.biz.ICategorySecondBiz;
import com.shop.dao.ICategorySecondMapper;

@Service
public class CategorySecondBizImpl implements ICategorySecondBiz {

	@Resource
	private ICategorySecondMapper csm;
	
	public List<CategorySecond> castegorySeconds() {
		// TODO Auto-generated method stub
		return csm.castegorySeconds();
	}

	public List<CategorySecond> queryCategorySecondByCid(Category c) {
		// TODO Auto-generated method stub
		return csm.queryCategorySecondByCid(c);
	}

}
