<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
		<title>个人信息</title>
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
    function clientMdi(client_id) {
        var d = top.dialog({
            title: '修改用户信息',
            url:'bf/clientLoad1?client_id='+client_id,
            width:'600',
            height:'500',
            onclose:function(){
                window.location.reload();
            }
        });
        d.showModal();
    }
    function clientPasswordMdi() {
        var d = top.dialog({
            title: '修改密码',
            url:'bf/clientPasswordMdi',
            width:'600',
            height:'500',
            onclose:function(){
            	window.location.reload();
            }
        });
        d.showModal();
    }
    function clientPayPasswordMdi() {
        var d = top.dialog({
            title: '修改密码',
            url:'bf/clientPayPasswordMdi',
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
<!-- details -->
	<div class="details">
		<div class="container">
			<div class="col-md-7 details-left">
				<img src="images/kehu.jpg" class="img-responsive" alt="">
			</div>
			<div class="col-md-5 details-right">
				<ul>
				<li><b>姓名：${client.client_name }</b></li>
				<li><b>账号：${client.client_account}</b></li>
				<li><b>电话：${client.client_tel }</b></li>
				</ul><br />
				<div>
				<a href="javascript:void(0)" class="hvr-shutter-in-horizontal" onclick="clientMdi(${sessionScope.client.client_id})" >修改个人信息</a>
				</div><br />
				<div>
				<a href="javascript:void(0)" class="hvr-shutter-in-horizontal" onclick="clientPasswordMdi()" >修改登录密码</a>
				</div><br />
				<div>
				<a href="javascript:void(0)" class="hvr-shutter-in-horizontal" onclick="clientPayPasswordMdi()" >修改支付密码</a>
				</div>
			</div>
			<div class="clearfix"> </div>
		 </div>
	</div>
	<div class="footer-bottom">
			<div class="container">
				<p>旅游网站	共建网络安全 共享网络文明         联系电话：111111111</p>
			</div>
		</div>
	<!-- footer -->
</body>
</html>