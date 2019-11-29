package com.dfbz.sys.dao;

import com.dfbz.sys.entity.Menu;
import com.dfbz.utils.DBUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/11/29 15:02
 * @description
 */
public class MenuDao {

    private JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());

    public List<Menu> listAll() {
        //物理删除，逻辑删除  del_flag
        String sql = "select * from sys_menu";
        return template.query(sql, new BeanPropertyRowMapper<>(Menu.class));
    }
}
