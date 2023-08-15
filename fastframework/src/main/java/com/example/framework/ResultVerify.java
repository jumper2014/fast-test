package com.example.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ResultVerify {
    private static final Logger myLogger = LoggerFactory.getLogger(ResultCheck.class);

    public static void assertTrue(boolean actual, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertTrue(actual);
    }

    public static void assertTrue(boolean actual) {
        ResultCheck.assertTrue(actual);
    }

    public static void assertFalse(boolean actual, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertFalse(actual);
    }

    public static void assertFalse(boolean actual) {
        ResultCheck.assertFalse(actual);
    }

    public static void assertListContainsInAnyOrder(List<String> actual, List<String> expect, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertListContainsInAnyOrder(actual, expect);
    }

    public static void assertListContainsInAnyOrder(List<String> actual, List<String> expect) {
        ResultCheck.assertListContainsInAnyOrder(actual, expect);
    }


    public static void assertStringContainString(String actual, String expect, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertStringContainString(actual, expect);
    }

    public static void assertStringContainString(String actual, String expect) {
        ResultCheck.assertStringContainString(actual, expect);
    }

    public static void assertStringEqualIgnoringCase(String actual, String expect, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertStringEqualIgnoringCase(actual, expect);
    }

    public static void assertStringEqualIgnoringCase(String actual, String expect) {
        ResultCheck.assertStringEqualIgnoringCase(actual, expect);
    }

    public static void assertStringEqual(String actual, String expect, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertStringEqual(actual, expect);
    }

    public static void assertStringEqual(String actual, String expect) {
        ResultCheck.assertStringEqual(actual, expect);
    }

    public static void assertStringNotEqual(String actual, String expect, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertStringNotEqual(actual, expect);
    }

    public static void assertStringNotEqual(String actual, String expect) {
        ResultCheck.assertStringNotEqual(actual, expect);
    }

    public static void assertNumberEqual(int actual, int expect, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNumberEqual(int actual, int expect) {
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNumberEqual(double actual, double expect, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNumberEqual(double actual, double expect) {
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNumberEqual(float actual, float expect, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNumberEqual(float actual, float expect) {
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNull(Object object, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertNull(object);
    }

    public static void assertNull(Object object) {
        ResultCheck.assertNull(object);
    }

    public static void assertNotNull(Object object, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertNotNull(object);
    }

    public static void assertNotNull(Object object) {
        ResultCheck.assertNotNull(object);
    }

}
