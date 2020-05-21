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
        function roleAdd() {
            var d = top.dialog({
                title: '角色添加',
                url:'back/roleAdd',
                width:'500',
                height:'500',
                onclose:function (){
                    //刷新页面
                    window.location.reload();
                }
            });
            d.showModal();
        }
        function roleDel(role_id) {
            var d = top.dialog({
                title: '角色删除',
                url:'back/roleDel?role_id='+role_id,
                width:'500',
                height:'500',
                onclose:function (){
                    //刷新页面
                    window.location.reload();
                }
            });
            d.showModal();
        }
        function roleMdi(role_id) {
            var d = top.dialog({
                title: '角色修改',
                url:'back/roleMdi?role_id='+role_id,
                width:'500',
                height:'500',
                onclose:function (){
                    //刷新页面
                    window.location.reload();
                }
            });
            d.showModal();
        }
        function mdiMenu(role_id) {
            var d = top.dialog({
                title: '修改权限',
                url:'back/mdiMenu?role_id='+role_id,
                width:'500',
                height:'500',
                onclose:function (){
                    //刷新页面
                    window.location.reload();
                }
            });
            d.showModal();
        }
    </script>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">          
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <div class="ibox-tools">
                           <form target="_self" action="back/roleList" >
                                <input type="text" value="${role.role_name }" placeholder="请输入角色名" name="role_name" style="float: left;width:120px;" class="form-control">
                                &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-outline btn-success" style="float: left;width:80px;" value="查询">
                            </form>
                        </div>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>角色</th>
            						<th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${roleList }" var="role">
                                <tr>
                                    <td><input type="checkbox" name="role_id" value="${role.role_id }" /></td>
                                    <td>${role.role_name }</td>
            <td>
               <button class="btn btn-outline btn-success" onclick="mdiMenu(${role.role_id})">修改权限</button>
              <a title="编辑" class="btn btn-outline btn-info" onclick="roleMdi(${role.role_id})" href="javascript:;">
              		 修改
              </a>
              <a title="删除" class="btn btn-outline btn-danger" onclick="roleDel(${role.role_id})" href="javascript:;">
              		  删除
              </a>
            </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <jsp:include page="../main/pages.jsp"></jsp:include>
                </div>
            </div>
        </div>
        
    </div>
    <script src="back/js/jquery.min.js?v=2.1.4"></script>
    <script src="back/js/bootstrap.min.js?v=3.3.5"></script>
    <script src="back/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="back/js/content.min.js?v=1.0.0"></script>
    <script src="back/js/plugins/iCheck/icheck.min.js"></script>
    <script src="back/js/demo/peity-demo.min.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>