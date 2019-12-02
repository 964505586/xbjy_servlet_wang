package com.dfbz.sys.dao;

import com.dfbz.sys.entity.Page;
import com.dfbz.sys.entity.User;
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
public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());

    public List<User> list(String account, Page page) {
        String sql = "SELECT " +
                "d.NAME deptName," +
                "u.id id," +
                "u.account account," +
                "u.NAME name," +
                "u.age age," +
                "u.sex sex," +
                "u.birth_date birthDate," +
                "u.create_time createTime " +
                "FROM " +
                "sys_user u " +
                "LEFT JOIN sys_dept d ON u.dept_id = d.id " +
                "where u.account like ? limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class), "%" + account + "%", (page.getPageCurrent() - 1) * page.getPageSize(), page.getPageSize());
    }

    public Integer getCount(String account) {
        String sql = "select count(*) from sys_user where account like ?";
        return template.queryForObject(sql, Integer.class, "%" + account + "%");
    }

    public void add(User user) {
        String sql = "insert into sys_user (id,dept_id,account,password,name,age,sex,email,birth_date,create_time) values (null,?,?,?,?,?,?,?,?,?)";
        template.update(sql, user.getDeptId(), user.getAccount(), user.getPassword(), user.getName(), user.getAge(), user.getSex(), user.getEmail(), user.getBirthDate(), user.getCreateTime());
    }

    public void deleteById(Integer id) {
        String sql = "delete from sys_user where id = ?";
        template.update(sql, id);
    }
}