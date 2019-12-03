package com.dfbz.sys.controller;

import com.dfbz.sys.constants.SysConstant;
import com.dfbz.sys.entity.Dept;
import com.dfbz.sys.entity.Page;
import com.dfbz.sys.entity.User;
import com.dfbz.sys.service.impl.DeptServiceImpl;
import com.dfbz.sys.service.impl.UserServiceImpl;
import com.dfbz.sys.utils.MDUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    private DeptServiceImpl deptService = new DeptServiceImpl();

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

        List<User> list = service.list(account, page);
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

    /***
     * @decription 通过id查询User
     * @author admin
     * @date 2019/12/3 10:09
     * @params [request, response]
     * @return void
     */
    public void toUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //查询所有部门
        List<Dept> deptList = deptService.listAll();

        String id = request.getParameter("id");
        if (id == null) {
            return;
        }
        User user = service.getUserById(Integer.valueOf(id));

        request.setAttribute("user", user);
        // request.setAttribute("deptList", deptList);
        request.getRequestDispatcher("/view/sys/user/update.jsp").forward(request, response);
    }

    /***
     * @decription 修改
     * @author admin
     * @date 2019/12/3 10:29
     * @params [request, response]
     * @return void
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User();
        Map<String, String[]> map = request.getParameterMap();
        BeanUtils.populate(user, map);
        service.update(user);
        response.sendRedirect("/sys/user/list");
    }

    /***
     * @decription 修改密码
     * @author admin
     * @date 2019/12/3 12:29
     * @params [request, response]
     * @return void
     */
    public void forgetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        //前端输入的验证码
        String code = request.getParameter("code");

        HttpSession session = request.getSession();
        //取出session中的code
        Object object = session.getAttribute(SysConstant.SESSION_EMAIL_CODE_NAME);

        //比较前端输入的code和session中的code
        if (object == null || !code.equals(object.toString())) {
            response.sendRedirect("/view/sys/user/forget.jsp");
            return;
        }

        User user = new User();
        user.setAccount(account);
        user.setPassword(MDUtil.md5(password));
        service.updatePassword(user);
        //修改完毕，跳转到登录界面
        response.sendRedirect("/index.jsp");

    }

}
