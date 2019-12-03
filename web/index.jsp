<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<form action="/sys/user/" method="get">
    账号：<input type="text" name="account" value=""><br><br>
    密码：<input type="text" name="password" value=""><br><br>
    <input type="submit" name="" value="登录">
</form>

<a href="/view/common/home.jsp">登录</a>

<a href="${path}/view/sys/user/forget.jsp">忘记密码？</a>
</body>
</html>
