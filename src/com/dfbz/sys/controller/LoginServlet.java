package com.dfbz.sys.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/4 11:06
 * @description
 */
@WebServlet("/sys/login/*")
public class LoginServlet extends BaseServlet {

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("/view/common/home.jsp").forward(request, response);
    }
}
