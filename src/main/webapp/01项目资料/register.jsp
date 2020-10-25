<%--
  Created by IntelliJ IDEA.
  User: JYH
  Date: 2020/8/25
  Time: 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <div align="center">
        <form action="../login?m=add" method="post">
            用户名：<input type="text" name="username"><br>
            密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password"><br>
            <input type="submit" value="注册">
            <input type="reset" value="重置">
        </form>
        <a href="../login.jsp">返回登录页面</a>
    </div>
</body>
</html>
