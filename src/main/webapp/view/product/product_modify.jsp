<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>商品详情</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../js/bootstrap.min.js"></script>
</head>

<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">商品中心</a></li>
        <li>商品管理</li>
        <li>商品详情</li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/product/update.do" class="form-horizontal" method="post">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">商品条码</label>
                <div class="col-sm-9">
                    <input type="text" name="bar_code" class="form-control input-sm" value="${product.barCode}"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">商品名称</label>
                <div class="col-sm-9">
                    <input type="text" name="product_name" class="form-control input-sm" value="${product.productName}"/>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">销售单价</label>
                <div class="col-sm-9">
                    <input type="text" name="sale_price" class="form-control input-sm" value="${product.salePrice}"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">供应商</label>
                <div class="col-sm-6">
                    <select name="supplier_id" id="select_s" class="form-control input-sm">
                        <script type="text/javascript">
                            $.ajax({
                                type: "post",
                                url: "/supplier/all.do",
                                data: {keyword:"",pageNum:1, pageSize:10},
                                dataType: "json",
                                success: function (response) {
                                    console.log(response);
                                    let dataArr = response.data.list;
                                    let htmlData = "";
                                    $.each(dataArr, function (i) {
                                        console.log(dataArr[i]);
                                        htmlData = htmlData + "<option value="+dataArr[i].id+">"+dataArr[i].supplierName+"</option>";
                                    });
                                    console.log(htmlData);
                                    $("#select_s").html(htmlData);
                                }
                            });
                        </script>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">品类</label>
                <div class="col-sm-6">
                    <select name="category_id" id="select_c" class="form-control input-sm" >
                        <script type="text/javascript">
                            $.ajax({
                                type: "post",
                                url: "/category/all.do",
                                data: {keyword:"",pageNum:1, pageSize:10},
                                dataType: "json",
                                success: function (response) {
                                    console.log(response);
                                    let dataArr = response.data.list;
                                    let htmlData = "";
                                    $.each(dataArr, function (i) {
                                        console.log(dataArr[i]);
                                        htmlData = htmlData + "<option value="+dataArr[i].id+">"+dataArr[i].categoryName+"</option>";
                                    });
                                    console.log(htmlData);
                                    $("#select_c").html(htmlData);
                                }
                            });
                        </script>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            </div>
        </div>
    </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/view/product/product_list.jsp">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>
