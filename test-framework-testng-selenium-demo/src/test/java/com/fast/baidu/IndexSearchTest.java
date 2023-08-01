package com.fast.baidu;

import com.fast.constant.Constant;
import com.fast.pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import static com.fast.constant.Constant.DRIVER_PATH;

public class IndexSearchTest {

    WebDriver driver;
    IndexPage indexPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constant.URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void searchKeyword() throws InterruptedException {
        indexPage = new IndexPage(driver);
        indexPage.search("fasttest");
        Thread.sleep(3*1000);
    }
}
