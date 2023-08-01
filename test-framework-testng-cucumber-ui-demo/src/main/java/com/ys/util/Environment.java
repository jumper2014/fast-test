package com.ys.util;

/**
 * Created by ijumper on 2017/6/27.
 */
public class Environment {

    public String getOS() {
        String os = System.getProperty("os.name");
//        System.out.println(os);
        if (os.indexOf("Windows") >= 0) {
            return "Windows";
        } else {
            return "MacOS";
        }

    }

    public static void main(String[] args) {
        Environment e = new Environment();
        System.out.println(e.getOS());
    }

}
