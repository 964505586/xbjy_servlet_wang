package com.dfbz.sys.filters;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.dfbz.sys.constants.SysConstant;
import com.dfbz.sys.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/11/29 15:16
 * @description
 */
@WebFilter("/*")
public class SysFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        //获取请求头中的请求路径
        String uri = request.getRequestURI();

        //拦截到登录请求：localhost:8080/index.jsp
        //如果cookie中有值，则直接跳转到home.jsp（7天免登录实现方案），否则跳转到登录界面index.jsp
        if (uri.endsWith("index.jsp")) {
            //获取所有的cookie信息
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    //如果cookie中有登录信息，则直接跳转到home.jsp
                    if ("cookieLoginUser".equals(cookies[i].getName())) {
                        //获取cookie中的值，并解码，得到json字符串
                        String strJson = URLDecoder.decode(cookies[i].getValue(), "utf-8");
                        //把json字符串转换成java对象
                        User loginUser = JSON.parseObject(strJson, new TypeReference<User>() {
                        });
                        //把从cookie中取出的登陆信息放入到session中
                        session.setAttribute(SysConstant.SESSION_LOGIN_NAME, loginUser);

                        //登陆成功，跳转到home.jsp
                        response.sendRedirect("/view/common/home.jsp");
                    }
                }
            }
        } else if (uri.endsWith("/sys/login/login") || uri.endsWith("/sys/login/getPic")) {
            //直接放行登陆验证请求,图片验证码请求

        } else {
            //判断session中是否有登录信息，如果没有，则属于非法登陆，然后强制跳转到登录界面重新登录
            Object obj = session.getAttribute(SysConstant.SESSION_LOGIN_NAME);
            //非法登陆
            if (obj == null) {
                response.sendRedirect("/index.jsp");
            }
        }

        //放行
        filterChain.doFilter(request, response);
    }
}
