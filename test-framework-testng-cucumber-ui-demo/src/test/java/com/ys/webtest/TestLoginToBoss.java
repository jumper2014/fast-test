package com.ys.webtest;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import com.ys.web.PageFactory.BossLogin;
import com.ys.webtest.SystemConstants;

/**
 * Created by ijumper on 2017/6/28.
 */
public class TestLoginToBoss {

    WebDriver driver;
    BossLogin objLogin;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SystemConstants.BOSSURL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void testLogin() {
        objLogin = new BossLogin(driver);
        objLogin.loginToBoss(SystemConstants.USER, SystemConstants.PASSWORD);
    }




}
