package com.dfbz.sys.service;

import com.dfbz.sys.entity.Page;
import com.dfbz.sys.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    public List<User> list(String account, Page page);

    public Integer getCount(String account);

    public void add(User user);

    public void deleteById(Integer id);

    public User getUserById(Integer id);

    public void update(User user);

    public void updatePassword(User user);

    public List<User> checkLogin(User user);

}
