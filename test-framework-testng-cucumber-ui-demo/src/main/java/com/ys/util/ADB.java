package com.ys.util;

import java.io.IOException;
import java.util.ArrayList;
import com.ys.util.Executor;
import com.ys.util.Printer;

/**
 * Created by ijumper on 2017/6/21.
 */
public class ADB {

    public ArrayList<String> adbShell(String device, String cmd) {
        String command = String.format("adb -s %s shell %s", device, cmd);
        System.out.println("Adb command is " + command);
        Executor e = new Executor();
        return e.run(command);
    }


    public static void main(String[] args) {
        ADB adb = new ADB();
        ArrayList<String> res = adb.adbShell("3DN7N16C06002932", "ls");
        new Printer().printlns(res);
    }

}
