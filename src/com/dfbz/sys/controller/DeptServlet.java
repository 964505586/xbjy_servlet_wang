package com.dfbz.sys.controller;

import com.alibaba.fastjson.JSON;
import com.dfbz.sys.entity.Dept;
import com.dfbz.sys.service.impl.DeptServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/2 10:39
 * @description
 */
@WebServlet("/sys/dept/*")
public class DeptServlet extends BaseServlet {

    private DeptServiceImpl service = new DeptServiceImpl();

    public void listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Dept> list = service.listAll();
        String deptJsonStr = JSON.toJSONString(list);
        PrintWriter out = response.getWriter();
        out.append(deptJsonStr);
    }
}
