package com.ys.util;

import java.util.ArrayList;

/**
 * Created by ijumper on 2017/6/21.
 */
public class Printer {
    public void printlns(ArrayList<String> res) {
        System.out.println(res.size());
        for(String tmp: res) {
            System.out.print(tmp.trim());
            System.out.println();
        }
    }
}
