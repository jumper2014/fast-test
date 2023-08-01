package com.ys.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ijumper on 2017/6/21.
 */
public class Executor {

    public ArrayList<String> run(String cmd) {
        Runtime rt = Runtime.getRuntime();
        ArrayList<String> ret = new ArrayList();
        Process process = null;
        try {
            process = rt.exec(cmd);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
//            int i = 0;
            while((s=bufferedReader.readLine()) != null) {
                if (!s.trim().equals("") ) {
//                    i++;
//                    System.out.println(String.format("[%s]%d", s, i));
                    ret.add(s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }


    public static void main(String[] args) throws IOException {

        Executor e = new Executor();
        ArrayList<String> res = e.run("cmd /c dir ");
        for(String tmp: res) {
            System.out.println(tmp);
        }



    }



}
