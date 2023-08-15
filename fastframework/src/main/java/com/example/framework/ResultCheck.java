package com.example.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;


public class ResultCheck {
    private static final Logger logger = LoggerFactory.getLogger(ResultCheck.class);
    private ResultCheck() {
        logger.info("Private constructor of ResultCheck");
    }

    /**
     * Check if actual is true
     *
     * @param actual actual result
     */
    public static void assertTrue(boolean actual) {
        String msg = messagePackage("[Assert-True]", String.valueOf(actual),"true");
        try {
            Assert.assertTrue(actual);
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Check if actual is false
     *
     * @param actual actual result
     */
    public static void assertFalse(boolean actual) {
        String msg = messagePackage("[Assert-False]", String.valueOf(actual), "false");
        try {
            Assert.assertFalse(actual);
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Check actual string list contains expected string list in any order
     *
     * @param expect Given string list
     * @param actual Actual string list
     */
    public static void assertListContainsInAnyOrder(List<String> actual, List<String> expect) {
        String msg = messagePackage("[Assert-List-Contain-InAnyOrder]", actual.toString(), expect.toString());
        try {
            assertThat(actual, containsInAnyOrder(expect.toArray()));
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Check expected string list contains actual string
     *
     * @param expect Given string list
     * @param actual Actual string
     */
    public static void assertListContainsString(List<String> actual, String expect) {
        String msg = messagePackage("[Array-List-Contain-String]", actual.toString(), expect);
        try {
            assertThat(actual.toArray(), hasItemInArray(expect));
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Check given String contains actual string
     *
     * @param expect Given string
     * @param actual Actual string
     */
    public static void assertStringContainString(String actual, String expect) {
        String msg = messagePackage("[String-Contain]", actual, expect);
        try {
            assertThat(actual, containsString(expect));
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Check two Strings for equality regardless of case
     *
     * @param expect expected string value
     * @param actual actual string value
     */
    public static void assertStringEqualIgnoringCase(String actual, String expect) {
        String msg = messagePackage("[String-Equal-Ignore-Case]", actual, expect);
        try {
            assertThat(actual, equalToIgnoringCase(expect));
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Check two Strings if equal
     *
     * @param expect expected string value
     * @param actual actual string value
     */
    public static void assertStringEqual(String actual, String expect) {
        String msg = messagePackage("[String-Equal]", actual, expect);
        try {
            Assert.assertEquals(actual, expect);
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Check two Strings if not equal
     *
     * @param expect expected string value
     * @param actual actual string value
     */
    public static void assertStringNotEqual(String actual, String expect) {
        String msg = messagePackage("[String-Not-Equal]", actual, expect);
        try {
            Assert.assertNotEquals(actual, expect);
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Check two integer number for equality
     *
     * @param expect expected number value
     * @param actual actual number value
     */
    public static void assertNumberEqual(int actual, int expect) {
        String msg = messagePackage("[Int-Number-Equal]", String.valueOf(actual), String.valueOf(expect));
        assertNumberEqual(actual, expect, msg);
    }

    /**
     * Check two double number for equality
     *
     * @param expect expected number value
     * @param actual actual number value
     */
    public static void assertNumberEqual(double actual, double expect) {
        String msg = messagePackage("[Double-Number-Equal]", String.valueOf(actual), String.valueOf(expect));
        assertNumberEqual(actual, expect, msg);
    }

    /**
     * Check two float number for equality
     *
     * @param expect expected number value
     * @param actual actual number value
     */
    public static void assertNumberEqual(float actual, float expect) {
        String msg = messagePackage("[Float-Number-Equal]", String.valueOf(actual), String.valueOf(expect));
        assertNumberEqual(actual, expect, msg);
    }

    private static void assertNumberEqual(Object actual, Object expect, String msg) {
        try {
            assertThat(actual, equalTo(expect));
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Check if object is null
     *
     * @param object actual object
     */
    public static void assertNull(Object object) {
        String msg = messagePackage("[Object-Null]", String.valueOf(object),"null");
        try {
            Assert.assertNull(object);
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Check if object is not null
     *
     * @param object actual object
     */
    public static void assertNotNull(Object object) {
        String msg = messagePackage("[Object-Not-Null]", String.valueOf(object), "not null");
        try {
            Assert.assertNotNull(object);
            TestLogger.info(logger, msg);
        } catch (AssertionError error) {
            TestLogger.fail(logger, msg);
            throw error;
        }
    }

    /**
     * Generate message content with unified format
     *
     * @param assertType assert type
     * @param expect     expected value string
     * @param actual     actual value string
     * @return Unified message
     */
    private static String messagePackage(String assertType, String actual, String expect) {
        String message = assertType + " Actual: " +
                actual +
                ", Expect: " +
                expect;
        return message;
    }
}
