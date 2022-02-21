package com.zyt.log;

import com.zyt.App;
import com.zyt.constant.LogConstant;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.zyt.constant.Url.USER_URL;

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
