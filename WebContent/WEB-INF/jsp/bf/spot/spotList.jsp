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
		<title>景点</title>
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
</head>
<body>
<!-- banner -->
	<div class="banner1">
		<div class="header">
			<jsp:include page="../main/nav.jsp"></jsp:include>
		</div>
	</div>		
		<!-- banner -->
<!-- offers -->
	<div class="offers">
		<div class="container">
			<c:forEach items="${spotBfList }" var="spot">
				<div class="col-md-4 offers-left">
					<h3>${spot.spot_name } ￥${spot.spot_price }</h3>
					<a href="bf/spotLoad?spot_id=${spot.spot_id }"><img src="/upload/${spot.spot_logo }" class="img-responsive" alt=""></a>
					<h4>${spot.spot_addr }</h4>
					<a class="hvr-shutter-in-horizontal" href="bf/spotLoad?spot_id=${spot.spot_id }">详细信息</a>
				</div>
			</c:forEach>
				<div class="clearfix"></div>
			</div>
		 </div>
<!-- offers -->
<!-- footer -->
	<div class="footer-bottom">
			<div class="container">
				<p>爱旅游网	共建网络安全 共享网络文明      联系电话：111111111</p>
			</div>
		</div>
	<!-- footer -->
</body>
</html>