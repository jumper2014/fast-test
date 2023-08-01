package com.ys.app;

/**
 * Created by ijumper on 2017/6/21.
 */

import com.ys.util.Path;

public final class Constants {

    public final static String APPIUM_PORT = "4723";
    public final static String LOCALHOST = "127.0.0.1";
    public final static String ANDROID_DEVICE = "3DN7N16C06002932";
    public final static String ANDROID_PLATFORM = "Android";
    public final static String ANDROID_VERSION = "6.0";
//    public final static String ANDROID_HOST = "192.168.2.105";
    public final static String ANDROID_HOST = "192.168.124.15";

    // ----------------------------------------
    // Application related const
    // ----------------------------------------
    public final static String ROOT_PATH = new Path().getCurrentPath();
    public final static String MISC_PATH = ROOT_PATH + "/misc";
    public final static String APK_PATH = MISC_PATH + "/sdk/apk";
    public final static String DEMO_APK = APK_PATH + "/aplayer-3.11.10Release.apk";
    public final static String DEMO_PACKAGE_NAME = "com.cloutropy.bplayer";
    public final static String DEMO_ACTIVITY_NAME = "MainActivity";


    // ----------------------------------------
    // SDK related const
    // ----------------------------------------
    public final static String YUNSHANG_CONF = "/sdcard/yunshang/yunshang.conf";
    public final static String SDK_PORT = "32717";
    public final static String SDK_VERION = "3.11.10";
    public final static int PEER_ID_LENGTH = 32;

    // ----------------------------------------
    // SDK dashboard related const
    // ----------------------------------------
    public final static String VERSION_URL = "/version";


    // ----------------------------------------
    // Live Channel for Testing
    // ----------------------------------------
    public final static String CHANNEL1 = "live_flv/user/yunduan?url=http://rtmpp2p.meixiu98.com/live/livestream.flv";


}
