package com.dfbz.sys.dao;

import com.dfbz.sys.entity.User;
import com.dfbz.utils.DBUtil;
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

    public List<User> listAll() {
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
                "LEFT JOIN sys_dept d ON u.dept_id = d.id";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

}
