package com.dfbz.sys.dao;

import com.dfbz.sys.entity.Dept;
import com.dfbz.sys.utils.DBUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/2 11:27
 * @description
 */
public class DeptDao {

    private JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());

    public List<Dept> listAll() {
        String sql = "SELECT * from sys_dept";
        return template.query(sql, new BeanPropertyRowMapper<>(Dept.class));
    }

}
