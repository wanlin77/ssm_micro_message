package com.wl.dao;

import java.util.List;

import com.wl.domain.Command;

public interface ICommandDao {
	
	List<Command> queryCommandList(String name, String description);
	
}
