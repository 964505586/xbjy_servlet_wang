package com.dfbz.sys.filters;

import com.dfbz.sys.constants.SysConstant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

        //获取请求路径
        String uri = request.getRequestURI();

        //直接放行index.jsp,登陆验证请求,图片验证码请求
        if (uri.endsWith("index.jsp") || uri.endsWith("/sys/login/login") || uri.endsWith("/sys/login/getPic")) {

        } else {
            HttpSession session = request.getSession();
            Object obj = session.getAttribute(SysConstant.SESSION_LOGIN_NAME);
            //非法登陆
            if (obj == null) {
                response.sendRedirect("/index.jsp");
            }
        }
        filterChain.doFilter(request, response);
    }
}
