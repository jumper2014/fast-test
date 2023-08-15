package com.example;

import com.example.framework.TestNgBaseTest;
import com.example.framework.ResultVerify;
import com.example.framework.TestLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public class TestNgAppTest extends TestNgBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(TestNgAppTest.class);

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
