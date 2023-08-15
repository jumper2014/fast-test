package com.example.log;

import com.example.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class )
public class LogsTest {

    public static final Logger logger = LoggerFactory.getLogger(LogsTest.class);


//    @Test
//    public void log2Files() {
//        LogConstant.ALARM_LOG.info("Alarm log line");
//        LogConstant.ACC_LOG.info("Access log line");
//        System.out.println("test done");
//    }

    @Test
    public void logTest() {
        logger.info("hello kitty");
    }




}
