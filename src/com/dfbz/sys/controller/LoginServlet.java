package com.dfbz.sys.controller;

import com.alibaba.fastjson.JSON;
import com.dfbz.sys.constants.SysConstant;
import com.dfbz.sys.entity.User;
import com.dfbz.sys.service.impl.UserServiceImpl;
import com.dfbz.sys.utils.ImgCodeUtil;
import com.dfbz.sys.utils.MDUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/4 11:06
 * @description
 */
@WebServlet("/sys/login/*")
public class LoginServlet extends BaseServlet {

    private UserServiceImpl service = new UserServiceImpl();

    /***
     * @decription 验证账号和密码
     * @author admin
     * @date 2019/12/4 14:48
     * @params [user]
     * @return com.dfbz.sys.entity.User
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String picCode = request.getParameter("picCode");
        String remember = request.getParameter("remember");

        HttpSession session = request.getSession();

        //验证图片的验证码
        //从session中取出图片验证码，和前端输入的验证码做比较
//        Object obj = session.getAttribute(SysConstant.SESSION_PIC_CODE_NAME);
//        if (obj == null || !obj.toString().equals(picCode)) {
//            //图片验证码不正确
//            response.sendRedirect("/index.jsp");
//            return;
//        }

        //从数据库验证账号和密码
        User user = new User();
        user.setAccount(account);
        user.setPassword(MDUtil.md5(password));   //密文密码存入
        List<User> list = service.checkLogin(user);
        //账号或密码不正确，或系统存在相同的账号和密码
        if (list == null || list.size() == 0 || list.size() > 1) {
            //登录失败，跳转到登录界面
            response.sendRedirect("/index.jsp");
            return;
        } else {
            User loginUser = list.get(0);
            //全部验证通过，把登陆信息放入session,可以直接存对象loginUser
            session.setAttribute(SysConstant.SESSION_LOGIN_NAME, list.get(0));

            //在线人数
            ServletContext application = getServletContext();
            //取出application中的在线人数
            Object countObj = application.getAttribute(SysConstant.APPLICATION_LOGIN_COUNT);
            int count = 1;
            if (countObj != null) {
                count = Integer.valueOf(countObj.toString()) + 1;
            }
            //把新的在线人数存入application中
            application.setAttribute(SysConstant.APPLICATION_LOGIN_COUNT, count);

            //如果勾选7天免登录，则把登陆信息放入cookie，cookie中不能直接存对象，所以只能存入字符串
            if ("1".equals(remember)) {
                //cookie中的密码存入明文密码 方便填入密码框
                loginUser.setPassword(password);

                //cookie的值不能存特殊字符（" , :），所以提供2种解决方案
                String strJson = JSON.toJSONString(loginUser);
                //解决方案一：全部替换掉这些特殊字符
                // strJson=strJson.replace("\"","+");
                // strJson=strJson.replace(":","=");
                // strJson=strJson.replace(",","*");
                // strJson=strJson.replace(" ","%");

                //解决方案二：先编码，取值的时候再解码
                strJson = URLEncoder.encode(strJson, "utf-8");
                Cookie cookLoginUser = new Cookie(SysConstant.COOKIE_LOGIN_USER, strJson);
                //7天有效期（单位是秒）
                cookLoginUser.setMaxAge(7 * 24 * 60 * 60);
                //任何请求都能获取cookie
                cookLoginUser.setPath("/");
                response.addCookie(cookLoginUser);
            }

            //登录成功，跳转到home.jsp
            request.getRequestDispatcher("/view/common/home.jsp").forward(request, response);
            return;
        }
    }

    /***
     * @decription 获取图片验证码
     * @author admin
     * @date 2019/12/4 16:51
     * @params [request, response]
     * @return void
     */
    public void getPic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ImgCodeUtil imgCodeUtil = new ImgCodeUtil();
        //获取验证码图片
        BufferedImage image = imgCodeUtil.getImage();

        ////获取验证码文本内容
        String code = imgCodeUtil.getText();

        //把图片验证码存入session
        HttpSession session = request.getSession();
        session.setAttribute(SysConstant.SESSION_PIC_CODE_NAME, code);

        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(image, "jpeg", sos);
        sos.flush();
        sos.close();
    }
}
