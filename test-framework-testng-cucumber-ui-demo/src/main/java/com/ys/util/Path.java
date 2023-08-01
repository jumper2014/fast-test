package com.ys.util;

/**
 * Created by ijumper on 2017/6/21.
 */
public class Path {

    public String getCurrentPath() {
        return System.getProperty("user.dir");
    }


    public static void main(String[] args) {
        Path p = new Path();
        System.out.println(p.getCurrentPath());
    }

}
