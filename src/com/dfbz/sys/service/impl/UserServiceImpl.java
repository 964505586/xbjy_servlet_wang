package com.dfbz.sys.service.impl;

import com.dfbz.sys.dao.UserDao;
import com.dfbz.sys.entity.Page;
import com.dfbz.sys.entity.User;
import com.dfbz.sys.service.UserService;
import com.dfbz.sys.utils.DateUtil;
import com.dfbz.sys.utils.MDUtil;

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
    public List<User> list(String account, Page page) {
        return userDao.list(account, page);
    }

    /***
     * @decription 获取总记录数
     * @author admin
     * @date 2019/12/2 15:05
     * @params [account]
     * @return java.lang.Integer
     */
    public Integer getCount(String account) {
        return userDao.getCount(account);
    }

    /***
     * @decription 添加用户
     * @author admin
     * @date 2019/12/2 15:35
     * @params [user]
     * @return void
     */
    public void add(User user) {
        user.setPassword(MDUtil.md5(user.getPassword()));
        user.setCreateTime(DateUtil.getDateStr());
        user.setCreateBy(null);
        userDao.add(user);
    }

    /***
     * @decription 通过id删除
     * @author admin
     * @date 2019/12/2 16:19
     * @params [id]
     * @return void
     */
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    /***
     * @decription 通过id查询User
     * @author admin
     * @date 2019/12/3 10:07
     * @params [id]
     * @return com.dfbz.sys.entity.User
     */
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    /***
     * @decription 修改
     * @author admin
     * @date 2019/12/3 10:32
     * @params [user]
     * @return void
     */
    public void update(User user) {
        userDao.update(user);
    }

    /***
     * @decription 修改密码
     * @author admin
     * @date 2019/12/3 12:26
     * @params [user]
     * @return void
     */
    public void updatePassword(User user) {
        userDao.updatePassword(user);
    }
}
