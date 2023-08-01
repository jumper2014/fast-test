package com.zyt.test.user;

import com.zyt.db.User;
import com.zyt.http.Request;
import junit.framework.TestCase;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import org.testng.annotations.*;

public class UserCreateTest extends TestCase {

    @Test(groups = {"user"})
    public void testCreateNewUser() {
        String JSON_SIMPLE = "{'name':'root','age':40}";
        JSONObject body = JSONObject.fromObject(JSON_SIMPLE);
        Request request = new Request();
        String url = "http://127.0.0.1:12306/user";
        HttpResponse  response = request.httpPostWithJson(body, url);
        StatusLine status = response.getStatusLine();
        int state = status.getStatusCode();
        if (state == HttpStatus.SC_OK) {
            HttpEntity responseEntity = response.getEntity();
            String jsonString = null;
            try {
                jsonString = EntityUtils.toString(responseEntity);
                System.out.println(jsonString);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else{
            fail("result :"+state+"("+url+")");
        }
    }

    @BeforeMethod()
    public void setUp() throws Exception {
//        User user = new User();
//        user.deleteUserByName("root");
    }
    @AfterMethod()
    public void tearDown() throws Exception {
    }

}
