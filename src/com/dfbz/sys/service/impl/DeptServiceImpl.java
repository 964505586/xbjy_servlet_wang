package com.dfbz.sys.service.impl;

import com.dfbz.sys.dao.DeptDao;
import com.dfbz.sys.entity.Dept;
import com.dfbz.sys.entity.Page;
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

    @Override
    public List<Dept> deptList(String name, Page page) {
        return deptDao.deptList(name, page);
    }

    @Override
    public Integer getCount(String name) {
        return deptDao.getCount(name);
    }

    @Override
    public void delDeptById(Integer id) {
        deptDao.delDeptById(id);
    }

    @Override
    public void addDept(Dept d) {
        d.setCreateTime(DateUtil.getDateStr());
        deptDao.addDept(d);
    }

    @Override
    public void updateDeptById(Dept dept) {
        deptDao.updateDeptById(dept);
    }

    @Override
    public Dept selectDeptById(Integer id) {
        return deptDao.selectDeptById(id);
    }

    @Override
    public List<Dept> listAll() {
        return deptDao.listAll();
    }

}
