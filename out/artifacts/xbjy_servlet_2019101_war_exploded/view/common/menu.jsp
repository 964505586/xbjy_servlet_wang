<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>menu</title>
</head>
<script>
    $(function () {
        //动态获取菜单栏
        $.ajax({
            url: "/sys/menu/menu",
            type: "get",
            data: "",
            dataType: "json",
            success: function (data) {
                var parent = data.parent;
                var son = data.son;
                var html = "";
                for (var i = 0; i < parent.length; i++) {
                    html = html + '<li>' +
                        '<a href="#hello' + i + '" data-toggle="collapse"> <i class="icon-windows"></i>' + parent[i].name + '</a>' +
                        '<ul id="hello' + i + '" class="collapse list-unstyled ">';
                    for (var j = 0; j < son.length; j++) {
                        if (parent[i].id == son[j].pId) {
                            html = html + '<li><a href="' + son[j].menuUrl + '">' + son[j].name + '</a></li>';
                        }
                    }
                    html = html + '</ul></li>';
                }

                $("#div-menu").append(html);
            }
        });

    });

</script>

<body>
<nav id="sidebar">
    <!-- Sidebar Header-->
    <div class="sidebar-header d-flex align-items-center">
        <div id="avatar" class="avatar"><img src="/static/img/avatar-6.jpg" alt="..."
                                             class="img-fluid rounded-circle"></div>
        <div class="title">
            <h1 class="h5">小标</h1>
            <p>研发部</p>
        </div>
    </div>
    <!-- Sidebar Navidation Menus-->
    <span class="heading">Main</span>
    <ul class="list-unstyled">
        <li class="active"><a href="${path}/view/common/home.jsp"> <i class="icon-home"></i>主页 </a></li>

        <div id="div-menu">

            <%--<li><a href="#userDropdown" data-toggle="collapse"> <i class="icon-windows"></i>系统管理</a>--%>
            <%--<ul id="userDropdown" class="collapse list-unstyled ">--%>
            <%--<li><a href="user.html">部门管理</a></li>--%>
            <%--<li><a href="/sys/user/list">用户管理</a></li>--%>
            <%--</ul>--%>
            <%--</li>--%>

            <%--<li><a href="#depDropdown" data-toggle="collapse"> <i class="icon-windows2"></i>部门列表</a>--%>
            <%--<ul id="depDropdown" class="collapse list-unstyled ">--%>
            <%--<li><a href="department.html">全部部门</a></li>--%>
            <%--<li><a href="meeting.html">会议系统</a></li>--%>
            <%--</ul>--%>
            <%--</li>--%>

        </div>
    </ul>

</nav>
</body>
</html>
