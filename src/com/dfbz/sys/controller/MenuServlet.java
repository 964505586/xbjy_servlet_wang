package com.dfbz.sys.controller;

import com.alibaba.fastjson.JSON;
import com.dfbz.sys.entity.Menu;
import com.dfbz.sys.service.impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/11/29 15:10
 * @description 菜单控制器
 */
@WebServlet("/sys/menu")
public class MenuServlet extends HttpServlet {

    private MenuServiceImpl service = new MenuServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Menu> list = service.listAll();
        String listJsonStr = JSON.toJSONString(list);
        PrintWriter out = response.getWriter();
        out.append(listJsonStr);
    }
}
