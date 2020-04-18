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
		<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>旅游系统网站</title>
<link href="bfLogin/css/bootstrap.min.css" rel="stylesheet">
<link href="bfLogin/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="bfLogin/css/zzsc.css">
<script type="text/javascript" src="back/js/jquery.js"></script>
<script type="text/javascript" src="back/artDialog/dist/dialog-plus.js"></script>
<link href="back/artDialog/css/ui-dialog.css" rel="stylesheet"
    type="text/css" />
<style type="text/css">
    .form-bg{
        padding: 2em 0;
    }
    .form-horizontal{
        background: #fff;
        padding-bottom: 40px;
        border-radius: 15px;
        text-align: center;
    }
    .form-horizontal .heading{
        display: block;
        font-size: 35px;
        font-weight: 700;
        padding: 35px 0;
        border-bottom: 1px solid #f0f0f0;
        margin-bottom: 30px;
    }
    .form-horizontal .form-group{
        padding: 0 40px;
        margin: 0 0 25px 0;
        position: relative;
    }
    .form-horizontal .form-control{
        background: #f0f0f0;
        border: none;
        border-radius: 20px;
        box-shadow: none;
        padding: 0 20px 0 45px;
        height: 40px;
        transition: all 0.3s ease 0s;
    }
    .form-horizontal .form-control:focus{
        background: #e0e0e0;
        box-shadow: none;
        outline: 0 none;
    }
    .form-horizontal .form-group i{
        position: absolute;
        top: 12px;
        left: 60px;
        font-size: 17px;
        color: #c8c8c8;
        transition : all 0.5s ease 0s;
    }
    .form-horizontal .form-control:focus + i{
        color: #00b4ef;
    }
    .form-horizontal .fa-question-circle{
        display: inline-block;
        position: absolute;
        top: 12px;
        right: 60px;
        font-size: 20px;
        color: #808080;
        transition: all 0.5s ease 0s;
    }
    .form-horizontal .fa-question-circle:hover{
        color: #000;
    }
    .form-horizontal .main-checkbox{
        float: left;
        width: 20px;
        height: 20px;
        background: #11a3fc;
        border-radius: 50%;
        position: relative;
        margin: 5px 0 0 5px;
        border: 1px solid #11a3fc;
    }
    .form-horizontal .main-checkbox label{
        width: 20px;
        height: 20px;
        position: absolute;
        top: 0;
        left: 0;
        cursor: pointer;
    }
    .form-horizontal .main-checkbox label:after{
        content: "";
        width: 10px;
        height: 5px;
        position: absolute;
        top: 5px;
        left: 4px;
        border: 3px solid #fff;
        border-top: none;
        border-right: none;
        background: transparent;
        opacity: 0;
        -webkit-transform: rotate(-45deg);
        transform: rotate(-45deg);
    }
    .form-horizontal .main-checkbox input[type=checkbox]{
        visibility: hidden;
    }
    .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
        opacity: 1;
    }
    .form-horizontal .text{
        float: left;
        margin-left: 7px;
        line-height: 20px;
        padding-top: 5px;
        text-transform: capitalize;
    }
    .form-horizontal .btn{
        float: right;
        font-size: 14px;
        color: #fff;
        background: #00b4ef;
        border-radius: 30px;
        padding: 10px 25px;
        border: none;
        text-transform: capitalize;
        transition: all 0.5s ease 0s;
    }
    @media only screen and (max-width: 479px){
        .form-horizontal .form-group{
            padding: 0 25px;
        }
        .form-horizontal .form-group i{
            left: 45px;
        }
        .form-horizontal .btn{
            padding: 10px 20px;
        }
    }
</style>
<script type="text/javascript">
	function f(){
		var client_account = $("input[name='client_account']").val();
		var client_password = $("input[name='client_password']").val();
		var client_name = $("input[name='client_name']").val();
		var client_tel = $("input[name='client_tel']").val();
		var client_paypassword = $("input[name='client_paypassword']").val();
		if(client_account==""){
			alert("请填写账号!");
			return false;
		}
		if(client_password==""){
			alert("请填写密码!");
			return false;
		}
		if(client_name==""){
			alert("请填写姓名!");
			return false;
		}
		if(client_tel==""){
			alert("请填电话!");
			return false;
		}
		var tel = /^(13|15|17|19|18)[0-9]{9}$/;
		if(!(tel.test(client_tel))){
			alert("请正确填写电话号");
			return false;
		}
		if(client_paypassword==""){
			alert("请填写密码!");
			return false;
		}
		var paypassword = /^[0-9]{6}$/;
		if(!(paypassword.test(client_paypassword))){
			alert("支付密码为6位数字");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<div class="demo form-bg">
    <div class="container">
        <div class="row">
            <div style="height: 500px;overflow: scroll;" class="col-md-offset-3 col-md-6">
                <form onsubmit="return f()" class="form-horizontal" action="bf/regDo" method="post">
                    <span class="heading">用户注册</span>
                    <div class="form-group">
                        <input type="text" class="form-control" name="client_account" id="inputEmail3" placeholder="账号">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group help">
                        <input type="password" class="form-control" name="client_password" id="inputPassword3" placeholder="密码">
                        <i class="fa fa-lock"></i>
                    </div>
                    <div class="form-group help">
                        <input type="text" class="form-control" name="client_name" id="inputPassword3" placeholder="姓名">
                        <i class="fa fa-lock"></i>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="client_tel" id="inputEmail3" placeholder="电话">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group help">
                        <input type="password" class="form-control" name="client_paypassword" id="inputPassword3" placeholder="支付密码">
                        <i class="fa fa-lock"></i>
                    </div>
                    <div class="form-group help">
                     	兴趣：<br />
                     	<c:forEach items="${facListAll }" var="fac">
                        	<input type="checkbox" name="fk_clientFac_ids" value="${fac.fac_id }">${fac.fac_name }
                        </c:forEach>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">立刻注册</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>