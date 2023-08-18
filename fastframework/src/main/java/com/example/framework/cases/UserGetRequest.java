package com.example.framework.cases;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserGetRequest implements Serializable {
    private String userId;
}
