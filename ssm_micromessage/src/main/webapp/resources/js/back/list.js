/**
 * 调用后台单条删除信息
 */
function deleteOne(basePath,id) {
	if(confirm("确定要删除吗？")){
		$("#mainForm").attr("action", basePath +"back/deleteOne?id="+id);
		$("#mainForm").submit();
	}
}


/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action", basePath + "back/deleteBatch");
	$("#mainForm").submit();
}

/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

/**
 * 调用后台修改单条信息
 */
function updateOne(basePath,id) {
	$("#mainForm").attr("action", basePath +"back/updateMessage?id="+id);
	$("#mainForm").submit();
}