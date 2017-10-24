package com.shop.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.bean.Orders;
import com.shop.bean.User;
import com.shop.biz.IUserBiz;
import com.shop.dao.IUserMapper;

@Service
public class UserBizImpl implements IUserBiz {

	@Resource
	private IUserMapper userMapper;
	
	public User login(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	public boolean add(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.add(user);
	}

	public User findUserByUsername(User user) {
		// TODO Auto-generated method stub
		return userMapper.findUserByUsername(user);
	}

	public List<Orders> findOrderByUid(User user) {
		// TODO Auto-generated method stub
		return userMapper.findOrderByUid(user);
	}

}
