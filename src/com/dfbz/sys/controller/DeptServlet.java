package com.dfbz.sys.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/2 10:39
 * @description
 */
@WebServlet("/sys/dept/*")
public class DeptServlet extends BaseServlet {

    public void list(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("DeptServlet list");
    }
}
