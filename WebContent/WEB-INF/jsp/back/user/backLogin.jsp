<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("path", path);
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

        <base href="${basePath}">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>旅游系统</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="back/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="back/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="back/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="back/css/animate.min.css" rel="stylesheet">
    <link href="back/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
	<script type="text/javascript" src="back/js/jquery.js"></script>
<script type="text/javascript" src="back/artDialog/dist/dialog-plus.js"></script>
<link href="back/artDialog/css/ui-dialog.css" rel="stylesheet"
	type="text/css" />
    <script type="text/javascript">
        function yes() {
        	window.location.href='back/backLogin1';
		}
        function no(){
        	var dialog = top.dialog.get(window);
    		dialog.close();
    		dialog.remove();
    		return false;
        }
    </script>
</head>
<body>
	<form action="back/bfLogin1" method="post">
		<center><h4>请问是否退出登陆？</h4><br><br>
		<input type="button" onclick="yes()" value="是" class="btn btn-outline btn-primary">&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="no()" value="否" class="btn btn-outline btn-primary">
		</center>
	</form>	
</body>
</html>