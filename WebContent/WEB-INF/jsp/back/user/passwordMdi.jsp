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
        function passwordMdi() {
			var laoPassword = $("#laoPassword").val();
			var password = $("#password").val();
			var password1 = $("#password1").val();
			if(!(laoPassword=="${sessionScope.user.password}")){
				$("#ab").html("老密码错误");
			}
			if(!(password==password1)){
                $("#ab").html("两次密码不一致");
            }
			if((password==password1)&&(laoPassword=="${sessionScope.user.password}")){
				$("#form").submit();
				
			}
			
			
		}
    </script>
</head>

<body class="gray-bg">

    <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>添加员工 </h5>
                        
                    </div>
                    <div class="ibox-content">
                        <form id="form" target="_self" method="post"  action="back/userMdi" class="form-horizontal">
                            <input type="hidden" value="${sessionScope.user.user_id }" name="user_id">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">老密码</label>

                                <div class="col-sm-10">
                                    <input type="text"  style="float: left;width:400px;" id="laoPassword" name="laoPassword" class="form-control"><font style="float: left;width:120px;" id="u"></font>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">新密码</label>

                                <div class="col-sm-10">
                                    <input type="text"  style="float: left;width:400px;" id="password" name="password" class="form-control"><font style="float: left;width:120px;" id="u"></font>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">确认新密码</label>

                                <div class="col-sm-10">
                                    <input type="text"  style="float: left;width:400px;" id="password1" name="password1" class="form-control"><font style="float: left;width:120px;" id="u"></font>
                                </div>
                            </div>
                            <div class="form-group">
                                <font id="ab" color="red"></font>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="button" onclick="passwordMdi()">保存内容</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    <script src="back/js/jquery.min.js?v=2.1.4"></script>
    <script src="back/js/bootstrap.min.js?v=3.3.5"></script>
    <script src="back/js/content.min.js?v=1.0.0"></script>
    <script src="back/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>