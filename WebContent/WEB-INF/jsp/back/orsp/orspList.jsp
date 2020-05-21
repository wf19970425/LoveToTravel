<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
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
        function orspMdi(orsp_id) {
            var d = top.dialog({
                title: '修改用户',
                url:'back/orspLoad?orsp_id='+orsp_id,
                width:'600',
                height:'800',
                onclose:function(){
                    window.location.reload();
                }
            });
            d.showModal();
        }
        function orspDel(orsp_id) {
            var d = top.dialog({
                title: '删除用户',
                url:'back/orspDel?orsp_id='+orsp_id,
                width:'600',
                height:'800',
                onclose:function(){
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
                           <form target="_self" action="back/orspList" >
                                <select style="float: left;width:150px;" class="form-control m-b" name="orsp_status">
                                    <option value="">请选择订单状态</option>
                                    <option <c:if test="${orsp.orsp_status eq 1 }">selected="selected"</c:if> value="1">未受理</option>
                                    <option <c:if test="${orsp.orsp_status eq 2 }">selected="selected"</c:if> value="2">已受理</option>
                                    <option <c:if test="${orsp.orsp_status eq 3 }">selected="selected"</c:if> value="3">已评价</option>
                                    <option <c:if test="${orsp.orsp_status eq 4 }">selected="selected"</c:if> value="4">退货中</option>
                                    <option <c:if test="${orsp.orsp_status eq 5 }">selected="selected"</c:if> value="5">退货成功</option>
                                    <option <c:if test="${orsp.orsp_status eq 6 }">selected="selected"</c:if> value="6">已评价</option>
                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-outline btn-success" style="float: left;width:80px;" value="查询">
                            </form>  
                        </div>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>订单号</th>
                                    <th>客户名</th>
                                    <th>商品名</th>
                                    <th>成人票</th>
                                    <th>特殊票</th>
                                    <th>成人票数量</th>
                                    <th>特殊票数量</th>
                                    <th>总价</th>
                                    <th>订单时间</th>
                                    <th>联系电话</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${orspList }" var="orsp">
                                <tr>
                                    <td><input type="checkbox" name="orsp_id" value="${orsp.orsp_id }" /></td>
                                    <td>${orsp.orsp_code }</td>
                                    <td>${orsp.client.client_name }</td>
                                    <td>${orsp.spot.spot_name }</td>
                                    <td>${orsp.spot.spot_price }</td>
                                    <td>${orsp.spot.spot_child }</td>
                                    <td>${orsp.orsp_num }</td>
                                    <td>${orsp.orsp_child }</td>
                                    <td>${orsp.orsp_money }</td>
                                     <td><fmt:formatDate value="${orsp.orsp_date }" pattern="yyyy-MM-dd"/></td>
                                      <td>${orsp.orsp_tel }</td>
                                    <td>
                                        <c:if test="${orsp.orsp_status eq 1 }">未受理</c:if>
                                        <c:if test="${orsp.orsp_status eq 2 }">已受理</c:if>
                                        <c:if test="${orsp.orsp_status eq 3 }">已完成</c:if>
                                        <c:if test="${orsp.orsp_status eq 4 }">退货中</c:if>
                                        <c:if test="${orsp.orsp_status eq 5 }">退货成功</c:if>
                                        <c:if test="${orsp.orsp_status eq 6 }">已评价</c:if>
                                    </td>
                                    <td class="text-navy">
                                    <c:if test="${orsp.orsp_status eq 1 }">
                                           <a href="back/orspMdi?orsp_status=2&pages=${pages }&orsp_id=${orsp.orsp_id}" target="_self" class="btn btn-outline btn-info">受理</a>
                                    </c:if>
                                    <c:if test="${orsp.orsp_status eq 2 }">
                                                                                                     已受理    
                                    </c:if>
                                    <c:if test="${orsp.orsp_status eq 3 }">已完成</c:if>
                                    <c:if test="${orsp.orsp_status eq 4 }">
                                            <a href="back/orspMdi?orsp_status=5&pages=${pages }&orsp_id=${orsp.orsp_id}" target="_self" class="btn btn-outline btn-danger">同意退货</a>
                                    </c:if>
                                    <c:if test="${orsp.orsp_status eq 5 }">退货成功</c:if>
                                    <c:if test="${orsp.orsp_status eq 6 }">已评价</c:if></td>
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