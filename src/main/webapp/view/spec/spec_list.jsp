<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>规格列表</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li>商品中心</li>
        <li>规格管理</li>
        <li>规格列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="spec.do">
        <div class="form-group">
            <label class="" for="activename">规格名称：</label>
            <input type="text" name="kw" class="form-control" id="activename" value="${requestScope.kw}" placeholder="请输入规格名称">
        </div>
        <input type="hidden" name="action" value="list">
        <input type="submit" class="btn btn-danger" value="查询"/>
        &nbsp;&nbsp;
        <a class="btn btn-success" href="<%=request.getContextPath()%>/view/spec/spec_add.jsp">添加规格</a>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>规格编号</th>
            <th>规格名称</th>
            <th>规格值</th>
            <th>操作</th>
        </tr>
        <c:forEach var="spec" items="${requestScope.specList}">
            <tr>
                <td>${spec.id}</td>
                <td>${spec.spec_name}</td>
                <td>${spec.spec_val}</td>
                <td>
                    <a href="spec.do?action=detail&id=${spec.id}">修改</a>
                    <a href="spec.do?action=delete&id=${spec.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
