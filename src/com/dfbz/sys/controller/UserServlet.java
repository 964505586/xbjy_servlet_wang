package com.dfbz.sys.controller;

import com.dfbz.sys.entity.User;
import com.dfbz.sys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> list = service.listAll();
        request.setAttribute("list", list);

        request.getRequestDispatcher("/view/sys/user/list.jsp").forward(request, response);
    }


}
