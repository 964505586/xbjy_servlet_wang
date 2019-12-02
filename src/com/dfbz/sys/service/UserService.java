package com.dfbz.sys.service;

import com.dfbz.sys.entity.Page;
import com.dfbz.sys.entity.User;

import java.util.List;

public interface UserService {

    public List<User> listAll(String account, Page page);

    public Integer getCount(String account);

    public void add(User user);

    public void deleteById(Integer id);
}
