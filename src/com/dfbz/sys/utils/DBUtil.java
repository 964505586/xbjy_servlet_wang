package com.dfbz.sys.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/11/29 12:03
 * @description JdbcTemplate连接工具类
 */
public class DBUtil {

    private static DataSource dataSource;

    static {
        Properties pro = new Properties();
        InputStream in = DBUtil.class.getResourceAsStream("/com/db.properties");
        try {
            pro.load(in);
            try {
                dataSource = DruidDataSourceFactory.createDataSource(pro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据源
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
}
