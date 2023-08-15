package com.example;

import com.example.framework.BaseTest;
import com.example.framework.ResultVerify;
import com.example.framework.TestLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class AppTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void checkTest() {
        TestLogger.info(logger, "check");
        ResultVerify.assertFalse(false, "checkFalse");
    }
}
