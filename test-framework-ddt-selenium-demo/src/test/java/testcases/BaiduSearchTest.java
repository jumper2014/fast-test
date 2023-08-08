package testcases;

import testcase.BasicTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.page.BaiduSearchPage;

public class BaiduSearchTest extends BasicTest {
    private static final Logger logger = LoggerFactory.getLogger(BaiduSearchTest.class);

    private static final String caseFileName = caseDataFolder + "BaiduSearch_cases.xlsx";
    private static final String testCaseSheetName = "TestCases";

    Object initialPage = null;
    Object pageObjNeedClose = null;

    @BeforeMethod
    public void gotoBaiduIndex() {
        initialPage = new BaiduSearchPage().openWindow("http://www.baidu.com");
    }

    @Test
    public void searchKeyword() throws Exception {
        String testCaseName = "BaiduSearch";
        logger.info("Start case: " + testCaseName);
        pageObjNeedClose = run(caseFileName, testCaseSheetName, testCaseName, initialPage);
        logger.info("End case: " + testCaseName);

    }
}
