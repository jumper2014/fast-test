package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaiduSearchPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BaiduSearchPage.class);

    private static final String elementDataFileName = elementDataFolder + "BaiduSearch_elements.xlsx";
    private static final String allElementsSheetName = "AllElements";

    public BaiduSearchPage(){
        super();
        setElementInfoMap(elementDataFileName, allElementsSheetName);
    }


    public BaiduSearchPage openWindow(String url) {
        logger.info("Open URL {}", url);
        WebDriver webDriver = this.getDriver();
        logger.info("Get driver");
        this.maximize();
        webDriver.get(url);
        this.waitForPageLoad(3);
        return this;
    }

    public void searchKeyword(String keyword) {
        this.setKeyword(keyword);
        this.clickSubmit();
    }

    public void setKeyword(String word) {
        WebElement wd = findElementByName("keywordInput");
        wd.sendKeys(word);    }


    public void clickSubmit() {
        WebElement submit = findElementByName("submitBtn");
        submit.click();
    }

    public void search(String word) {
        this.setKeyword(word);
        this.clickSubmit();
    }







}