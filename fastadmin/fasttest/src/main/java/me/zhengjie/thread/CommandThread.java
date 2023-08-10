package me.zhengjie.thread;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CommandThread implements Runnable {
    public void run() {
        try {
            // 创建一个ProcessBuilder对象，并设置要执行的命令
            ProcessBuilder processBuilder = new ProcessBuilder("putty.exe");

            // 设置命令的工作目录（可选）
            processBuilder.directory(new File("D:\\kit"));

            // 启动命令并等待其执行完成
            Process process = processBuilder.start();
            process.waitFor();

            // 获取命令输出（可选）
            InputStream inputStream = process.getInputStream();
            // 进行处理或读取输出流数据

            // 获取命令错误输出（可选）
            InputStream errorStream = process.getErrorStream();
            // 进行处理或读取错误输出流数据

            // 处理命令执行完成后的逻辑
            // 例如，更新数据库、发送通知等
        } catch (IOException | InterruptedException e) {
            // 处理异常
        }
    }
}
