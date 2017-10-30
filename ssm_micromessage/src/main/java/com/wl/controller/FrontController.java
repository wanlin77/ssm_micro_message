package com.wl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wl.service.IQueryService;

@Controller
@RequestMapping("/front")
public class FrontController {

	@Resource
	private IQueryService queryService;

	@RequestMapping("/login")
	public String login() {
		return "front/talk";
	}

	@RequestMapping(value="/talk", method=RequestMethod.POST, produces= {"application/json;charset=utf-8"})
	@ResponseBody
	public String talk(@RequestParam("content") String content, Model model) throws IOException {
		
		return queryService.queryByCommand(content);
		
	}

}
