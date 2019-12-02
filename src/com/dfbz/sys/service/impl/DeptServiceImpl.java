package com.dfbz.sys.service.impl;

import com.dfbz.sys.dao.DeptDao;
import com.dfbz.sys.entity.Dept;
import com.dfbz.sys.service.DeptService;
import com.dfbz.sys.utils.DateUtil;

import java.util.List;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/2 11:28
 * @description
 */
public class DeptServiceImpl implements DeptService {

    private DeptDao deptDao = new DeptDao();

    public List<Dept> listAll() {
        return deptDao.listAll();
    }

}
