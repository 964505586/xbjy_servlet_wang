package com.dfbz.sys.controller;

import com.dfbz.sys.constants.SysConstant;
import com.dfbz.sys.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/2 10:19
 * @description
 */
public class BaseServlet extends HttpServlet {

    //登陆信息
    private User loginUser = new User();

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取出session中的登陆信息
        HttpSession session = request.getSession();
        loginUser = (User) session.getAttribute(SysConstant.SESSION_LOGIN_NAME);

        //请求头   /sys/user/list
        String methodStr = request.getRequestURI();
        String[] methodArr = methodStr.split("/");
        methodStr = methodArr[methodArr.length - 1];

        //重点理解这里的this
        Class clazz = this.getClass();
        try {
            Method method = clazz.getDeclaredMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class);
            //暴力反射
            method.setAccessible(true);
            //  /sys/user/list
            //  /sys/dept/list
            //重点理解这里的this
            method.invoke(this, request, response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
