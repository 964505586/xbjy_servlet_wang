package com.dfbz.sys.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/11/29 15:10
 * @description
 */
@WebServlet("/sys/user/*")
public class UserServlet extends BaseServlet {

    public void list(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("UserServlet list");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("UserServlet add");
    }

}
