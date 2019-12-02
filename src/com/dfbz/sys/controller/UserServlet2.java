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
//@WebServlet("/sys/user/*")
public class UserServlet2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求头   /sys/user/list
        String method = request.getRequestURI();
        String[] methodArr = method.split("/");
        method = methodArr[methodArr.length - 1];

        switch (method) {
            case "list":
                list(request, response);
                break;
            case "add":
                list(request, response);
                break;
        }

//        if ("list".equals(method)) {
//            this.list(request, response);
//        }
//
//        if ("add".equals(method)) {
//            this.list(request, response);
//        }

    }

    public void list(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("list");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("add");
    }

}
