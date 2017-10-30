package com.wl.service;

import java.util.List;

import com.wl.domain.Command;
import com.wl.domain.Message;

public interface IQueryService {
	
	List<Message> queryMessageList(String command, String description);
	
	Message queryMessageById(String id);
	
	List<Command> queryCommandList(String name, String description);
	
	String queryByCommand(String name);
	
}
