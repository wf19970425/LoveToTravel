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
<form target="_self" id="pageForm">
<input type="hidden" name="pages" id="pages">
<input type="hidden" name="fk_orspClient_id" value="${orsp.fk_orspClient_id }">
	<input type="hidden" name="fk_orteClient_id" value="${orte.fk_orteClient_id }">
<div style="margin-left: 500px;" class="grid_3 grid_5">
				<div class="col-md-12">
					<nav>
						<ul class="pagination">
							<li><a href="javascript:jumpPage(1);">首页</a></li>
							<li><a href="javascript:jumpPage(${(pages-1<1)?1:(pages-1)});">上一页</a></li>
							<li><a href="javascript:jumpPage(${(pages+1>sumPage)?sumPage:(pages+1)});">下一页</a></li>
							<li><a href="javascript:jumpPage(${sumPage});">尾页</a></li>
						</ul>
					</nav>
				</div>
			</div>
</form>