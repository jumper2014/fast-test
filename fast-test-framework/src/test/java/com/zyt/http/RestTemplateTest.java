package com.zyt.http;


import com.zyt.App;
import com.zyt.dubbo.api.model.User;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

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

        String url = "http://localhost:8081/user/111";
        String user = restTemplate.getForObject(url, String.class);
        System.out.println(user);

    }




}
