package com.wl.dao;

import java.util.List;

import com.wl.domain.Message;


/**
 * ��Message�����ļ���صĽӿ�
 */
public interface IMessage {
	
	List<Message> queryMessageList(String command, String description);
	
	Message queryById(Integer id);
	
	void deleteOneMessage(Integer id);
	
	void deleteBatch(List<Integer> ids);
	
	void insert(Message message);
	
	void insertSelective(Message message);
	
	void updateOne(Message message);
	
}
