package com.zyt.http;


import com.zyt.App;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import okhttp3.MediaType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import static com.zyt.constant.url.USER_URL;
import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class )
public class RestAssuredTest {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 发送GET请求
     */
    @Test
    public void getRequest()  {
        given()
                .when()
                .get(USER_URL)
                .then()
                .statusCode(200);
    }



}
