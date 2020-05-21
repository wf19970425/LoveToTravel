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
		<title>主页</title>
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
<!-- <script type="text/javascript" src="back/js/jquery.js"></script> -->
<script type="text/javascript" src="back/artDialog/dist/dialog-plus.js"></script>
<link href="back/artDialog/css/ui-dialog.css" rel="stylesheet"
    type="text/css" />
    <script type="text/javascript">
    	function f() {
			$("#form").attr("action",$("#actions").val());
			if($("#actions").val()=="bf/spotList"){
				$("#name").attr("name","spot_name");
			}else{
				$("#name").attr("name","teams_name");
			}
			$("#form").submit();
		}
    	$(function() {
            $("#service a").hover(function() {
                if ($(this).prop("className") == "weixin_area") {
                    $(this).children("img.hides").show();
                } else {
                    $(this).children("div.hides").show();
                    $(this).children("img.shows").hide();
                    $(this).children("div.hides").animate({marginRight: '0px'}, '0');
                }
            }, function() {
                if ($(this).prop("className") == "weixin_area") {
                    $(this).children("img.hides").hide();
                } else {
                    $(this).children("div.hides").animate({marginRight: '-163px'}, 0, function() {
                        $(this).hide();
                        $(this).next("img.shows").show();
                    });
                }
            });

            $("#top_btn").click(function() {
                $("html,body").animate({scrollTop: 0}, 600);
            });

            //右侧导航 - 二维码
            $(".weixin_area").hover(function() {
                $(this).children(".weixin").show();
            },function(){
                $(this).children(".weixin").hide();
            })
        });
    </script>
    <style>
           #service{width:161px;height:290px;position:fixed;top:350px;right:0px; z-index:100;}
            *html #service{margin-top:258px;position:absolute;top:expression(eval(document.documentElement.scrollTop));}
            #service li{width:161px;height:60px;list-style:none;}
            #service li img{float:right;list-style:none;}
            #service li a{height:49px;float:right;display:block;min-width:47px;max-width:161px;list-style:none;}
            #service li a .shows{display:block;list-style:none;}
            #service li a .hides{margin-right:-143px;cursor:pointer;cursor:hand;list-style:none;}
            #service li a.weixin_area .hides{display:none;position:absolute;right:143px;list-style:none;}
            #service li a.weixin_area .weixin{display:none;position:absolute;right:0;top:48px;list-style:none;}
            #p2{width:112px;background-color:#A7D2A9;height:47px;margin-left:47px;border:1px solid #8BC48D;text-align:center;line-height:47px}
            #p3{width:112px;background-color:#EC9890;height:47px;margin-left:47px;border:1px solid #E6776C;text-align:center;line-height:47px}
            #p1{width:47px;height:49px;float:left}
            a:hover{text-decoration: none} 
        </style>
