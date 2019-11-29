package com.dfbz.sys.service.impl;

import com.dfbz.sys.dao.MenuDao;
import com.dfbz.sys.entity.Menu;
import com.dfbz.sys.service.MenuService;

import java.util.List;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/11/29 15:06
 * @description 菜单ServiceImpl
 */
public class MenuServiceImpl implements MenuService {

    private MenuDao menuDao = new MenuDao();

    /***
     * @decription 查询所有菜单
     * @author admin
     * @date 2019/11/29 15:08
     * @params []
     * @return java.util.List<com.dfbz.sys.entity.Menu>
     */
    @Override
    public List<Menu> listAll() {
        return menuDao.listAll();
    }
}
