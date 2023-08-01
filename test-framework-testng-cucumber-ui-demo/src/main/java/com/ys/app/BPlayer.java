package com.ys.app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import com.ys.util.Path;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.collections.functors.NonePredicate;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * Created by ijumper on 2017/6/5.
 */
public class BPlayer {

    public static AndroidDriver driver;

    public BPlayer() {
        if (Global.driver == null) {
            System.out.println("Session not created");

            // start appium
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("deviceName", Constants.ANDROID_DEVICE);
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("platformVersion", "6.0");

            // configure apk
            capabilities.setCapability("appPackage", Constants.DEMO_PACKAGE_NAME);
            capabilities.setCapability("appActivity", "MainActivity");
            //每次启动时覆盖session，否则第二次后运行会报错不能新建session
            capabilities.setCapability("sessionOverride", true);
            capabilities.setCapability("autoLaunch", false);
            //设置键盘
//        capabilities.setCapability("unicodeKeyboard", true);
//        capabilities.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘
            try {
                String url = String.format("http://%s:%s/wd/hub", Constants.LOCALHOST, Constants.APPIUM_PORT);
                driver = new AndroidDriver(new URL(url), capabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                Global.driver = driver;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


//        driver.quit();
        }
        else {
            System.out.println("Session already created");
        }
    }

    public void startPlayer() {
//        driver.startActivity(Constants.DEMO_PACKAGE_NAME,Constants.DEMO_ACTIVITY_NAME, null, null);
        driver.launchApp();

    }

    public boolean isPlayerInstalled() {
        return driver.isAppInstalled(Constants.DEMO_PACKAGE_NAME);
    }

    public void installPlayer() {
        String playerApk = Constants.DEMO_APK;
        System.out.print(playerApk);
        driver.installApp(playerApk);
    }

    public void removePlayer() {
        driver.removeApp(Constants.DEMO_PACKAGE_NAME);
    }




    public static void main( String[] args ) throws MalformedURLException {

        BPlayer player = new BPlayer();
        player.startPlayer();
    }

}
