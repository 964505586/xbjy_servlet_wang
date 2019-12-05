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
        <form action="/sys/dept/list" method="get">
            部门名称：<input type="text" value="${name}" name="name"><br><br>
            <input type="submit" value="查询" class="btn btn-primary">
        </form>

        <a href="/view/sys/dept/add.jsp" class="btn btn-success">添加</a>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>序号</th>
                <th>部门名称</th>
                <th>创建时间</th>
                <th>创建人</th>
                <th>部门人数</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${list}" var="dept" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${dept.name}</td>
                    <td>
                        <fmt:parseDate value="${dept.createTime}" var="deptTime"
                                       pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                        <fmt:formatDate value="${deptTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate>
                    </td>
                    <td>${dept.createName}</td>
                    <td>${dept.countUser}</td>

                    <td><a href="/sys/dept/delDeptById?id=${dept.id}">删除</a>
                        <a href="/sys/dept/toUpdate?id=${dept.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="/sys/dept/list?name=${name}&page=1">首页</a>
        <a href="/sys/dept/list?name=${name}&page=${page.pageCurrent <= 1 ? 1 : (page.pageCurrent-1)}">上一页</a>
        当前页数：${page.pageCurrent}， 总页数：${page.pageCount}， 总记录数：${page.count}， 每页显示数量：${page.pageSize}
        <a href="/sys/dept/list?name=${name}&page=${page.pageCurrent >= page.pageCount ? page.pageCount : page.pageCurrent+1}">下一页</a>
        <a href="/sys/dept/list?name=${name}&page=${page.pageCount}">尾页</a>

        <%--主体部分end--%>
        <%@include file="/view/common/foot.jsp" %>
    </div>
</div>
</body>
</html>
