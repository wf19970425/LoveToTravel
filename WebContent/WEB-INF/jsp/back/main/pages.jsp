<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
function jumpPage(pages) {
	document.getElementById("pages").value=pages;
	var pageForm = document.getElementById("pageForm");
	pageForm.action="${url}";
	pageForm.method="post";
	pageForm.submit();
}	
</script>
<div class="btn-group" style="float: left;">
	共<font color="green">${sumPage }</font>页当前<font color="red">${pages }</font>页
</div>
<form target="_self" id="pageForm">
	<input type="hidden" name="account" value="${user.account }">
	<input type="hidden" name="user_name" value="${user.user_name }">
	<input type="hidden" name="spot_name" value="${spot.spot_name }">
	
	<input type="hidden" name="pages" id="pages">
	<div class="btn-group" style="float: right;">
		<a type="button" onclick="jumpPage(1)" class="btn btn-white">首页</a> <a
			type="button" onclick="jumpPage(${(pages-1<1)?1:(pages-1)})"
			class="btn btn-white">上一页</a> <a type="button"
			onclick="jumpPage(${(pages+1>sumPage)?sumPage:(pages+1)})"
			class="btn btn-white">下一页</a> <a type="button"
			onclick="jumpPage(${sumPage})" class="btn btn-white">尾页</a>
	</div>
</form>
</div>
</div>