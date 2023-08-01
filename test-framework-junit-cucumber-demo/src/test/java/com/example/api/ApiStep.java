package com.example.api;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;

public class ApiStep {

    @假如("^:有设置密码$")
    public void 有设置密码() {
        System.out.println("有设置密码");

    }

    @那么("^:验证通过$")
    public void 验证通过() {
        System.out.println("验证通过");

    }
}