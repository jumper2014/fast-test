package me.zhengjie.utils.fasttest;

import java.io.File;

public class FileHelper {

    static public void createDir(String directoryPath) {

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("目录已成功创建！");
            } else {
                System.out.println("创建目录失败！");
            }
        } else {
            System.out.println("目录已存在！");
        }
    }
}
