package com.ys.sample;

import se.vidstige.jadb.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by ijumper on 2017/6/29.
 */
public class jadbs {

    public static void main(String[] args) {
        JadbConnection jadb = null;
        try {
            jadb = new JadbConnection();

            List<JadbDevice> devices = jadb.getDevices();
            for (JadbDevice device : devices) {
                System.out.println(device.getSerial());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JadbException e) {
            e.printStackTrace();
        }
    }
}
