<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>内容列表页面</title>
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
<script
	src="${pageContext.request.contextPath }/resources/js/common/jquery-1.8.0.min.js"></script>
<script src="<%=basePath%>resources/js/back/list.js"></script>
</head>
<body style="background: #e1e9eb;">
	<form action="<%=basePath%>back/addSuccess" id="saveForm" method="post">
		<input type="hidden" name="currentPage" id="currentPage"
			value="${page.currentPage}" />

		<div class="right">
			<div class="current">
				当前位置：<a href="javascript:void(0)" style="color: #6E6E6E;">内容管理</a>
				&gt;增加信息
			</div>
			<div class="rightCont">
				<p class="g_title fix">
					增加内容 <a class="btn03"
						href="javascript:document.getElementById('saveForm').submit()">提交</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
						class="btn03" href="javascript:history.go(-1)">退回 </a>
				</p>

				<div class="zixun fix">
					<input type="hidden" name="id" value="${message.id }">
					<table class="tab2" width="100%">
						<tr style='background-color: #ECF6EE;'>
							<td>指令名称:</td>
							<td><input type="text" name="command"></td>
						</tr>
						<tr>
							<td>简要描述:</td>
							<td><input type="text" name="description"></td>
						</tr>
						<tr style='background-color: #ECF6EE;'>
							<td>内容:</td>
							<td><input type="text" name="content"></td>
						</tr>
						<tr>
							<td><input type="submit" value="提交">&nbsp;&nbsp;<a href="javascript:history.go(-1)">退回 </a></td>
						</tr>
					</table>

				</div>
			</div>
		</div>
	</form>
</body>
</html>