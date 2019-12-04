<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<form action="/sys/login/login" method="get">
    账号：<input type="text" name="account" value="" id="account"><br><br>
    密码：<input type="text" name="password" value="" id="password"><br><br>
    7天免登录：<input type="checkbox" name="remember" value="1"><br><br>
    <input type="submit" name="" value="登录">
</form>

<a href="${path}/view/sys/login/forget.jsp">忘记密码？</a>

</body>
</html>
