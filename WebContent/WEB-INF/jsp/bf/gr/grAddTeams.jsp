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
	<script type="text/javascript" src="back/yz.js"></script>
</head>

<body class="gray-bg">

    <div class="row">
            <div style="height: 500px;overflow: scroll;" class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>添加评价 </h5>
                        
                    </div>
                    <div class="ibox-content">
                        <form target="_self" method="post" enctype="multipart/form-data" action="bf/grAddDoTeams" class="form-horizontal">
                            <input type="hidden" name="fk_grTeams_id" value="${gr.fk_grTeams_id }">
                            <input type="hidden" name="fk_grClient_id" value="${gr.fk_grClient_id }">
                            <input type="hidden" name="pages" value="${pages }">
                            <input type="hidden" name="orte_id" value="${orte_id }">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">商品名</label>

                                <div class="col-sm-10">
                                    <input type="text" onchange="f2()" value="${teams_name }" style="float: left;width:400px;"  class="form-control"><font style="float: left;width:120px;" id="u"></font>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">图片</label>

                                <div class="col-sm-10">
                                    <input style="float: left;width:400px;" type="file" name="photo" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">评价等级</label>
                                   
                                <div class="col-sm-10">
                                    <select style="float: left;width:400px;" class="form-control m-b" name="gr_grade">
                                        <option value="1">好评</option>
                                        <option value="2">中评</option>
                                        <option value="3">差评</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">评价信息</label>

                                <div class="col-sm-10">
                                    <textarea id="ccomment" name="gr_message" class="form-control" required="" aria-required="true" style="margin: 0px -5.34375px 0px 0px; width: 319px; height: 103px;"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">保存评价</button>
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