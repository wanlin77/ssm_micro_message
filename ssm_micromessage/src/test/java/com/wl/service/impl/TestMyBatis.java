package com.wl.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.wl.domain.User;
import com.wl.service.IUserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits.xml"})
public class TestMyBatis {
	
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	
	@Resource
	private IUserService userService = null;
	
	@Test
	public void test1() {
		User user = userService.getUserById(1); 
		logger.info(JSON.toJSONString(user));  
	}
	
}
