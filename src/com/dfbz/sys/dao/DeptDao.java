package com.dfbz.sys.dao;

import com.dfbz.sys.entity.Dept;
import com.dfbz.sys.entity.Page;
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

    public List<Dept> deptList(String name, Page page) {
        String sql = "SELECT " +
                "u.NAME createName," +
                "d.id id," +
                "d.NAME NAME," +
                "d.create_time create_time," +
                "d.create_by create_by," +
                "ifnull ( a.counts, 0 ) countUser," +
                "a.deptId deptId " +
                "FROM " +
                "sys_dept d " +
                "LEFT JOIN ( SELECT count(*) counts, dept_id deptId FROM sys_user GROUP BY dept_id ) a ON d.id = a.deptId " +
                "LEFT JOIN sys_user u ON d.create_by = u.id " +
                "WHERE " +
                "d.NAME LIKE ? " +
                "ORDER BY " +
                "d.create_time DESC " +
                "LIMIT ?,? ";
        return template.query(sql, new BeanPropertyRowMapper<>(Dept.class), "%" + name + "%",
                ((page.getPageCurrent() - 1) * page.getPageSize()), page.getPageSize());
    }

    public Integer getCount(String name) {
        String sql = "select count(*) from sys_dept where name like ?";
        return template.queryForObject(sql, Integer.class, "%" + name + "%");
    }

    public void delDeptById(Integer id) {
        String sql = "delete from sys_dept where id = ?";
        template.update(sql, id);
    }

    public void addDept(Dept dept) {
        String sql = "insert into sys_dept(name,create_time,create_by) values (?,?,?)";
        template.update(sql, dept.getName(), dept.getCreateTime(), dept.getCreateBy());
    }

    public void updateDeptById(Dept dept) {
        String sql = "update sys_dept set name = ? where id = ?";
        template.update(sql, dept.getName(), dept.getId());
    }

    public Dept selectDeptById(Integer id) {
        String sql = "select * from sys_dept where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Dept.class), id);
    }

    public List<Dept> listAll() {
        String sql = "SELECT * from sys_dept";
        return template.query(sql, new BeanPropertyRowMapper<>(Dept.class));
    }

}
