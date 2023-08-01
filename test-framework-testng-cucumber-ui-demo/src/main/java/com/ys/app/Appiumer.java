package com.ys.app;

import java.io.*;
import java.lang.Process;
import java.lang.Runtime;
import com.ys.util.Environment;
import com.ys.util.Path;

/**
 * Created by ijumper on 2017/6/14.
 */
public class Appiumer {


    public void startAppium() {

        if (!Global.appiumStarted)  {

            Runtime rt = Runtime.getRuntime();
            // this code for record the screen of your device
            try {

                Environment env = new Environment();
                String os = env.getOS();
                if (os.equals("Windows")) {
                    Process p = rt.exec("taskkill /F /IM node.exe");
                    p.waitFor();
                    String winRunAppiumCommand = String.format("cmd /C start appium -a 127.0.0.1 -p %s  -U %s --no-reset --session-override",
                            Constants.APPIUM_PORT, Constants.ANDROID_DEVICE);
                    Process process = rt.exec(winRunAppiumCommand);
                    Thread.sleep(1000);

                    //            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    //            String s;
                    //            while((s=bufferedReader.readLine()) != null) {
                    //                System.out.println(s);
                    //            }
                    //            process.waitFor();
                } else {

                    Process p = rt.exec("killall -9 node");
                    p.waitFor();
                    createAppiumShell("hello");
                    Path path = new Path();
                    String shscript = path.getCurrentPath() + "/misc/shell/run_appium.sh";
                    Process process = rt.exec(shscript);


                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Global.appiumStarted = true;
        }
        System.out.println("****** Appium is started ******");

    }


    public void createAppiumShell(String device){
        Path path = new Path();
        String shellPath = path.getCurrentPath()+"/misc/shell";
        String appiumShell = shellPath+"/run_appium.sh";
        File fout = new File(appiumShell);
        fout.setExecutable(true);//设置可执行权限
        fout.setReadable(true);//设置可读权限
        fout.setWritable(true);//设置可写权限

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));


            bw.write("!#/bin/sh");
            bw.newLine();
            String macRunAppiumCommand = String.format("appium -a 127.0.0.1 -p %s  -U %s --no-reset --session-override > %s/appium.log",
                    Constants.APPIUM_PORT, Constants.ANDROID_DEVICE, shellPath);
            bw.write(macRunAppiumCommand);
            bw.newLine();

            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Appiumer er = new Appiumer();
        er.createAppiumShell("hello");
    }

    public void stopAppium() {
        Runtime rt = Runtime.getRuntime();
        try {
            Process p = rt.exec("taskkill /F /IM node.exe");
            Global.appiumStarted = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
