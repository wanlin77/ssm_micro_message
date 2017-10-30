package com.wl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wl.dao.ICommandDao;
import com.wl.dao.IMessage;
import com.wl.domain.Command;
import com.wl.domain.CommandContent;
import com.wl.domain.Message;
import com.wl.service.IQueryService;
import com.wl.util.Iconst;

@Service(value="queryService")
public class QueryServiceImpl implements IQueryService {
	
	@Resource
	private ICommandDao iCommandDao;
	
	@Resource
	private IMessage iMessage;
	
	@Override
	public List<Command> queryCommandList(String name, String description) {
		return iCommandDao.queryCommandList(name, description);
	}
	
	//通过指令查询自动回复的内容
	@Override
	public String queryByCommand(String command) {
		List<Command> commandList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			commandList = iCommandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
			}
		}
		commandList = iCommandDao.queryCommandList(command, null);
		if(commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}

	@Override
	public List<Message> queryMessageList(String command, String description) {
		List<Message> messageList = iMessage.queryMessageList(command, description);
		return messageList;
	}

	@Override
	public Message queryMessageById(String id) {
		// TODO Auto-generated method stub
		return iMessage.queryById(Integer.parseInt(id));
	}

}
