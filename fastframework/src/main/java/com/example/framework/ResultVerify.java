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

    public static void assertListContainsInAnyOrder(List<String> expect, List<String> actual, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertListContainsInAnyOrder(actual, expect);
    }

    public static void assertListContainsInAnyOrder(List<String> expect, List<String> actual) {
        ResultCheck.assertListContainsInAnyOrder(actual, expect);
    }


    public static void assertStringContainString(String expect, String actual, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertStringContainString(actual, expect);
    }

    public static void assertStringContainString(String expect, String actual) {
        ResultCheck.assertStringContainString(actual, expect);
    }

    public static void assertStringEqualIgnoringCase(String expect, String actual, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertStringEqualIgnoringCase(actual, expect);
    }

    public static void assertStringEqualIgnoringCase(String expect, String actual) {
        ResultCheck.assertStringEqualIgnoringCase(actual, expect);
    }

    public static void assertStringEqual(String expect, String actual, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertStringEqual(actual, expect);
    }

    public static void assertStringEqual(String expect, String actual) {
        ResultCheck.assertStringEqual(actual, expect);
    }

    public static void assertStringNotEqual(String expect, String actual, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertStringNotEqual(actual, expect);
    }

    public static void assertStringNotEqual(String expect, String actual) {
        ResultCheck.assertStringNotEqual(actual, expect);
    }

    public static void assertNumberEqual(int expect, int actual, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNumberEqual(int expect, int actual) {
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNumberEqual(double expect, double actual, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNumberEqual(double expect, double actual) {
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNumberEqual(float expect, float actual, String checkpoint) {
        TestLogger.info(myLogger, "[CheckPoint] " + checkpoint);
        ResultCheck.assertNumberEqual(actual, expect);
    }

    public static void assertNumberEqual(float expect, float actual) {
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
