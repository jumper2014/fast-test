package com.example.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Value("${environment.name}")
    String environment;

    @Test
    public void envValueTest()  {
        TestLogger.info(logger, environment);
    }

    @Test
    public void checkTest() {
        TestLogger.info(logger, "check");
        ResultVerify.assertFalse(false, "checkFalse");
    }

}
