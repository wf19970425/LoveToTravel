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
	<link href="back/artDialog/css/ui-dialog.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="back/yz.js"></script>
	<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor/kindeditor-all.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="spot_message"]', {
				cssPath : '/tour/kindeditor/plugins/code/prettify.css',
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
			　　		this.sync();
			　　    },
			　　    afterBlur:function(){
			　　		this.sync();
			　　    }
			});
			var editor2 = K.create('textarea[name="spot_look"]', {
				cssPath : '/tour/kindeditor/plugins/code/prettify.css',
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
			　　		this.sync();
			　　    },
			　　    afterBlur:function(){
			　　		this.sync();
			　　    }
			});
			var editor2 = K.create('textarea[name="spot_link"]', {
				cssPath : '/tour/kindeditor/plugins/code/prettify.css',
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
			　　		this.sync();
			　　    },
			　　    afterBlur:function(){
			　　		this.sync();
			　　    }
			});
			prettyPrint();
		});
		
	</script>
</head>

<body class="gray-bg">

    <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>修改景点 </h5>
                        
                    </div>
                    <div class="ibox-content">
                        <form style="height: 500px;overflow: scroll;" target="_self" method="post" enctype="multipart/form-data" action="back/spotMdi" class="form-horizontal">
                            <input type="hidden" value="${spot.spot_id }" name="spot_id">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">景点名</label>

                                <div class="col-sm-10">
                                    <input type="text"  style="float: left;width:400px;" id="spot_name" value="${spot.spot_name }" name="spot_name" class="form-control"><font style="float: left;width:120px;" id="u"></font>
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="col-sm-2 control-label">景点类型</label>
								
                                <div class="col-sm-10">
                                    <select style="float: left;width:400px;" class="form-control m-b" name="fk_spotFac_id">
                                        <c:forEach items="${facListAll }" var="fac">
                                        	<option <c:if test="${spot.fk_spotFac_id eq fac.fac_id}">selected="selected"</c:if> value="${fac.fac_id}">${fac.fac_id}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">图片</label>

                                <div class="col-sm-10">
                                    <input id="icon" style="float: left;width:400px;" type="file" name="icon" class="form-control"><font style="float: left;width:120px;"  id="a"></font>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">地址</label>

                                <div class="col-sm-10">
                                    <input id="spot_addr"  style="float: left;width:400px;" type="text" value="${spot.spot_addr }" name="spot_addr" class="form-control"><font style="float: left;width:120px;" ></font>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">开放时间</label>

                                <div class="col-sm-10">
                                    <input id="spot_time"  style="float: left;width:400px;" type="text" value="${spot.spot_time }" name="spot_time" class="form-control"><font style="float: left;width:120px;" ></font>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">成人票</label>

                                <div class="col-sm-10">
                                    <input id="spot_tel"  style="float: left;width:400px;" type="text" value="${spot.spot_price }" name="spot_price" class="form-control"><font style="float: left;width:120px;" ></font>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">特殊票</label>

                                <div class="col-sm-10">
                                    <input id="spot_child"  style="float: left;width:400px;" type="text" value="${spot.spot_child }" name="spot_child" class="form-control"><font style="float: left;width:120px;" ></font>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">景点信息</label>

                                <div class="col-sm-10">
                                    <textarea   autocomplete="off" name="spot_message" cols="100" rows="8" style="width:100%;height:100px;visibility:hidden;">${spot.spot_message }</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">景点须知</label>

                                <div class="col-sm-10">
                                    <textarea   autocomplete="off" name="spot_look" cols="100" rows="8" style="width:100%;height:100px;visibility:hidden;">${spot.spot_look }</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">景点交通</label>

                                <div class="col-sm-10">
                                    <textarea   autocomplete="off" name="spot_link" cols="100" rows="8" style="width:100%;height:100px;visibility:hidden;">${spot.spot_link }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
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