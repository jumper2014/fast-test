package com.ys.util;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Created by ijumper on 15/11/7.
 */
public class DateHelper {

    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String time = format.format(date);
        return time;
    }
}