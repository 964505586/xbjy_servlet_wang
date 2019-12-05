<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/view/common/head.jsp" %>
<div class="d-flex align-items-stretch">
    <%@include file="/view/common/menu.jsp" %>
    <div class="page-content">

        <%--主体部分start--%>
        <form action="/sys/dept/add" method="get" id="form-add">
            <div class="form-group">
                <label>部门</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入部门" required>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">添加</button>
                <button type="reset" class="btn btn-default">重置</button>
                <a href="/sys/dept/list" class="btn btn-danger">返回</a>
            </div>
        </form>
        <%--主体部分end--%>

        <%@include file="/view/common/foot.jsp" %>
    </div>
</div>
</body>
</html>
