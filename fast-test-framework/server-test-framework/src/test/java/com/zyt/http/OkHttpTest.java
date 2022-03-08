package com.zyt.http;


import com.zyt.App;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.zyt.constant.Url.USER_URL;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class )
public class OkHttpTest {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 发送GET请求
     */
    @Test
    public void getRequest() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(USER_URL)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }

    }

//    /**
//     * POST请求
//     */
//    @Test
//    public void postRequest() throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        // 提交FormData
//        FormBody.Builder form = new FormBody.Builder();
//        form.add("name", "Tom");
//        form.add("age", "23");
//
//        Request request = new Request.Builder()
//                .url("http://httpbin.org/post")
//                .post(form.build())
//                .build();
//
//        Response response = client.newCall(request).execute();
//        System.out.println(response.body().string());
//
//    }
//
//    /**
//     * 提交Json
//     */
//    @Test
//    public void postJsonRequest() throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "Tom");
//        map.put("age", 23);
//
//        Gson gson = new Gson();
//        String data = gson.toJson(map);
//
//        RequestBody requestBody = RequestBody.create(data, JSON);
//
//        Request request = new Request.Builder()
//                .url("http://httpbin.org/post")
//                .post(requestBody)
//                .build();
//
//        Response response = client.newCall(request).execute();
//        System.out.println(response.body().string());
//
//    }


}