</head>
<body>
<!-- banner -->
	<div class="banner">
		<div class="header">
			<jsp:include page="nav.jsp"></jsp:include>
		</div>
		<div class="banner-info">
			<div class="container">
			<form id="form">
				<div class="details-1">
					<div class="col-md-10 dropdown-buttons">   
						<div class="col-md-3 dropdown-button">           			
							<div class="input-group">
								<input class="form-control has-dark-background"  id="name" placeholder="名称" type="text" >
							</div>
						</div>
						<!---strat-date-piker---->
							<!-- <link rel="stylesheet" href="css/jquery-ui.css" /> -->
							<!-- <script src="js/jquery-ui.js"></script> -->
							  <script>
									  $(function() {
										$( "#datepicker,#datepicker1" ).datepicker();
									  });
							  </script>
						<!---/End-date-piker---->

						<div class="col-md-3 dropdown-button">
						  <div class="section_1">
							 <select  id="actions" class="frm-field required">
								<option value="bf/spotList">景点列表</option>
								<option value="bf/teamsList">跟团游列表</option>         
							 </select>
						  </div>
						</div>
						<div class="clearfix"> </div>
					</div> 
					<div class="col-md-2 submit_button"> 
						
							<input type="button" onclick="f()" value="搜索">
						
					</div>
					<div class="clearfix"> </div>
				</div>
				</form>
			</div>
		</div>
	</div>		
    <div class="copyrights"><a href="http://www.17sucai.com/" >旅游网站</a></div>
	<!-- tels -->
	<c:if test="${!(empty sessionScope.client) }">
	<div class="tels" style="padding: 0 0;">
		<div class="container">
					<h3 style="width: 100%;font-size: 2em;color: #6cbc35;margin: 0;text-align: center;">推荐景点</h3><br/>
			<c:forEach items="${tuijianList }" var="spot">
				<div class="col-md-4 tels-left">
					<h4>${spot.spot_name }<span>${spot.spot_price }￥</span></h4>
					<a href="bf/spotLoad?spot_id=${spot.spot_id }">
						<img src="/upload/${spot.spot_logo }" class="img-responsive" alt="">
					</a>
					<p>${spot.spot_addr }</p>
					<a class="hvr-shutter-in-horizontal" href="bf/spotLoad?spot_id=${spot.spot_id }">详细信息</a>
				</div>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
	</div>
	</c:if>
	
	<div class="tels" style="padding: 0 0;">
		<div class="container">
					<h3 style="width: 100%;font-size: 2em;color: #6cbc35;margin: 0;text-align: center;">最新景点</h3><br/>
			<c:forEach items="${spotNewList }" var="spot">
				<div class="col-md-4 tels-left">
					<h4>${spot.spot_name }<span>${spot.spot_price }￥</span></h4>
					<a href="bf/spotLoad?spot_id=${spot.spot_id }">
						<img src="/upload/${spot.spot_logo }" class="img-responsive" alt="">
					</a>
					<p>${spot.spot_addr }</p>
					<a class="hvr-shutter-in-horizontal" href="bf/spotLoad?spot_id=${spot.spot_id }">详细信息</a>
				</div>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
	</div>
	
	<div class="tels" style="padding: 0 0;">
		
			<div class="container">
						<h3 style="width: 100%;font-size: 2em;color: #6cbc35;margin: 0;text-align: center;">最新跟团游</h3><br/>
				<c:forEach items="${teamsNewList }" var="teams">
					<div class="col-md-4 tels-left">
						<h4><span>${teams.teams_price }￥</span></h4>
						<a href="bf/teamsLoad?teams_id=${teams.teams_id }">
							<img src="/upload/${teams.teams_logo }" class="img-responsive" alt="">
						</a>
						<p>${teams.teams_name }</p>
						<a class="hvr-shutter-in-horizontal" href="bf/teamsLoad?teams_id=${teams.teams_id }">详细信息</a>
					</div>
				</c:forEach>
				<div class="clearfix"></div>
			</div>
	</div>
	<!-- 窗口 -->
	    <div class="container" >
            <div class="demo">
                <div id="service">
                    <ul>
                        <li>
                            <a href="javascript:void(0)" class="weixin_area">
                                <img src="images/l02.png" width="47" height="49" class="shows" />
                                <img src="images/a.png" width="57" height="49" class="hides" />
                                <img src="images/weixin.jpg" width="145" class="weixin" style="display:none;margin:-100px 57px 0 0" />
                            </a>
                        </li>
                        <li>
                            <a  target="_blank">
                                <div class="hides" style="width:161px;display:none;" id="qq">
                                    <div class="hides" id="p1">
                                        <img src="images/ll04.png">
                                    </div>
                                    <div class="hides" id="p2"><span style="color:#FFF;font-size:13px">123456789</span>
                                    </div>
                                </div>
                                <img src="images/l04.png" width="47" height="49" class="shows" />
                            </a>
                        </li>
                        <li id="tel">
                            <a href="javascript:void(0)">
                                <div class="hides" style="width:161px;display:none;" id="tels">
                                    <div class="hides" id="p1">
                                        <img src="images/ll05.png">
                                    </div>
                                    <div class="hides" id="p3"><span style="color:#FFF;font-size:12px">123456789</span>
                                    </div>
                                </div>
                                <img src="images/l05.png" width="47" height="49" class="shows" />
                            </a>
                        </li>
                        <li id="btn">
                            <a id="top_btn">
                                <div class="hides" style="width:161px;display:none">
                                    <img src="images/ll06.png" width="161" height="49" />
                                </div>
                                <img src="images/l06.png" width="47" height="49" class="shows" />
                            </a>
                        </li>
                    </ul>
                </div>
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