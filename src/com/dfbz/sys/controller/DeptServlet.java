package com.dfbz.sys.controller;

import com.alibaba.fastjson.JSON;
import com.dfbz.sys.entity.Dept;
import com.dfbz.sys.entity.Page;
import com.dfbz.sys.service.impl.DeptServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

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

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Page page = new Page();

        String name = request.getParameter("name");
        name = name == null ? "" : name;
        page.setCount(service.getCount(name));

        String page1 = request.getParameter("page");
        Integer pageCurrent = page1 == null ? 1 : Integer.valueOf(page1);
        page.setPageCurrent(pageCurrent);

        List<Dept> list = service.deptList(name, page);

        request.setAttribute("list", list);
        request.setAttribute("name", name);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/view/sys/dept/list.jsp").forward(request, response);

    }

    /***
     * @decription 通过id删除
     * @author admin
     * @date 2019/12/5 13:25
     * @params [request, response]
     * @return void
     */
    public void delDeptById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (id == null) {
            return;
        }
        service.delDeptById(Integer.valueOf(id));
        response.sendRedirect("/sys/dept/list");
    }

//    public void deptNames(HttpServletRequest request, HttpServletResponse response) {
//        List<Dept> depts = service.deptList();
//        try {
//            PrintWriter out = response.getWriter();
//            String names = JSON.toJSONString(depts);
//            out.append(names);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /***
     * @decription 添加
     * @author admin
     * @date 2019/12/5 13:31
     * @params [request, response]
     * @return void
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        Dept dept = new Dept();
        BeanUtils.populate(dept, map);
        dept.setCreateBy(getLoginUser().getId());
        service.addDept(dept);
        response.sendRedirect("/sys/dept/list");
    }

    public void toUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        if (id == null) {
            response.sendRedirect("/sys/dept/list");
            return;
        }
        Dept dept = service.selectDeptById(Integer.valueOf(id));
        request.setAttribute("dept", dept);
        request.getRequestDispatcher("/view/sys/dept/update.jsp").forward(request, response);
    }

    /***
     * @decription 修改
     * @author admin
     * @date 2019/12/5 13:28
     * @params [request, response]
     * @return void
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        if (name == null || id == null) {
            response.sendRedirect("/sys/dept/list");
            return;
        }
        Dept dept = new Dept();
        dept.setName(name);
        dept.setId(Integer.valueOf(id));
        service.updateDeptById(dept);
        response.sendRedirect("/sys/dept/list");
    }

    /***
     * @decription 查询所有部门
     * @author admin
     * @date 2019/12/5 12:40
     * @params [request, response]
     * @return void
     */
    public void listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Dept> list = service.listAll();
        String deptJsonStr = JSON.toJSONString(list);
        PrintWriter out = response.getWriter();
        out.append(deptJsonStr);
    }
}
