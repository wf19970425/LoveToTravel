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
		<title>跟团游详情</title>
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
    function orteAdd(teams_id,teams_price,teams_child,teams_name) {
    	
        if("${empty sessionScope.client}"=="false"){
        	var client_id = "${sessionScope.client.client_id }";
        	var d = top.dialog({
                title: '添加团游订单',
                url:'bf/orteAdd?fk_orteTeams_id='+teams_id+'&fk_orteClient_id='+client_id+'&teams_name='+teams_name+"&teams_price="+teams_price+"&teams_child="+teams_child,
                width:'600',
                height:'500',
                onclose:function(){
                    window.location.reload();
                }
            });
            d.showModal();
        }else {
            alert("请登录");
        }
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
				<img src="/upload/${teams.teams_logo }" class="img-responsive" alt="">
			</div>
			<div class="col-md-5 details-right">
				<span><strong>￥ ${teams.teams_price }</strong> ${teams.teams_name }</span>
				<%-- <li>地址：${teams.teams_addr }</li>
				<li>开放时间：${teams.teams_time }</li> --%>
				<li>单价：${teams.teams_price }</li>
				<li>特殊票：${teams.teams_child }</li>
				<div class="col-md-3 pos">
				<div class="smt">
							<a href="javascript:void(0)" class="hvr-shutter-in-horizontal" onclick="orteAdd(${teams.teams_id},${teams.teams_price},${teams.teams_child},'${teams.teams_name}')" >购票</a>
						 </div>
						 </div>
			</div>
			<div class="clearfix"> </div>
			<div class="details-top">
				<h4>跟团游概要：</h4>
				<p>${teams.teams_gen }</p>
				<h4>跟团游明细：</h4>
				<p>${teams.teams_spot }</p>
				<h4>景点简介：</h4>
				<p>${teams.teams_message }</p>
				<h4>费用详情：</h4>
				<p>${teams.teams_cost }</p>
				<h4>跟团游特色：</h4>
				<p>	${teams.teams_feat }
				</p>
			</div>
			<h4 style="margin-left: 200px;"> 评价</h4>
	<c:forEach items="${grBfList }" var="gr">
	<div class="details" style="margin-left: 200px;">
		<div style="float: left;">
		<img width="100px" height="100px" src="/upload/${gr.gr_pho }">
		</div>
		<div style="float: left;margin-left: 20px">
			${gr.client.client_name }<br />
			${gr.gr_grade eq 1 ? '好评':gr.gr_grade eq 2 ?'中评':'差评' }<br />
			${gr.gr_message}<br />
		</div>
	</div>
	<hr />
	</c:forEach>
		 </div>
	</div>
	<div class="footer-bottom">
			<div class="container">
				<p>爱旅游网	共建网络安全 共享网络文明      联系电话：111111111</p>
			</div>
		</div>
	<!-- footer -->
</body>
</html>