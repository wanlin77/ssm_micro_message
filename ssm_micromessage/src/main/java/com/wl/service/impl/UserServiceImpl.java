package com.wl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wl.dao.UserMapper;
import com.wl.domain.User;
import com.wl.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUserById(int userId) {
		return this.userMapper.selectByPrimaryKey(userId);
	}

}
