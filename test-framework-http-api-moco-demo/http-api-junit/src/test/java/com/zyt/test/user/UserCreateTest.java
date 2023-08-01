package com.zyt.test.user;

import com.zyt.http.Request;
import com.zyt.db.User;
import net.sf.json.JSONObject;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class UserCreateTest extends TestCase {

    @Test
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
                out.println(jsonString);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else{
            fail("result :"+state+"("+url+")");
        }
    }

    public void setUp() throws Exception {
//        User user = new User();
//        user.deleteUserByName("root");
    }

    public void tearDown() throws Exception {
    }

}
