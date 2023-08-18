package com.example.framework;

import com.alibaba.fastjson.JSONObject;
import com.example.framework.cases.UserGetCase;
import com.example.framework.cases.UserGetCases;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class YamlTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(YamlTest.class);
    @Autowired
    UserGetCases userGetCases;

    @DataProvider(name = "GetValidCase")
    public Object[][] getCRBatchGetParams() {
        List<UserGetCase> userGetCases = this.userGetCases.getUserGetCaseList();
        Object[][] params = new Object[userGetCases.size()][];
        for (int i = 0; i < userGetCases.size(); i++) {
            params[i] = new Object[]{userGetCases.get(i)};
        }
        return params;
    }

    @Test(dataProvider = "GetValidCase")
    public void userGetTest(UserGetCase userGetCase) {
        // 设置基本路径
        RestAssured.baseURI = "http://localhost:8081";
        String userId = userGetCase.getRequest().getUserId();

        // 发送GET请求并获取响应
        Response response = RestAssured.get("/user/" + userId);

        // 解析响应
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        // 打印响应信息
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
        System.out.println("Age: " + JSONObject.parseObject(responseBody).get("age"));
        System.out.println("Name: " + JSONObject.parseObject(responseBody).get("name"));
    }
}
