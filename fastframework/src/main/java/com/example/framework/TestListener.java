package com.example.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

/*
监听器就是一个实现特定接口的普通java程序，这个程序专门用于监听另一个java对象的方法调用或属性改变，
当被监听对象发生上述事件后，监听器某个方法将立即被执行。
 */
public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    public TestListener() {
        super();
    }

    @Override
    public void onStart(ISuite iSuite) {
        TestLogger.info(logger, "Test suite started: " + iSuite.getName());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        TestLogger.info(logger, "Test suite finished: " + iSuite.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        TestLogger.info(logger, "Test case started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TestLogger.info(logger, "Test case success: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TestLogger.fail(logger, "Test case failed with exception " + result.getThrowable().getClass());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        TestLogger.skip(logger, "Test case skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        TestLogger.fail(logger, "Test case failed but within success percentage: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        TestLogger.info(logger, "Test started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        TestLogger.info(logger, "Test finished: " + context.getName());
    }

    // 调用前
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        logger.info("beforeInvocation: {}", iTestResult.getName());
    }

    // 调用后
    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        logger.info("afterInvocation: {}", iTestResult.getName());
    }
}
