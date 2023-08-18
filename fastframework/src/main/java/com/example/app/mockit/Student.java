package com.example.app.mockit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Autowired
    Lab lab;

    public boolean passMathExp() {
        return lab.getExpScore("math") >= 90;
    }

    public boolean passPhyExp() {
        try {
            lab.getExpScore("phy");
        } catch (Exception e) {
            throw e;
        }
        return true;
    }


}
