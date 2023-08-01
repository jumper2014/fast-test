package com.ys.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ijumper on 15/9/22.
 * 用于执行shell命令
 */
public class CommandRunner {

    public void run(String commandLine) {

        Process p = null;
        try {
            p = Runtime.getRuntime().exec(commandLine);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = reader.readLine())!= null){
                System.out.println(line);
            }
            p.waitFor();
            is.close();
            reader.close();
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String [] args) {

        CommandRunner runner = new CommandRunner();
        runner.run("ls");

    }
}
