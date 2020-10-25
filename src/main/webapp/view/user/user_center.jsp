<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JYH
  Date: 2020/10/21
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户中心</title>
</head>
<body>
    <div align="center">
        <h3><span style="color: red">用于查看当前登录用户信息的页面</span></h3>
        <h3><span style="color: red">有时间会更新</span></h3><br><br><br>
        <form action="/user/upload.do" method="post" enctype="multipart/form-data">
            请选择要上传的文件：<input type="file" name="upload"/>
            <input type="submit" value="上传"/>
        </form>
        ${fileName}
        <c:if test="${ver == '1024'}">
            <a href="/download.do?newFileName=${newFileName}&originalFileName=${fileName}">下载</a>
        </c:if>
    </div>
</body>
</html>
