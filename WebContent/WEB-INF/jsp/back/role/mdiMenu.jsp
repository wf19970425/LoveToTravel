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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="jquery,select,双向选择,列表框" />
<meta name="description" content="Helloweba演示平台，演示XHTML、CSS、jquery、PHP案例和示例" />
<title>权限分配</title>
    <style type="text/css">
        #main{
            width: 500px;
        }
        .demo{width:450px; margin:20px auto}
        .select_side{float:left; width:200px}
         select{width:200px; height:200px;border: 1px solid #404040;font-weight: bold}
        .select_opt{float:left; width:40px; height:15%; padding-top: 80px;padding-left: 10px;}
        .select_opt p{width:26px; height:26px; margin-top:6px; background:url(arr.gif) no-repeat; cursor:pointer; text-indent:-999em}
        .select_opt p#toright{background-position:2px 0}
        .select_opt p#toleft{background-position:2px -22px}
        .sub_btn{clear:both; height:42px; line-height:42px; padding-top:10px; text-align:center}
    </style>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
$(function(){
    var leftSel = $("#selectL");
    var rightSel = $("#selectR");
    $("#toright").bind("click",function(){      
        leftSel.find("option:selected").each(function(){
            $(this).remove().appendTo(rightSel);
        });
    });
    $("#toleft").bind("click",function(){       
        rightSel.find("option:selected").each(function(){
            $(this).remove().appendTo(leftSel);
        });
    });
    leftSel.dblclick(function(){
        $(this).find("option:selected").each(function(){
            $(this).remove().appendTo(rightSel);
        });
    });
    rightSel.dblclick(function(){
        $(this).find("option:selected").each(function(){
            $(this).remove().appendTo(leftSel);
        });
    });

});
function f() {
	var options = $("#selectR option");
	for (var i in options) {
		options[i].selected=true;
	}
	$("#form01").submit();
}
</script>
</head>

<body>
    <form id="form01" action="back/mdiMenuDo" method="post">
        <input type="hidden" name="role_id" value="${role_id }">
        <div id="main">
          <h4 align="center">分配权限</h4>
          <div class="demo">
             <div class="select_side">
             <p align="center">未拥有权限</p>
             <select id="selectL" name="selectL" multiple="multiple">
             <c:forEach items="${noList }" var="menu">
                 <option value="${menu.menu_id }">${menu.menu_name }</option>
                 </c:forEach>
             </select>
             </div>
             <div class="select_opt">
                <p id="toright" title="添加">&gt;</p>
                <p id="toleft" title="移除">&lt;</p>
             </div>
             <div class="select_side">
             <p align="center">已选区</p>
             <select id="selectR" name="selectR" multiple="multiple">
                 <c:forEach items="${haveList }" var="rlm">
                 <option name="hav" value="${rlm.menu.menu_id }">${rlm.menu.menu_name }</option>
                 </c:forEach>
             </select>
             </div>
             <div class="sub_btn"><input type="button" onclick="f()" id="sub" value="修改权限" /></div>
          </div>
    
        </div>
    </form>


</body>
</html>