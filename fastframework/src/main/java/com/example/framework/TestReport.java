package com.example.framework;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestReport {

    private static final Logger logger = LoggerFactory.getLogger(TestReport.class);
    private static final String testReportPath = System.getProperty("user.dir") + "/reports/";
    private static final String testReportBackupPath = System.getProperty("user.dir") + "/logs/reports/";
    private static String testReportName = "";
    private static ExtentReports extentReports = null;
    private static ExtentTest extentTest;

    private TestReport() {
        logger.info("Private constructor of TestReport");
    }

    public static ExtentReports getExtentReports() {
        return extentReports;
    }

    public static ExtentTest getExtentTest() {
        return extentTest;
    }

    /**
     * Initialize extent report before suite, extent report handler is created only once
     */
    public static void initReport() {
        TestLogger.info(logger, "Initialize automation report");
        if (null == extentReports) {
            extentReports = new ExtentReports(getTestReportName(), true);
        }
    }

    /**
     * Start extent report before method
     *
     * @param testCaseName test case name to be created in extent report
     */
    public static void startTest(String testCaseName) {
        extentTest = extentReports.startTest(testCaseName);
    }

    /**
     * Update extent report file
     */
    public static void updateTest() {
        if (null != extentReports) {
            extentReports.endTest(extentTest);
            extentReports.flush();
        }
    }


    /**
     * Generate unique test report full path name only once
     *
     * @return test report (.html) full path name
     */
    public static String getTestReportName() {
        if (testReportName.length() == 0) {
            testReportName = testReportPath + "report.html";
        }
        return testReportName;
    }

    /**
     * Generate test screenshot full path name
     *
     * @return screenshot (.png) full path name
     */
    public static String getTestScreenshotName() {
        String testScreenshotFolder = "screenshots";
        String failScreenshotPath = testReportPath + testScreenshotFolder;
        Calendar calendar = Calendar.getInstance();
        String strCurrentTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(calendar.getTime());
        return failScreenshotPath + File.separator + strCurrentTime + ".png";
    }

    /**
     * Clean all automation result files under reports and screenshots folders
     */
    public static void cleanTestResult() {
        File dir = new File(testReportBackupPath);
        if (!dir.exists()) {
            dir.mkdir();
        }

        String sourceFileName = testReportPath + "report.html";
        String destFileName = testReportBackupPath + "report_" + Date.getReportDateTime() + ".html";
        logger.info("Source file is:" + sourceFileName);
        logger.info("Dest file is:" + destFileName);
        File src = new File(sourceFileName);
        File dest = new File(destFileName);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException ie) {
            logger.error("Fail to copy screenshot file", ie);
        }

        File file = new File(testReportPath);
        FileExtractor.deteteFile(file);
    }
}
