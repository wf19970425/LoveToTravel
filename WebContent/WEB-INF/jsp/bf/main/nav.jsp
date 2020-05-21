<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <script type="text/javascript" src="back/artDialog/dist/dialog-plus.js"></script>
<link href="back/artDialog/css/ui-dialog.css" rel="stylesheet"
    type="text/css" />
    <script type="text/javascript">
    
function login() {
    var d = top.dialog({
        title: '登录',
        url:'bf/login',
        width:600,
        height:500,
        onclose:function(){
            window.location.reload();
        }
    });
    d.showModal();
}
function reg() {
    var d = top.dialog({
        title: '注册',
        url:'bf/reg',
        width:600,
        height:500,
        onclose:function(){
            window.location.reload();
        }
    });
    d.showModal();
}
function loginOut() {
	if(window.confirm("确定要退出吗？")){
		window.location.href="bf/loginOut";
	}
	
}
</script>
    <div class="container">
    <div class="logo">
		<img src="/upload/logo.jpg" style="width:260px;height: 70px">
	</div>
<nav class="navbar navbar-default" role="navigation">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<!--/.navbar-header-->
						<div style="width:800px;" class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li><a href="bf/main">主页</a></li>
								<li><a href="bf/spotList">景点</a></li>
								<li><a href="bf/teamsList">跟团游</a></li>
								<!-- <li><a href="bf/mapList">查询路线</a></li> -->
								<c:if test="${!(empty sessionScope.client) }">
									<li><a href="bf/clientLoad">个人中心</a></li>
									<li><a href="bf/orspList?fk_orspClient_id=${sessionScope.client.client_id }">景点订单</a></li>
									<li><a href="bf/orteList?fk_orteClient_id=${sessionScope.client.client_id }">跟团游订单</a></li>
								</c:if>
							</ul>
						</div>
						<!--/.navbar-collapse-->
					</nav>
					<div  class="search-box">
					<div style="width: 100px;right: 2em;" id="sb-search" class="sb-search">
							<a href="http://localhost:8080/tour1/back/login"><h4>管理员登录</h4></a>
							<c:if test="${empty sessionScope.client }">
								<a style="float: left;" href="javascript:login()">登录</a>
								<span style="float: left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<a style="float: left;" href="javascript:reg()/">注册</a>
							</c:if>
							<c:if test="${!(empty sessionScope.client) }">
								<a style="float: left;" href="javascript:void(0)">${sessionScope.client.client_name }</a>
								<span style="float: left;">&nbsp;&nbsp;&nbsp;</span>
								<a style="float: left;" href="javascript:loginOut()">退出</a>
							</c:if>
					</div>
				</div>
					<div class="clearfix"> </div>

				<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
					<script>
						new UISearch( document.getElementById( 'sb-search' ) );
					</script>
				<!-- //search-scripts -->

			</div>