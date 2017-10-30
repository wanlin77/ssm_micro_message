package com.wl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wl.domain.Command;
import com.wl.domain.Message;
import com.wl.service.IMainTainService;
import com.wl.service.IQueryService;

@Controller
@RequestMapping("/back")
public class BackController {

	@Resource
	private IQueryService queryService;
	
	@Resource
	private  IMainTainService maintainService;

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("messageList", queryService.queryMessageList(null, null));
		return "back/list";
	}

	@RequestMapping("/list")
	public String list(String command, String description, Model model) {
		// 向页面传值
		model.addAttribute("command", command);
		model.addAttribute("description", description);
		
		List<Message> messageList = queryService.queryMessageList(command, description);
		model.addAttribute("messageList", messageList);
		
		return "back/list";
	}
	
	@RequestMapping("/deleteOne")
	public String deleteOneMessageById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		maintainService.deleteOneMessage(id);
		
		return "redirect:login";
	}
	
	@RequestMapping("/deleteBatch")
	public String deleteBatch(HttpServletRequest request, HttpServletResponse response) {
		String[] ids = request.getParameterValues("id");
		
		maintainService.deleteBatch(ids);
		
		return "redirect:login";
	}
	
	@RequestMapping("/addMessage")
	public String addMessage() {
		return "back/addMessage";
	}
	
	@RequestMapping("addSuccess")
	public String addSuccess(Message message) {
		maintainService.addMessage(message);
		return "redirect:login";
	}
	
	@RequestMapping("/updateMessage")
	public String updateMessage(Model model, String id) {
		Message message = queryService.queryMessageById(id);
		model.addAttribute("message", message);
		return "back/update";
	}
	
	@RequestMapping("updateSuccess")
	public String updateSuccess(Message message) {
		maintainService.updateMessage(message);
		return "redirect:login";
	}

}
