package com.wl.service;

import com.wl.domain.Message;

public interface IMainTainService {
	
	void deleteOneMessage(String id);
	
	void deleteBatch(String[] ids);
	
	void addMessage(Message message);
	
	void updateMessage(Message message);
	
}
