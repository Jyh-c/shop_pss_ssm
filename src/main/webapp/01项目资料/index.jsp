<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>实训1-登录</title>
  </head>
  <body>
    <div align="center">
      <form action="../UserServlet?m=select" method="post">
        用户名：<input type="text" name="username"><br>
        密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password"><br>
        <input type="submit" value="登录">
        <a href="register.jsp"><button type="button">注册</button></a><br>
      </form>
    </div>
  </body>
</html>