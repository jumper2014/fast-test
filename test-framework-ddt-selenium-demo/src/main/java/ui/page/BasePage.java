package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestNG;
import ui.element.ElementInfo;
import utils.ElementInfoUtil;
import utils.dataReaders.ConfigReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    public static final String elementDataFolder = System.getProperty("user.dir") + "/src/test/data/elements/";
    public static final String configFolder = System.getProperty("user.dir") + "/config/";

    //测试环境的配置信息关键字
    private static final String browserKeyWord = "test_browser";
    //浏览器配置信息关键字
    private static final String browserPropKeySuffix = "_driver_propkey";
    private static final String browserDriverFileSuffix = "_driver_file";

    private static final String KEYWORDS_DELEMETER = ":";

    //要操作一个页面，页面需要一个叫驱动器的属性
    private WebDriver driver;
    private String browser;

    //每个页面需要一个页面元素列表，但初始化推后到具体的操作方法中
    public Map<String, ElementInfo> elementInfoMap;

    public BasePage() {

        try {
            browser = ConfigReader.getSettingProp(browserKeyWord);
            String propKey = ConfigReader.getBrowserProp(browser + browserPropKeySuffix);
            String driverFileName = ConfigReader.getBrowserProp(browser + browserDriverFileSuffix);
            System.setProperty(propKey, driverFileName);
        } catch (Exception e) {
            logger.error(e.toString());
        }

        if ("Chrome".equalsIgnoreCase(browser)) {
            driver = new ChromeDriver();
        } else if ("IE".equalsIgnoreCase(browser)) {
            driver = new InternetExplorerDriver();
        } else if ("Firefox".equalsIgnoreCase(browser)) {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();
        } else if ("Edge".equalsIgnoreCase(browser)) {
            driver = new EdgeDriver();
        }
        waitForPageLoad(10);
    }


    public BasePage(WebDriver driverParam) {
        driver = driverParam;
        waitForPageLoad(10);
    }

    /**
     * 取得当前页面的Driver
     */
    public WebDriver getDriver() {
        return driver;
    }


    /**
     * 按某种类型和关键字查找某个页面元素
     *
     * @param type 类型
     * @param key  查找信息
     * @return 返回页面元素
     */
    public WebElement findElementBy(String type, String key) {
        WebElement element = null;
        if ("id".equalsIgnoreCase(type)) {
            element = driver.findElement(By.id(key));
        } else if ("name".equalsIgnoreCase(type)) {
            element = driver.findElement(By.name(key));
        } else if ("xpath".equalsIgnoreCase(type)) {
            element = driver.findElement(By.xpath(key));
        } else if ("css".equalsIgnoreCase(type)) {
            element = driver.findElement(By.cssSelector(key));
        } else if ("tag".equalsIgnoreCase(type)) {
            element = driver.findElement(By.tagName(key));
        } else if ("text".equalsIgnoreCase(type)) {
            element = driver.findElement(By.linkText(key));
        }
        return element;
    }

    /**
     * 通过元素名称找到By信息
     *
     * @param elementName 元素名称
     * @return 返回By
     */
    public By getBy(String elementName) {
        By elementBy = null;

        ElementInfo elementInfo = elementInfoMap.get(elementName);
        String type = elementInfo.getType();
        String searchClue = elementInfo.getLocationClue();

        if ("id".equalsIgnoreCase(type)) {
            elementBy = By.id(searchClue);
        } else if ("name".equalsIgnoreCase(type)) {
            elementBy = By.name(searchClue);
        } else if ("xpath".equalsIgnoreCase(type)) {
            elementBy = By.xpath(searchClue);
        }
        return elementBy;
    }

    /**
     * 通过元素名称找到查找线索
     *
     * @param elementName 元素名称
     * @return 返回By
     */
    public String getSearchClue(String elementName) {
        String searchClue = "";

        try {
            ElementInfo elementInfo = elementInfoMap.get(elementName);
            searchClue = elementInfo.getLocationClue();
        } catch (Exception e) {
            logger.info("ElementName{}在元素信息列表文件中没有配置", elementName);
            e.printStackTrace();
        }
        return searchClue;
    }

    /**
     * 通过元素信息对象找到By信息
     *
     * @param elementInfo 元素信息对象
     * @return 返回By
     */
    public By getBy(ElementInfo elementInfo) {
        By elementBy = null;

        String type = elementInfo.getType();
        String searchClue = elementInfo.getLocationClue();

        if ("id".equalsIgnoreCase(type)) {
            elementBy = By.id(searchClue);
        } else if ("name".equalsIgnoreCase(type)) {
            elementBy = By.name(searchClue);
        } else if ("xpath".equalsIgnoreCase(type)) {
            elementBy = By.xpath(searchClue);
        }
        return elementBy;
    }

    /**
     * 輸入搜索后下拉列表中选择某选项
     *
     * @param fieldName           选择输入框名字
     * @param clueAndItemKeyWords 搜索下拉框輸入的關鍵字
     * @param dropdownListName    下拉列表的名字，定义在Page Class和element excel文件中
     * @param waitSec             等待下拉列表出现的最长等待时间
     */
    public void searchThenSelect(String fieldName, String clueAndItemKeyWords, String dropdownListName, int waitSec, String hideItemBtn) {
        WebElement element = findElementByName(fieldName);
        searchThenSelect(element, clueAndItemKeyWords, dropdownListName, waitSec, hideItemBtn);
    }

    /**
     * 輸入搜索后下拉列表中选择某选项
     *
     * @param field               选择输入框
     * @param clueAndItemKeyWords 搜索下拉框輸入的關鍵字
     * @param dropdownListName    下拉列表的名字，定义在Page Class和element excel文件中
     * @param waitSec             等待下拉列表出现的最长等待时间
     */
    public void searchThenSelect(WebElement field, String clueAndItemKeyWords, String dropdownListName, int waitSec, String hideItemBtn) {
        String[] clueAndItemKeyWordArray = clueAndItemKeyWords.split(KEYWORDS_DELEMETER);
        fillInputBox(field, clueAndItemKeyWordArray[0]);
        logger.info("可搜索输入框{}中先输入关键字{}进行查找", field.getText(), clueAndItemKeyWordArray[0]);
        forceWait(2);//强制等待2秒，等所以下拉列表的元素都加载完成
        selectOneItem(dropdownListName, clueAndItemKeyWordArray[1], waitSec, hideItemBtn, true);
    }

    /**
     * Click Dropdown list后从下拉列表中选择某选项
     *
     * @param fieldName    Dropdown List的名字
     * @param itemListName 下拉列表的名字，定义在Page Class和element excel文件中
     * @param itemKeyword  选项名称关键字
     * @param waitSec      等待下拉列表出现的最长等待时间
     */
    public void directSelect(String fieldName, String itemListName, String itemKeyword, int waitSec, String hideItemBtn) {
        WebElement element = findElementByName(fieldName);
        directSelect(element, itemListName, itemKeyword, waitSec, hideItemBtn, false);
    }

    /**
     * Click Dropdown list后从下拉列表中选择某选项
     *
     * @param fieldName    Dropdown List的名字
     * @param itemListName 下拉列表的名字，定义在Page Class和element excel文件中
     * @param itemKeyword  选项名称关键字
     * @param waitSec      等待下拉列表出现的最长等待时间
     */
    public void directSelect(String fieldName, String itemListName, String itemKeyword, int waitSec, String hideItemBtn, boolean itemHideFlag) {
        WebElement element = findElementByName(fieldName);
        directSelect(element, itemListName, itemKeyword, waitSec, hideItemBtn, itemHideFlag);
    }

    /**
     * Click Dropdown list后从下拉列表中选择某选项
     *
     * @param field        选择框
     * @param itemListName 下拉列表的名字，定义在Page Class和element excel文件中
     * @param itemKeyword  选项名称关键字
     * @param waitSec      等待下拉列表出现的最长等待时间
     */
    public void directSelect(WebElement field, String itemListName, String itemKeyword, int waitSec, String hideItemBtn, boolean itemHideFlag) {
        field.click();
        logger.info("点击出现下拉框");
        forceWait(1);//强制等待1秒，等下拉列表数据加载
        selectOneItem(itemListName, itemKeyword, waitSec, hideItemBtn, itemHideFlag);
    }

    /**
     * 从下拉列表中选择某选项
     *
     * @param itemListName 下拉列表的名字，定义在Page Class和element excel文件中
     * @param itemKeyword  选项的关键字
     * @param waitSec      等待下拉列表出现的最长等待时间
     */
    public void selectOneItem(String itemListName, String itemKeyword, int waitSec, String hideItemBtn, boolean mustClickToHideItem) {
        boolean itemFound = false;
        boolean apsBizModuleGrpTreeMenu = false;
        String relativeXpath = "";
        String searchClue = getSearchClue(itemListName);
        boolean hasFlagDetail = false;
        String flagDetail = "";

        try {
            List<WebElement> itemElementList = new ArrayList<>();
            if (searchClue.contains("+") && searchClue.contains("%")) {//两步查询法
                logger.info("两步查询元素，查询线索：{}", searchClue);
                String[] xpathStrings = searchClue.split("[+]");//按字符+分割
                relativeXpath = xpathStrings[1];

                String cohesiveElementNameStr = xpathStrings[0].replaceAll("%", "");

                String cohesiveElementName;
                if (cohesiveElementNameStr.contains("{") && cohesiveElementNameStr.contains("}")) {
                    hasFlagDetail = true;
                    String[] cohesiveElementStrs = cohesiveElementNameStr.split("[{]");//括号前名字，括号内标识
                    cohesiveElementName = cohesiveElementStrs[0];
                    flagDetail = cohesiveElementStrs[1].replaceAll("}", "");
                    logger.info("有标识Flag设置，CohesiveElement Name= {}, Xpath= {}，FlagDetail= \"{}\"", cohesiveElementName, getBy(cohesiveElementName), flagDetail);
                } else {//没有配置标识信息
                    cohesiveElementName = cohesiveElementNameStr;
                    logger.info("查询线索中没有标识Flag设置，关联元素名称为{}", cohesiveElementName);
                }

                List<WebElement> cohesiveElements = waitAndFindElementsByName(cohesiveElementName, 10);

                WebElement displayedCohesiveElement = null;
                if (!hasFlagDetail || (hasFlagDetail && flagDetail.contains("displayedFlag=true"))) {//以下为找到显示的DIV块过程
                    logger.info("查询线索中不含标识信息，或含标识信息但标识信息值为{displayedFlag=true}");
                    for (WebElement cohesiveElement : cohesiveElements) {
                        if (cohesiveElement.isDisplayed()) {
                            logger.info("当前显示的关联元素{}已出现", cohesiveElementName);
                            displayedCohesiveElement = cohesiveElement;
                            break;
                        }
                    }

                    if (displayedCohesiveElement != null) {
                        itemElementList = displayedCohesiveElement.findElements(By.xpath(xpathStrings[1]));
                        logger.info("已由关联元素找到下拉列表元素列表");
                    }
                } else if (hasFlagDetail && flagDetail.contains("matchParamFlag=true")) {//like APS页面bizModuleGrp菜单树
                    logger.info("查询线索中含标识信息{matchParamFlag=true}");
                    itemElementList = cohesiveElements;
                    apsBizModuleGrpTreeMenu = true;
                }
            } else {//一步直接查询元素
                logger.info("一步查询元素，查询线索：{}", searchClue);
                itemElementList = waitAndFindElementsByName(itemListName, waitSec);
            }

            logger.info("下拉列表{}中有{}个选项, 查找线索：{}", itemListName, itemElementList.size(), searchClue);
            for (WebElement element : itemElementList) {
                String text = element.getAttribute("outerText"); //.getText()有时候不能显示
                if (!"".equals(text) && text.equals(itemKeyword)) {
                    logger.info("下拉列表中含匹配关键字{}的显示值为：{}", itemKeyword, text);
                    if (apsBizModuleGrpTreeMenu) {//Item List本身不可以被点击选择
                        logger.info("元素{}找到但不可点击，需要点击前面同级Label元素: {}", itemKeyword, element.toString());
                        List<WebElement> labelElements = element.findElements(By.xpath(relativeXpath));//Click 文字左边的checkbox label
                        if (labelElements.size() == 1) {//有且仅有一个同级Label
                            logger.info("已从下拉列表{}中选取关键字为\"{}\"的选项, checkboxXPath:{}", itemListName, itemKeyword, searchClue);
                            WebElement specElement = labelElements.get(0);
                            waitForElementToBeClickable(specElement, 10);
                            specElement.click();
                            itemFound = true;
                            mustClickToHideItem = true;
                            break;
                        } else {
                            logger.info("根据路径{}未找到元素，请检查Xpath是否正确", searchClue);
                        }
                    } else {//Item List本身可以点击选择
                        jsClick(element);
                        logger.info("已从下拉列表{}中选取关键字为\"{}\"的选项", itemListName, itemKeyword);
                        itemFound = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("查找页面下拉列表元素{}或点击选项\"{}\"时报错，错误信息：{}", itemListName, itemKeyword, e.getMessage());
            e.printStackTrace();
        } finally {
            if (!itemFound || mustClickToHideItem) {
                if (!itemFound) {
                    logger.error(":( 选项 \"{}\"未找到，点击按钮{}隐藏下拉列表项", itemKeyword, hideItemBtn);
                } else if (itemFound && mustClickToHideItem) {
                    logger.info(":) 选项 \"{}\"已找到，仍需点击按钮{}隐藏下拉列表项", itemKeyword, hideItemBtn);
                }
                WebElement element = findElementByName(hideItemBtn);
                waitForElementToBeClickable(element, 5); //等待元素可以被点击
                element.click();
            } else {
                logger.info(":) 选项 \"{}\"已找到，下拉列表项自动隐藏", itemKeyword);
            }
        }
    }

    public void selectRadioBox(String radioBoxItems, String chosenItem) {
        ElementInfo elementInfo = elementInfoMap.get(radioBoxItems);
        try {
            if ("YES".equalsIgnoreCase(chosenItem) || "TRUE".equalsIgnoreCase(chosenItem)) {
                String radioBoxBtnXPath = elementInfo.getLocationClue() + "[@value=\"true\"]";
                jsClick(findElementBy("xpath", radioBoxBtnXPath));
            } else if ("NO".equalsIgnoreCase(chosenItem) || "FALSE".equalsIgnoreCase(chosenItem)) {
                String radioBoxBtnXPath = elementInfo.getLocationClue() + "[@value=\"false\"]";
                jsClick(findElementBy("xpath", radioBoxBtnXPath));
            }
        } catch (Exception e) {
            logger.error("查找页面Radio Box{}或点击选项{}时报错，错误信息：{}", radioBoxItems, chosenItem, e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 对复选框的操作方法
     *
     * @param elementName 复选框元素名称
     * @param tickFlag    是否勾选标识
     */
    public void tickCheckBox(String elementName, String tickFlag) {
        WebElement checkBox = findElementByName(elementName);
        logger.info("复选框状态已勾选：{}，操作标识是否勾选：{}", checkBox.isSelected(), tickFlag);
        try {
            if (!checkBox.isSelected() && ("TRUE").equalsIgnoreCase(tickFlag)) {
                logger.info("Checkbox处于未勾选状态，根据Checkbox勾选标识{}，点击进行勾选", tickFlag);
                jsClick(checkBox);
            } else if (checkBox.isSelected() && ("FALSE").equalsIgnoreCase(tickFlag)) {
                logger.info("Checkbox已选中状态，根据Checkbox勾选标识{}，点击取消勾选", tickFlag);
                jsClick(checkBox);
            }
        } catch (Exception e) {
            logger.error("操作复选框{}时报错，错误信息：{}", elementName, e.getMessage());
            throw e;
        }
    }

    public void clickPageButton(String pageNoLi, String pageNo) {
        List<WebElement> pageNoElements = waitAndFindElementsByName(pageNoLi, 1);
        for (WebElement element : pageNoElements) {
            String text = element.getAttribute("outerText"); //.getText()有时候不能显示
            if (!"".equals(text) && text.contains(pageNo)) {
                logger.info("下拉列表中有匹配关键字{}的值{}", pageNo, text);
                jsClick(element);
                logger.info("已从下拉列表{}中选取关键字为\"{}\"的选项", pageNoLi, pageNo);
                break;
            }
        }
    }


    public void setElementInfoMap(String elementDataFileNameName, String elementsSheetName) {
        String relativePathFileName = elementDataFileNameName.substring(elementDataFileNameName.indexOf("src"));
        ElementInfoUtil elementInfoUtil = new ElementInfoUtil();
        try {
            elementInfoMap = elementInfoUtil.Excel2ElementInfoMap(elementDataFileNameName, elementsSheetName);
            logger.info("Excel文件{}工作表{}中数据已成功存入elementInfo Map中", relativePathFileName, elementsSheetName);
        } catch (Exception e) {
            logger.error("读取Excel文件{}工作表{}时报错, 报错信息：\n{}", relativePathFileName, elementsSheetName, e.getMessage());
        }
    }


    /**
     * 查询出页面的某个元素，以备后续操作
     *
     * @param elementName 元素名称
     */
    public WebElement findElementByName(String elementName) {
        ElementInfo elementInfo = null;
        if (elementInfoMap == null) {
            logger.error("Element信息没有读入elementInfoMap, 请检查页面对象初始化是否出错！！！");
        } else {
            elementInfo = elementInfoMap.get(elementName);
        }

        if (elementInfo == null) {
            logger.error("Element信息错误：元素名称 {} 未在对应Excel文件中正确配置!!!", elementName);
        } else {
            logger.info("Element信息：元素名称{}，按类型{}查找，查找线索{}", elementName,
                    elementInfo.getType(), elementInfo.getLocationClue());
        }

        WebElement element;
        try {
            element = waitAndFindElementByName(elementName, 20);
            logger.info("元素{}出现", elementName);
        } catch (Exception e) {
            logger.error("找页面元素{}时报错，错误信息：{}", elementName, e.getMessage());
            throw e;
        }
        return element;
    }

    /**
     * 查询出页面的某个元素，以备后续操作
     *
     * @param elementName 元素名称
     * @param waitSec     等待秒数
     */
    public List<WebElement> waitAndFindElementsByName(String elementName, int waitSec) {
        //显示等待DropDown List元素出现，visibilityOfAllElement有时候会报错，更换成prensenceOfAllElements，因为有时候元素不一定可见
        WebDriverWait wait = new WebDriverWait(this.getDriver(), waitSec);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getBy(elementName)));//只要存在一个就是true
    }

    /**
     * 查询出页面的某个元素，以备后续操作
     *
     * @param elementName 元素名称
     * @param waitSec     等待秒数
     */
    public WebElement waitAndFindElementByName(String elementName, int waitSec) {
        //显示等待DropDown List所有元素出现，visibilityOfAllElement有时候报错，更换成prensenceOfAllElements
        WebDriverWait wait = new WebDriverWait(this.getDriver(), waitSec);
        return wait.until(ExpectedConditions.presenceOfElementLocated(getBy(elementName)));
    }

    public void waitForElementToBeClickable(WebElement element, long timeInSec) {
        //判断某个元素中是否可见并且是enable的，这样才叫clickable；
        WebDriverWait wait = new WebDriverWait(this.getDriver(), timeInSec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element, long timeInSec) {
        //判断某个元素中是否可见并且是enable的，这样才叫clickable；
        WebDriverWait wait = new WebDriverWait(this.getDriver(), timeInSec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * 查询出页面的某个元素，以备后续操作
     *
     * @param elementName 元素名称
     */
    public void initialElementByName(String elementName) {
        ElementInfo elementInfo = elementInfoMap.get(elementName);
        try {
            WebElement element = this.findElementBy(elementInfo.getType(), elementInfo.getLocationClue());

            //运用Java反射机制，设置成员变量
            Field field = this.getClass().getDeclaredField(elementName);
            if (field.getType() == WebElement.class) {
                field.setAccessible(true);
                field.set(this, element);
            }
        } catch (Exception e) {
            logger.error("找元素或设置成员变量{}时报错，错误信息：{}", elementName, e.getMessage());
        }
        logger.info("Element Found：元素名称{}，按类型{}查找，查找线索{}", elementName,
                elementInfo.getType(), elementInfo.getLocationClue());
    }

    /**
     * 查询出指定列表中的页面，以备后续操作时使用
     *
     * @param elementNames 元素名称
     */
    public void initialElementsByNames(String[] elementNames) {
        //找到该页面下所有元素
        logger.info("开始批量初始化指定的页面元素...");
        for (String oneElementName : elementNames) {
            try {
                initialElementByName(oneElementName);//按元素名称查找按钮元素
            } catch (Exception e) {
                logger.error("初始化指定的页面元素{}时报错，错误信息：{}", oneElementName, e.getStackTrace());
            }
        }
        logger.info("批量初始化页面元素結束！");
    }

    /**
     * 最小化浏览器窗口，暂时没有使用
     */
    public void minimize() {
    }

    /**
     * 最大化浏览器窗口
     */
    public void maximize() {
        this.driver.manage().window().maximize();
    }

    /**
     * 隐式等待几秒钟
     */
    public void waitForPageLoad(int waitSec) {
        this.getDriver().manage().timeouts().implicitlyWait(waitSec, TimeUnit.SECONDS);
    }

    public boolean isElementPresent(WebElement webElement) {
        return true;
    }

    /**
     * 页面操作方法：关闭当前窗口
     */
    public void closeWindow() {
        this.getDriver().close();
    }

    /**
     * 页面操作方法：退出驱动并关闭所有关联的窗口
     */
    public void quit() {
        driver = this.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * 页面操作方法：根据元素名称取得该域文本内容
     */
    public String getTextByElementName(String elementName) {
        String textContent;
        try {
            WebElement element = findElementByName(elementName);
            textContent = this.getElmentText(element);
            logger.info("页面对象{}的文本信息为：{}", this.getClass().toGenericString(), textContent);
        } catch (Exception e) {
            logger.error("获取元素{}文本信息时报错，错误信息：{}", elementName, e.getMessage());
            throw e;
        }
        return textContent;
    }

    /**
     * 页面操作方法：点击按钮后，根据元素名称取得message的文本内容
     */
    public String getMsgAfterBtnClick(String btnName, String toastMsg) {
        String textContent;
        try {
            jsClick(findElementByName(btnName));
            textContent = getElmentText(findElementByName(toastMsg));
            logger.info("页面对象{}的文本信息为：{}", toastMsg, textContent);
        } catch (Exception e) {
            logger.error("点击{}或获取元素{}文本信息时报错", btnName, toastMsg);
            e.printStackTrace();
            throw e;
        }
        return textContent;
    }

    /**
     * 根据按钮名称，点击无页面跳转的按钮
     *
     * @param btnName 按钮名称
     */
    public void clickButton(String btnName) {
        try {
            WebElement element = findElementByName(btnName);
            waitForElementToBeClickable(element, 5);
            jsClick(element);
            logger.info("按钮{}点击完成", btnName);
        } catch (Exception e) {
            logger.error("获取或点击按钮{}时报错，错误信息：{}", btnName, e.getMessage());
        }
    }

    /**
     * 根据按钮名称，点击无页面跳转的按钮
     *
     * @param btnName 按钮名称
     */
    public void doubleClickButton(String btnName) {
        WebElement element = findElementByName(btnName);
        jsClick(element);
        jsClick(element);
        logger.info("双击按钮{}完成", btnName);
    }


    /**
     * 根据按钮名称，点击页面按钮，进行跳转
     *
     * @param btnName         按钮名称
     * @param forwardPageName 跳转后的页面对象
     * @return 跳转后的页面对象
     */
    public Object clickButton(String btnName, String forwardPageName) throws Exception {
        jsClick(findElementByName(btnName));
        logger.info("按钮{}点击完成", btnName);
        return createPOByName(forwardPageName);
    }

    /**
     * 根据按钮名称，点击页面按钮，进行跳转
     *
     * @param element         按钮元素，当需要多次操作时，可以一次初始化，多次调用该方法
     * @param forwardPageName 跳转后的页面对象
     * @return 跳转后的页面对象
     */
    public Object clickButton(WebElement element, String forwardPageName) throws Exception {
        jsClick(element);
        logger.info("按钮{}点击完成", element.getText());
        return createPOByName(forwardPageName);
    }

    /**
     * 用JS执行页面元素点击操作，当元素被透明遮罩层覆盖，无法点击时使用
     *
     * @param element 页面元素
     */
    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * 直接跳转页面
     *
     * @param forwardPageName 跳转后的页面对象
     * @return 跳转后的页面对象
     */
    public Object directForwardTo(String forwardPageName) throws Exception {
        return createPOByName(forwardPageName);
    }

    /**
     * 用Actions鼠标事件执行页面元素点击操作,当元素被透明遮罩层覆盖，无法点击时使用
     *
     * @param element 页面元素
     */
    public void actionClick(WebElement element) {
        Actions actions = new Actions(this.getDriver());
        actions.moveToElement(element).click().perform();
    }

    /**
     * 输入数据到InputBox中
     *
     * @param inputBoxName 页面元素名称
     * @param inputString  新的输入文本
     */
    public void fillInputBox(String inputBoxName, String inputString) {
        WebElement inputBox = findElementByName(inputBoxName);
        waitForElementToBeClickable(inputBox, 10);
        inputBox.sendKeys(inputString);
        logger.info("输入{}的数据是：{}", inputBoxName, inputString);
    }

    /**
     * 输入数据到InputBox中
     *
     * @param inputBox    页面元素
     * @param inputString 新的输入文本
     */
    public void fillInputBox(WebElement inputBox, String inputString) {
        waitForElementToBeClickable(inputBox, 10);
        inputBox.sendKeys(inputString);
        logger.info("输入框{}填入的数据是：{}", inputBox.getText(), inputString);
    }

    /**
     * 清除页面元素的输入文本
     *
     * @param elementName 页面元素名
     */
    public void clearField(String elementName) {
        WebElement element = findElementByName(elementName);
        forceWait(1);
        element.clear();
        logger.info("输入框{}的数据已清空", elementName);
    }

    /**
     * 元素操作组合，清空后重新输入
     *
     * @param element     页面元素
     * @param inputString 新的输入文本
     */
    public void clearThenFill(WebElement element, String inputString) {
        element.clear();
        element.sendKeys(inputString);
        logger.info("输入框{}清空后填入的数据是：{}", element.getText(), inputString);
    }

    /**
     * 元素操作组合，清空后重新输入
     *
     * @param elementName 页面元素名称
     * @param inputString 新的输入文本
     */
    public void clearThenFill(String elementName, String inputString) {
        WebElement element = findElementByName(elementName);
        waitForElementToBeClickable(element, 10);
        element.clear();
        element.sendKeys(inputString);
        logger.info("{}清空后填入的数据是：{}", elementName, inputString);
    }

    /**
     * 通过AppMenuPage上的按钮跳转到HomePage
     *
     * @param btnElement      按钮名
     * @param forwardPageName 跳转页面名
     * @return 跳转页面对象
     * @throws Exception 错误
     */
    public Object backHomePageViaAppMenuPageBtn(String btnElement, String forwardPageName) throws Exception {
        //带driver参数跳转到AppMenuPage
        BasePage menuPage;
        if (forwardPageName.startsWith("C")) {
//            menuPage = new CAppMenuPage(this.getDriver());
        } else {
//            menuPage = new MAppMenuPage(this.getDriver());
        }
        //点击按钮跳到指定的页面
//        return menuPage.clickButton(btnElement, forwardPageName);
        return null;
    }

    /**
     * 创建带driver的页面对象
     *
     * @param pageObjName 页面对象名称
     * @return 跳转页面对象
     * @throws Exception 错误
     */
    public Object createPOByName(String pageObjName) throws Exception {
        //读取配置的页面Class名称，运用Java反射机制，取到带WebDriver参数的构造器，创建一个Page对象
        String returnObjectClassName = ConfigReader.getPageClassName(pageObjName);
        Constructor<?> con = Class.forName(returnObjectClassName).getConstructor(WebDriver.class);
        Object pageObj = con.newInstance(this.getDriver());
        logger.info("成功创建带driver的页面对象{}", pageObj.getClass().toString());
        return pageObj;
    }

    public String getElmentText(WebElement element) {
        String text = "";
        if (element != null) {
            text = element.getAttribute("outerText");
        }
        return text;
    }

    public void forceWait(int waitSec) {
        try {
            Thread.sleep(waitSec * 1000);//wait for rending
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void forceWait(String waitSec) {
        forceWait(new Integer(waitSec));
    }

    public void callTestCases(String runTestClazze, String groups) throws Exception {
        logger.info("runTestClazze：{}; Groups: {}", runTestClazze, groups);
        TestNG tng = new TestNG();
        String preClazz = ConfigReader.getTestCassClassName(runTestClazze);
        tng.setTestClasses(new Class[]{Class.forName(preClazz)});

        if (!groups.equals("") && !groups.equals("\"\"")) {
            tng.setGroups(groups);
        }
        tng.run();
    }

    public void callTestCases(String runTestClazze) throws Exception {
        logger.info("runTestClazze：{}", runTestClazze);
        TestNG tng = new TestNG();
        String preClazz = ConfigReader.getTestCassClassName(runTestClazze);
        tng.setTestClasses(new Class[]{Class.forName(preClazz)});
        tng.run();
    }
}
