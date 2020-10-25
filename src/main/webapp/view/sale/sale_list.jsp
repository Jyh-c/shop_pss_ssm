<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>销售报表</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li>销售管理</li>
        <li>销售报表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="" method="">
        <div class="form-group">
            <label class="" for="keyword">商品名称：</label>
            <input type="text" name="keyword" class="form-control" id="keyword" placeholder="请输入商品名称">
        </div>
        <input type="button" id="load" class="btn btn-danger" value="查询"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <thead>
        <th>商品条码</th>
        <th>商品名称</th>
        <th>销售单价</th>
        <th>销售数量</th>
        <th>销售金额</th>
        <th>销售日期</th>
        </thead>
        <tbody></tbody>
    </table>

    <div align="center" >
        <div id="paging" class="btn-group">
        </div>
        每页条数：
        <script>let ps = $("#ps").val();</script>
        <select id="ps" onclick="loadData(1,ps)">
            <option value="3">3</option>
            <option value="5" selected>5</option>
            <option value="10">10</option>
            <option value="20">20</option>
        </select>
    </div>
</div>
<link href="../../css/paging.css" rel="stylesheet" >
<script src="../../js/paging.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    let data;
    let pageNum = 1;
    let pageSize;
    $(function(){
        $("#load").click(function () {
            loadData(pageNum,pageSize);
        });
        loadData(pageNum,pageSize);
    })
    function loadData(pageNum,pageSize) {
        let keyword = $("#keyword").val();
        pageSize = $("select").val();
        $.ajax({
            type: "post",
            url: "/sale/all.do",
            data: {keyword:keyword,pageNum:pageNum, pageSize:pageSize},
            dataType: "json",
            success: function (response) {
                console.log(response);
                data = response.data;
                let dataArr = response.data.list;
                let htmlData = "";
                $.each(dataArr, function (i) {
                    console.log(dataArr[i]);
                    htmlData = htmlData + "<tr>";
                    htmlData = htmlData + "<td>"+ dataArr[i].productBarCode +"</td>";
                    htmlData = htmlData + "<td>"+ dataArr[i].bizProduct.productName +"</td>";
                    htmlData = htmlData + "<td>"+ dataArr[i].salePrice +"</td>";
                    htmlData = htmlData + "<td>"+ dataArr[i].saleCount +"</td>";
                    htmlData = htmlData + "<td>"+ dataArr[i].saleAmount +"</td>";
                    var date = new Date(dataArr[i].createTime);
                    dateTime = date.toLocaleString();
                    htmlData = htmlData + "<td>"+ dateTime +"</td>";
                    // htmlData = htmlData + "<td><a href=\"/sale/find-id.do?id="+dataArr[i].id+"\">修改</a>|<a href=\"/sale/delete.do?id="+dataArr[i].id+"\">删除</a></td>";
                    htmlData = htmlData + "</tr>";
                });
                list = data.data;
                createPageNav({
                    $container : $("#paging"),
                    pageCount : data.pages,
                    currentNum : data.pageNum,
                    afterFun : function(num){
                        loadData(num,pageSize);
                    }
                });
                // createList(data.data);
//           createSelect(data);
//                 console.info(data);
                console.log(htmlData);
                $("tbody").html(htmlData);
            }
        });
    }

</script>
</body>
</html>