<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <%--<%@ include file="/taglib.jsp" %>--%>
</head>
<script>

    $(function () {

    });

</script>

<body>
<%@ include file="/view/common_test/head.jsp" %>
<div>
    <%@ include file="/view/common_test/menu.jsp" %>
    <div style="border: 1px solid red;width: 88%;height: 85%;float: right;">

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
                    <td></td>
                </tr>

            </c:forEach>

            </tbody>
        </table>

    </div>
</div>
</body>
</html>
