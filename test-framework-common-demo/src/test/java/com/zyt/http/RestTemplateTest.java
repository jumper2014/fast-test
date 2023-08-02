package com.zyt.http;


import com.zyt.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static com.zyt.constant.Url.USER_URL;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class )
public class RestTemplateTest {


    @Resource
    RestTemplate restTemplate;

    /**
     * 发送GET请求
     */
    @Test
    public void getRequest()  {

        String url = USER_URL;
        String user = restTemplate.getForObject(url, String.class);
        System.out.println(user);

    }




}
