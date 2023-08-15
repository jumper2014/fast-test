package com.example.framework;

import com.relevantcodes.extentreports.LogStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {
    // 使用指定的类初始化日志对象，方便在日志输出的时候，可以打印出日志信息所属的类。
    private static final Logger logger = LoggerFactory.getLogger(TestLogger.class);

    private TestLogger() {
        logger.info("Private constructor of TestLogger");
    }

    /**
     * Log info message to log file and extent report
     *
     * @param logger logger object used to save message
     * @param info   message content
     */
    public static void info(Logger logger, String info) {
        // 写测试报告
        if (TestReport.getExtentTest() != null) {
            TestReport.getExtentTest().log(LogStatus.INFO, info);
        }
        // 写日志
        if (logger != null) {
            logger.info(info);
        }
    }

    /**
     * Log info message to log file and extent report, exception error
     *
     * @param logger logger object used to save message
     * @param info   message content
     */
    public static void info(Logger logger, String info, Throwable err) {
        if (TestReport.getExtentTest() != null) {
            TestReport.getExtentTest().log(LogStatus.INFO, info);
        }
        if (logger != null) {
            logger.info(info, err);
        }
    }

    /**
     * Log warning message to log file and extent report
     *
     * @param logger logger object used to save message
     * @param info   message content
     */
    public static void warn(Logger logger, String info) {
        if (TestReport.getExtentTest() != null) {
            TestReport.getExtentTest().log(LogStatus.WARNING, info);
        }
        if (logger != null) {
            logger.warn(info);
        }
    }

    /**
     * Log error message to log file and error info to extent report
     *
     * @param logger logger object used to save message
     * @param info   message content
     */
    public static void error(Logger logger, String info) {
        if (TestReport.getExtentTest() != null) {
            TestReport.getExtentTest().log(LogStatus.ERROR, info);
        }
        if (logger != null) {
            logger.error(info);
        }
    }

    /**
     * Log error message to log file and fail info to extent report
     *
     * @param logger logger object used to save message
     * @param info   message content
     */
    public static void fail(Logger logger, String info) {
        if (TestReport.getExtentTest() != null) {
            TestReport.getExtentTest().log(LogStatus.FAIL, info);
        }
        if (logger != null) {
            logger.error(info);
        }
    }

    /**
     * Log error message to log file and fail info to extent report, exception error
     *
     * @param logger logger object used to save message
     * @param info   message content
     * @param err    exception object
     */
    public static void fail(Logger logger, String info, Throwable err) {
        if (TestReport.getExtentTest() != null) {
            TestReport.getExtentTest().log(LogStatus.FAIL, info);
        }
        if (logger != null) {
            logger.error(info, err);
        }
    }

    /**
     * Log fatal message to log file and extent report
     *
     * @param logger logger object used to save message
     * @param info   message content
     */
    public static void fatal(Logger logger, String info) {
        if (TestReport.getExtentTest() != null) {
            TestReport.getExtentTest().log(LogStatus.FATAL, info);
        }
        if (logger != null) {
            logger.error(info);
        }
    }

    /**
     * Log info message to log file and skip message to extent report
     *
     * @param logger logger object used to save message
     * @param info   message content
     */
    public static void skip(Logger logger, String info) {
        if (TestReport.getExtentTest() != null) {
            TestReport.getExtentTest().log(LogStatus.SKIP, info);
        }
        if (logger != null) {
            logger.info(info);
        }
    }
}
