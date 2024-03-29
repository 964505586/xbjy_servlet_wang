<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <script src="${path}/static/jquery-validation-1.9.0/jquery.validate.js"></script>
</head>
<style>
    .error {
        color: red;
    }

</style>

<body>
<%@include file="/view/common/head.jsp" %>
<div class="d-flex align-items-stretch">
    <%@include file="/view/common/menu.jsp" %>
    <div class="page-content">

        <%--主体部分start--%>
        <form action="/sys/user/add" method="get" id="form-add">
            <div class="form-group">
                <label>部门</label>
                <select id="dept" name="deptId" class="form-control">

                </select>
            </div>

            <div class="form-group">
                <label>账号</label>
                <input type="text" class="form-control" id="account" name="account" placeholder="请输入账号">
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="text" class="form-control" id="password" name="password" placeholder="请输入6位数字">
            </div>
            <div class="form-group">
                <label>姓名</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label>年龄</label>
                <input type="text" class="form-control" id="age" name="age">
            </div>
            <div class="form-group">
                <label>性别</label>
                <input type="radio" id="male" value="1" name="sex" checked><label for="male">男</label>
                <input type="radio" id="female" value="0" name="sex"><label for="female">女</label>
            </div>
            <div class="form-group">
                <label>邮箱</label>
                <input type="text" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label>出生日期</label>
                <input type="date" class="form-control" id="birthDate" name="birthDate">
            </div>
            <!--居中-->
            <div class="text-center">
                <button type="submit" class="btn btn-primary">保存</button>
                <button type="reset" class="btn btn-default">重置</button>
                <a href="/sys/user/list" class="btn btn-danger">返回</a>
            </div>
        </form>
        <%--主体部分end--%>

        <%@include file="/view/common/foot.jsp" %>
    </div>
</div>
</body>
<script>
    $(function () {

        //获取部门
        $.ajax({
            url: "/sys/dept/listAll",
            data: "",
            type: "get",
            dataType: "json",
            success: function (data) {
                var html = '<option value="-1">请选择</option>';
                for (var i = 0; i < data.length; i++) {
                    html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                }
                $("#dept").append(html);
            }
        });

        // 表单验证start
        $.validator.addMethod("checkAccount", function (value, element, params) {
            var reg = /^[0-9a-zA-Z]{5,10}$/;
            if (reg.test(value)) {
                return true;
            } else {
                return false;
            }
        });
        $("#form-add").validate({
            rules: {
                account: {
                    checkAccount: ""
                }
            },
            messages: {
                account: {
                    checkAccount: "请输入5-10位的账号！"
                }
            }
        });
        // 表单验证end

    })
    ;
</script>
</html>
