package com.example.framework.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Date {

    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static final SimpleDateFormat millSecondFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); // 用于生成MQ数据
    static final SimpleDateFormat zoneMillSecondFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");  // 暂时不用
    static final SimpleDateFormat dashSecondFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");  // 用于生成文件
    static final SimpleDateFormat secondFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    static final SimpleDateFormat eDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss.SSS zzz yyyy", Locale.ENGLISH);

    public static String getBatchDate(String orgDate) {
        if(orgDate!=null) {
            java.util.Date date = parse(orgDate, "yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
            return eDateFormat.format(date.getTime());
        } else return "";
    }

    // Today date 2020-10-10
    public static String getTodayDate() {
        java.util.Date todayDate = new java.util.Date();
        return dateFormat.format(todayDate.getTime());
    }

    public static String getTodayDateNoDash() {
        return getTodayDate().replace("-", "");
    }

    public static String getDateTime(Timestamp ts) {
        return millSecondFormat.format(ts);
    }

    //yesterday -1, tomorrow +1
    public static String getDateViaDayDiff(int dayDiff) {
        java.util.Date todayDate = new java.util.Date();
        java.util.Date date = new java.util.Date(todayDate.getTime() + dayDiff*24*60*60*1000L);
        return dateFormat.format(date.getTime());
    }

    public static String getYesterdayDate() {
        return getDateViaDayDiff(-1);
    }

    public static String getTomorrowDate() {
        return getDateViaDayDiff(1);
    }

    public static String getTodayDateTime() {
        java.util.Date todayDate = new java.util.Date();
        return millSecondFormat.format(todayDate.getTime());
    }

    public static String getReportDateTime() {
        java.util.Date todayDate = new java.util.Date();
        return dashSecondFormat.format(todayDate.getTime());
    }

    public static String getTodayDateTimeTran() {
        java.util.Date todayDate = new java.util.Date();
        return zoneMillSecondFormat.format(todayDate.getTime());
    }

    //yesterday -1, tomorrow +1
    public static String getDateTimeViaDayDiff(int dayDiff) {
        java.util.Date todayDate = new java.util.Date();
        java.util.Date date = new java.util.Date(todayDate.getTime() + dayDiff*24*60*60*1000L);
        return millSecondFormat.format(date.getTime());
    }

    //yesterday -1, tomorrow +1
    public static String getDateTimeViaSecDiff(int secDiff) {
        java.util.Date todayDate = new java.util.Date();
        java.util.Date date = new java.util.Date(todayDate.getTime() + secDiff*1000L);
        return millSecondFormat.format(date.getTime());
    }

    //yesterday -1, tomorrow +1
    public static String getDateTimeViaSecDiff(java.util.Date origin, int secDiff) {
        java.util.Date date = new java.util.Date(origin.getTime() + secDiff*1000L);
        return millSecondFormat.format(date.getTime());
    }

    public static Timestamp getTimestampViaDayDiff(int dayDiff) {
        java.util.Date todayDate = new java.util.Date();
        return new Timestamp(todayDate.getTime() + dayDiff*24*60*60*1000L);
    }

    public static java.util.Date strToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static boolean dateTimeWithin1Sec(String dateTime1, String dateTime2) {
        long diff = strToDate(dateTime1).getTime() - strToDate(dateTime2).getTime();
        return Math.abs(diff) <= 1500;
    }

    public static String removeMilli(String timeStr) {
        int length = timeStr.length();
        return timeStr.substring(0, length-4);
    }

    public static String removeSec(String timeStr) {
        int length = timeStr.length();
        return timeStr.substring(0, length-13);
    }

    // 格林威治时间转Date
    private static java.util.Date parse(String str, String pattern, Locale locale) {
        if (str == null || pattern == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(pattern, locale).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("today: " + getDateViaDayDiff(0));
        System.out.println("yesterday: " + getDateViaDayDiff(-1));
        System.out.println("tomorrow: " + getDateViaDayDiff(1));
        System.out.println("datetime: " + getTodayDateTime());
        System.out.println("datetime: " + removeMilli(getTodayDateTime()));
        System.out.println("45: " + getDateViaDayDiff(-45));
        System.out.println(getTodayDateTimeTran());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.out.println(getTimestampViaDayDiff(0));
        System.out.println(getTimestampViaDayDiff(1));

        String str = "2018-05-06 10:30:40";
           System.out.println(Timestamp.valueOf(str));
        str = "2018-05-06 10:30:40.000";
        System.out.println(Timestamp.valueOf(str));

        System.out.println(dateTimeWithin1Sec("2020-12-23 17:30:36", "2020-12-23 17:30:37"));
        System.out.println(dateTimeWithin1Sec("2020-12-23 17:30:35", "2020-12-23 17:30:34"));
        System.out.println(dateTimeWithin1Sec("2020-12-23 17:30:35", "2020-12-23 17:30:37"));
        System.out.println(dateTimeWithin1Sec("2020-12-23 17:30:35", "2020-12-23 17:30:33"));

        System.out.println(Timestamp.valueOf("2020-12-27 13:46:13.517"));
        System.out.println(Timestamp.valueOf("2020-12-27 13:46:13.518"));

        System.out.println(getBatchDate("2021-01-28 16:52:28.000"));


    }




}