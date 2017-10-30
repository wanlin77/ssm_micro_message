package com.wl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wl.dao.IMessage;
import com.wl.domain.Message;
import com.wl.service.IMainTainService;

@Service("maintainService")
public class MaintainServiceImpl implements IMainTainService {
	
	@Autowired
	private IMessage iMassage;
	
	@Override
	public void deleteOneMessage(String id) {
		if(id != null && !"".equals(id.trim())) {
			iMassage.deleteOneMessage(Integer.valueOf(id));
		}
	}

	@Override
	public void deleteBatch(String[] ids) {
		List<Integer> idList = new ArrayList<Integer>();
		for (String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		iMassage.deleteBatch(idList);
	}

	@Override
	public void addMessage(Message message) {
		iMassage.insert(message);
	}

	@Override
	public void updateMessage(Message message) {
		iMassage.updateOne(message);
	}
	
	
	
}
