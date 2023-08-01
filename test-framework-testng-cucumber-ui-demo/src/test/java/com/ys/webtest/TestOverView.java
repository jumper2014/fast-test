package com.ys.webtest;


import com.ys.web.PageFactory.BossLogin;
import com.ys.web.PageFactory.BossOverview;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

/**
 * Created by ijumper on 2017/6/28.
 */
public class TestOverView {

    WebDriver driver;
    BossLogin objLogin;
    BossOverview objOverview;

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


    @Test(groups = {"check"})
    public void testFlow() {
        // login to boss
        objLogin = new BossLogin(driver);
        objLogin.loginToBoss(SystemConstants.USER, SystemConstants.PASSWORD);

        // enter overview page
        objOverview = new BossOverview(driver);
        String todayFlow = objOverview.getTodayFlow();
        System.out.println(todayFlow);
        Assert.assertEquals(todayFlow, "0.00");
    }


    @Test(groups = {"check"})
    public void testSwitchTable() {
        // login to boss
        objLogin = new BossLogin(driver);
        objLogin.loginToBoss(SystemConstants.USER, SystemConstants.PASSWORD);

        // enter overview page
        objOverview = new BossOverview(driver);
        try {
            Thread.sleep(1000);
            objOverview.switchToTable();
            Thread.sleep(1000);
            objOverview.switchToGrid();
            Thread.sleep(1000);
            objOverview.switchToTable();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(groups = {"check"})
    public void testTotalNodes() {
        // login to boss
        objLogin = new BossLogin(driver);
        objLogin.loginToBoss(SystemConstants.USER, SystemConstants.PASSWORD);

        // enter overview page
        objOverview = new BossOverview(driver);
        String onlineNode = objOverview.getOnlineNode();
        System.out.println(onlineNode);
        int nodeNum = Integer.valueOf(onlineNode).intValue();
        Assert.assertTrue(nodeNum > 400);
    }

    @Test(groups = {"check"})
    public void testSwitchReport() {
        // login to boss
        objLogin = new BossLogin(driver);
        objLogin.loginToBoss(SystemConstants.USER, SystemConstants.PASSWORD);

        // enter overview page
        objOverview = new BossOverview(driver);
        try {
            Thread.sleep(1000);
            objOverview.selectReport("node");
            Thread.sleep(1000);
            objOverview.selectReport("band");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
