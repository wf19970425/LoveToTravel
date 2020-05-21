<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			pageContext.setAttribute("path", path);
			pageContext.setAttribute("basePath", basePath);
%>
<%
	Object s = request.getAttribute("orteTotal");
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
 <link rel="shortcut icon" href="favicon.ico"> <link href="back/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="back/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="back/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="back/css/animate.min.css" rel="stylesheet">
    <link href="back/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
<!--[if lte IE 8]>
          <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
        <![endif]-->
<script type="text/javascript" src="back/js/jquery.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<title>管理权限</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="artDialog/dist/dialog-plus.js"></script>
<link href="artDialog/css/ui-dialog.css" rel="stylesheet"
    type="text/css" />

</head>
<body>
<div style="margin-left: 300px;">
                           <form target="_self" action="back/orteTotal" >
                                <input type="text" value="${orte_date }" placeholder="请输入年份" name="orte_date" style="float: left;width:120px;" class="form-control">
                                &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-outline btn-success" style="float: left;width:80px;" value="查询">
                            </form>
                        </div><br /><br />
     <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
     <%if(s!=null){
    	 List<Map<String,Object>> orteTotal = ( List<Map<String,Object>>)s;
    	 if(orteTotal.size()>0){
    	 %>
     
    <div id="main" style="width: 1200px;height:450px;"></div>
    <script type="text/javascript">
    	var dates = []; 
    	var moneys = [];
    	<%for(int i=0;i<orteTotal.size();i++){%>
    		dates[<%=i%>] = "<%=orteTotal.get(i).get("d")%>";
    		moneys[<%=i%>] = <%=orteTotal.get(i).get("money")%>;
    	<%}%>
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '团游订单统计'
            },
            tooltip: {},
            legend: {
                data:['月份']
            },
            xAxis: {
                data: dates
            },
            yAxis: {},
            series: [{
                name: '销售金额',
                type: 'bar',
                data: moneys,
                barWidth : 100,//柱图宽度
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    <%}else{%>
    	  没有数据请填写年份
    <%}}else{ %>
    没有数据请填写年份
    <%} %>
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
