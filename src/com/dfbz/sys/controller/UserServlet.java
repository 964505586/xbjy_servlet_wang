package com.dfbz.sys.controller;

import com.dfbz.sys.entity.Page;
import com.dfbz.sys.entity.User;
import com.dfbz.sys.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/11/29 15:10
 * @description
 */
@WebServlet("/sys/user/*")
public class UserServlet extends BaseServlet {

    private UserServiceImpl service = new UserServiceImpl();

    /**
     * @return void
     * @decription 查询
     * @author admin
     * @date 2019/12/2 15:39
     * @params [request, response]
     */
    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //查询条件
        String account = request.getParameter("account");
        account = account == null ? "" : account;

        //当前页
        String pageStr = request.getParameter("page");
        //查询总记录数
        Integer count = service.getCount(account);

        Page page = new Page();
        page.setCount(count);
        Integer pageCurrent = pageStr == null ? 1 : Integer.valueOf(pageStr);
        page.setPageCurrent(pageCurrent);

        List<User> list = service.listAll(account, page);
        //查询的数据
        request.setAttribute("list", list);
        //查询条件
        request.setAttribute("account", account);
        //分页信息
        request.setAttribute("page", page);

        request.getRequestDispatcher("/view/sys/user/list.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User();
        //获取请求体里面的数据
        Map<String, String[]> map = request.getParameterMap();
        BeanUtils.populate(user, map);

        service.add(user);
        response.sendRedirect("/sys/user/list");
    }


    /**
     * @return void
     * @decription 通过id删除
     * @author admin
     * @date 2019/12/2 16:21
     * @params [request, response]
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        if (id == null) {
            return;
        }
        service.deleteById(Integer.valueOf(id));
        response.sendRedirect("/sys/user/list");
    }
}
