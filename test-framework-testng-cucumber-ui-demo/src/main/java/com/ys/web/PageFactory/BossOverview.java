package com.ys.web.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ijumper on 2017/7/10.
 */
public class BossOverview {
    WebDriver driver;


    @FindBy(xpath="//*[@id=\"content\"]/div/div[1]/div[1]/div[2]/p[1]/span[2]/span[1]")
    WebElement todayFlow;

    @FindBy(xpath="//*[@id=\"content\"]/div/div[1]/div[2]/div[2]/p[1]/span[2]/span[1]")
    WebElement onlineNode;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div[3]/button[1]/span")
    WebElement grid;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div[3]/button[2]/i")
    WebElement table;

    @FindBy(xpath="//*[@id=\"chartType\"]")
    Select reportList;

    @FindBy(xpath = "//*[@id=\"chartType\"]/option[1]")
    WebElement flowSelect;

    @FindBy(xpath = "//*[@id=\"chartType\"]/option[2]")
    WebElement peerSelect;

    @FindBy(xpath = "//*[@id=\"chartType\"]/option[3]")
    WebElement bandWidthSelect;

    @FindBy(xpath = "//*[@id=\"chartType\"]/option[4]")
    WebElement effectiveBandWidthSelect;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div[2]")
    WebElement dateSelect;


    public BossOverview(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public String getTodayFlow() {
        return todayFlow.getText();
    }

    public String getOnlineNode() {
        return onlineNode.getText();
    }

    public void switchToGrid() {
        grid.click();
    }

    public void switchToTable() {
        table.click();
    }

    public void selectReport(String report) {
        switch(report) {
            case "flow":
                flowSelect.click();
//                reportList.selectByIndex(0);
                break;
            case "node":
                peerSelect.click();
//                reportList.selectByIndex(1);
                break;
            case "band":
                bandWidthSelect.click();
                break;
//                reportList.selectByIndex(2);
            case "effect":
                effectiveBandWidthSelect.click();
//                reportList.selectByIndex(3);
            default:
                flowSelect.click();
                break;
        }

    }
}
