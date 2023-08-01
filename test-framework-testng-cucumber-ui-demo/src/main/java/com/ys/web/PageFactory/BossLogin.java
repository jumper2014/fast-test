package com.ys.web.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ijumper on 2017/6/28.
 */
public class BossLogin {

    WebDriver driver;

    @FindBy(id="username")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="submit")
    WebElement submit;

    @FindBy(xpath="/html/body/div[3]/div/footer/ul/li[1]/a")
    WebElement exit;



    public BossLogin(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String strUsername) {
        username.sendKeys(strUsername);
    }

    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public void clickSubmit() {
        submit.click();

    }

    public void clickExit() {
        exit.click();
    }



    public void loginToBoss(String strUsername, String strPassword) {
        this.setUsername(strUsername);
        this.setPassword(strPassword);
        this.clickSubmit();
        this.clickExit();
    }






}
