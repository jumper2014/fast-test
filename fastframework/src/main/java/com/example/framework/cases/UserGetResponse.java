package com.example.framework.cases;


import com.alibaba.fastjson.JSONObject;
import com.mongodb.util.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserGetResponse implements Serializable {
    private JSONObject data;
}