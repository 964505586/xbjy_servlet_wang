<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/form-elements.css">
    <link rel="stylesheet" href="/static/css/font-awesome.min.css">
    <title>登录</title>
    <style>
        body {
            background: url("/static/img/bg.jpg") no-repeat fixed;
            background-size: cover;
            overflow: hidden;
        }

    </style>
</head>
<body>

<%--<form action="/sys/login/login" method="get">--%>
<%--账号：<input type="text" name="account" value="" id="account"><br><br>--%>
<%--密码：<input type="text" name="password" value="" id="password"><br><br>--%>
<%--<img src="/sys/login/getPic" alt="无法加载" id="img" onclick="getPic()">--%>
<%--验证码：<input type="text" name="picCode" value="" ><br><br>--%>
<%--7天免登录：<input type="checkbox" name="remember" value="1"><br><br>--%>
<%--<input type="submit" name="" value="登录">--%>
<%--</form>--%>

<div class="container myBox">
    <div class="col-xs-8 col-xs-offset-3 col-sm-6 form-box">
        <div class="form-top">
            <div class="form-top-left">
                <h3>小标交友</h3>
                <p>请输入您的信息:</p>
            </div>
            <div class="form-top-right">
                <i class="fa fa-key"></i>
            </div>
        </div>
        <div class="form-bottom">
            <form role="form" action="/sys/login/login" method="post" class="login-form">

                <!--上面的输入框尽可能不需要外边距，使用row解决-->
                <div class="row">
                    <div class="form-group">
                        <label class="sr-only" for="account">Username</label>
                        <input type="text" name="account" placeholder="账号" id="account" style="width: 200%;">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label class="sr-only" for="password">Password</label>
                        <input type="password" name="password" placeholder="密码" id="password" style="width: 200%;">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <%--点击获取新的验证码--%>
                        <img src="/sys/login/getPic" alt="无法加载" id="img" onclick="getPic()">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label class="sr-only" for="picCode">验证码</label>
                        <input type="text" name="picCode" placeholder="验证码" id="picCode" style="width: 200%;">
                    </div>
                </div>
                <!--上面的输入框尽可能不需要外边距，使用row包裹起来解决-->

                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="remember" value="1">7天免登录
                    </label>
                </div>
                <button type="submit" class="btn">登录</button>

                <div class="row">
                    <div style="padding: 10px 25px">
                        <div style="display: inline-block;float: left" class="text-left"><a
                                href="${path}/view/sys/login/forget.jsp">忘记密码?</a></div>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
<!-- Javascript -->
<script src="${path}/static/js/jquery-1.11.1.js"></script>
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="${path}/static/js/jquery.backstretch.js"></script>
<script src="${path}/static/js/scripts.js"></script>
<script>
    function getPic() {
        // $("#img").attr("src", $("#img").attr("src") + "?nocache="+new Date().getTime());
        document.getElementById("img").src = document.getElementById("img").src + "?nocache=" + new Date().getTime();
    }
</script>
</html>
