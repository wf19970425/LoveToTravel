<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
	<head>

		<base href="${basePath}">
		<title>团游订单</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Motel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="back/artDialog/dist/dialog-plus.js"></script>
<link href="back/artDialog/css/ui-dialog.css" rel="stylesheet"
    type="text/css" />
    <script type="text/javascript">
    function grAdd(teams_name,client_id,teams_id,orte_id,pages) {
        var d = top.dialog({
            title: '订单评价',
            url:'bf/grAddTeams?teams_name='+teams_name+'&fk_grClient_id='+client_id+'&fk_grTeams_id='+teams_id+"&orte_id="+orte_id+"&pages="+pages,
            width:'600',
            height:'500',
            onclose:function(){
                window.location.reload();
            }
        });
        d.showModal();
    }
    </script>
</head>
<body>
<!-- banner -->
	<div class="banner1">
		<div class="header">
			<jsp:include page="../main/nav.jsp"></jsp:include>
		</div>
	</div>		
		<!-- banner -->
<div class="typo" style="padding-bottom: 4px;">
		<div class="container">
			<h3 class="title">景点订单</h3>
			<div class="bs-docs-example">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>订单号</th>
							<th width="200px">商品</th>
							<th>成人票</th>
							<th>儿童票</th>
							<th>钱数</th>
							<th>预留电话</th>
							<th>订单时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orteList }" var="orte">
							<tr>
								<th>${orte.orte_code }</th>
								<th>${orte.teams.teams_name }</th>
								<th>${orte.orte_num }</th>
								<th>${orte.orte_child }</th>
								<th>${orte.orte_money }</th>
								<th>${orte.orte_tel }</th>
								<th><fmt:formatDate pattern="yyyy-MM-dd" value="${orte.orte_date }"/></th>
								<th><c:if test="${orte.orte_status eq 1 }">未受理</c:if>
                                        <c:if test="${orte.orte_status eq 2 }">已受理</c:if>
                                        <c:if test="${orte.orte_status eq 3 }">已完成</c:if>
                                        <c:if test="${orte.orte_status eq 4 }">退货中</c:if>
                                        <c:if test="${orte.orte_status eq 5 }">退货成功</c:if>
                                        <c:if test="${orte.orte_status eq 6 }">已评价</c:if></th>
								<th>
									<c:if test="${orte.orte_status eq 1 }">未受理</c:if>
                            <c:if test="${orte.orte_status eq 2 }"><a href="bf/orteMdi?orte_status=3&pages=${pages }&orte_id=${orte.orte_id}" class="label label-primary" >确认收货</a></c:if>
                            <c:if test="${orte.orte_status eq 3 }"><a href="javascript:void(0)" onclick="grAdd('${orte.teams.teams_name}',${orte.client.client_id },${orte.teams.teams_id },${orte.orte_id },${pages })" class="label label-primary" >评价</a></c:if>
                            <c:if test="${orte.orte_status eq 4 }">退货中</c:if>
                            <c:if test="${orte.orte_status eq 5 }">退货成功</c:if>
                            <c:if test="${orte.orte_status eq 6 }">已评价</c:if>
                            <c:if test="${!((orte.orte_status eq 5)||(orte.orte_status eq 4)||(orte.orte_status eq 6)||(orte.orte_status eq 3)) }">
                                <a href="bf/orteMdi?orte_status=4&pages=${pages }&orte_id=${orte.orte_id}" class="label label-primary" >退货</a>
                            </c:if>
								</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="../main/pages.jsp"></jsp:include>
	<!-- footer -->
	<div class="footer-bottom">
			<div class="container">
				<p>旅游网站	共建网络安全 共享网络文明      联系电话：111111111</p>
			</div>
		</div>
	<!-- footer -->
</body>
</html>