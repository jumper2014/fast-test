package com.example.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

/*
A listener is a regular Java program that implements a specific interface. It is designed to monitor method invocations
or property changes of another Java object. When the object being listened to triggers one of these events,
a specific method in the listener will be executed immediately.
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

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        logger.info("beforeInvocation: {}", iTestResult.getName());
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        logger.info("afterInvocation: {}", iTestResult.getName());
    }
}
