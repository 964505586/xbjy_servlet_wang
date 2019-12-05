package com.dfbz.sys.service;

import com.dfbz.sys.entity.Dept;
import com.dfbz.sys.entity.Page;

import java.util.List;

public interface DeptService {

    List<Dept> deptList(String account, Page page);

    Integer getCount(String name);

    void delDeptById(Integer id);

    void addDept(Dept d);

    void updateDeptById(Dept dept);

    Dept selectDeptById(Integer id);

    public List<Dept> listAll();

}
