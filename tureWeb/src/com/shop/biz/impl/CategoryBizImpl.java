package com.shop.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.bean.Category;
import com.shop.biz.ICategoryBiz;
import com.shop.dao.ICategoryMapper;

@Service
public class CategoryBizImpl implements ICategoryBiz {

	@Resource
	private ICategoryMapper cm;
	
	public List<Category> cList() {
		// TODO Auto-generated method stub
		return cm.cList();
	}

}
