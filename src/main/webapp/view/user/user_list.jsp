<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>模拟销售</title>
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
        <li>系统管理</li>
        <li>用户管理</li>
        <li>用户列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="" method="">
        <div class="form-group">
            <label class="" for="keyword">用户姓名：</label>
            <input type="text" name="keyword" class="form-control" id="keyword" placeholder="请输入用户姓名">
        </div>
        <input type="button" id="load" class="btn btn-danger" value="查询"/>
        &nbsp;&nbsp;
        <a class="btn btn-success" href="${pageContext.request.contextPath}/view/user/user_add.jsp">添加用户</a>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <thead>
        <th>用户编号</th>
        <th>用户姓名</th>
        <th>登陆账号</th>
        <th>电话</th>
        <th>微信号</th>
        <th>身份证号</th>
        <th>地址</th>
        <th>角色</th>
        <th>操作</th>
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
            url: "/user/all.do",
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
                    htmlData = htmlData + "<td>"+ dataArr[i].id +"</td>";
                    htmlData = htmlData + "<td>"+ dataArr[i].userName +"</td>";
                    htmlData = htmlData + "<td>"+ dataArr[i].loginAccount +"</td>";
                    htmlData = htmlData + "<td>"+ dataArr[i].tel +"</td>";
                    htmlData = htmlData + "<td>"+ dataArr[i].wxAccount +"</td>";
                    htmlData = htmlData + "<td>"+ dataArr[i].idNo +"</td>";
                    htmlData = htmlData + "<td>"+ dataArr[i].address +"</td>";
                    let role = dataArr[i].roleId;
                    let r;
                    if(role == 1){r = "管理员"}else{r = "普通用户"}
                    htmlData = htmlData + "<td>"+ r +"</td>";
                    htmlData = htmlData + "<td><a href=\"/user/find-id.do?id="+dataArr[i].id+"\">修改</a>|<a href=\"/user/delete.do?id="+dataArr[i].id+"\">删除</a></td>";
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
