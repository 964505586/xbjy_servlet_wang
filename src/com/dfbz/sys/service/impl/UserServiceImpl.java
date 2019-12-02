package com.dfbz.sys.service.impl;

import com.dfbz.sys.dao.UserDao;
import com.dfbz.sys.entity.User;
import com.dfbz.sys.service.UserService;

import java.util.List;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/2 11:28
 * @description
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    /**
     * @return java.util.List<com.dfbz.sys.entity.User>
     * @decription 查询用户
     * @author admin
     * @date 2019/12/2 12:04
     * @params []
     */
    public List<User> listAll() {
        return userDao.listAll();
    }
}
