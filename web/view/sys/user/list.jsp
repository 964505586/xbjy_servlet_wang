<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询用户</title>
    <%--<%@ include file="/taglib.jsp" %>--%>
</head>
<body>
<%@include file="/view/common/head.jsp" %>
<div class="d-flex align-items-stretch">
    <%@include file="/view/common/menu.jsp" %>
    <div class="page-content">

        <%--主体部分start--%>

        <form action="/sys/user/list" method="get">
            账号：<input type="text" value="${account}" name="account">
            开始时间：<input type="date" value="" name="">
            结束时间：<input type="date" value="" name=""><br>

            <input type="submit" value="查询" class="btn btn-primary">
        </form>

        <a href="/view/sys/user/add.jsp" class="btn btn-success">添加</a>

        <table class="table table-bordered">
            <thead>
            <tr>
                <th>序号</th>
                <th>部门名称</th>
                <th>账号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>创建时间</th>
                <th>创建人</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${list}" var="user" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${user.deptName}</td>
                    <td>${user.account}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>
                            <%--<c:if test="${user.sex==1}">男</c:if>--%>
                            <%--<c:if test="${user.sex==0}">女</c:if>--%>
                        <c:choose>
                            <c:when test="${user.sex==1}">男</c:when>
                            <c:when test="${user.sex==0}">女</c:when>
                            <c:otherwise>其他</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                            <%--把日期类型字符串转换成日期对象--%>
                        <fmt:parseDate var="birthDate" value="${user.birthDate}"
                                       pattern="yyyy-MM-dd"></fmt:parseDate>
                            <%--把日期对象转换成规定的字符串格式--%>
                        <fmt:formatDate value="${birthDate}" pattern="yyyy年MM月dd日"></fmt:formatDate>
                    </td>
                    <td>
                            <%--把日期类型字符串转换成日期对象--%>
                        <fmt:parseDate var="createTime" value="${user.createTime}"
                                       pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                            <%--把日期对象转换成规定的字符串格式--%>
                        <fmt:formatDate value="${createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                    </td>
                    <td>${user.createName}</td>
                    <td>
                        <a href="/sys/user/toUpdate?id=${user.id}" class="btn btn-danger">修改</a>
                        <a href="/sys/user/deleteById?id=${user.id}" class="btn btn-danger">删除</a>
                    </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>

        <a href="/sys/user/list?account=${account}&page=1">首页</a>
        <a href="/sys/user/list?account=${account}&page=${page.pageCurrent<=1 ? 1 : (page.pageCurrent-1)}">上一页</a>
        <a href="/sys/user/list?account=${account}&page=${page.pageCurrent>=page.pageCount ? page.pageCount : (page.pageCurrent+1) }">下一页</a>
        <a href="/sys/user/list?account=${account}&page=${page.pageCount}">末页</a>
        当前页：${page.pageCurrent},总页数：${page.pageCount}，总记录数：${page.count}

        <%--主体部分end--%>
        <%@include file="/view/common/foot.jsp" %>
    </div>
</div>
</body>
</html>
