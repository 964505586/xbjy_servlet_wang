package com.dfbz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/2 15:37
 * @description
 */
public class DateUtil {

    public static String getDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

}
