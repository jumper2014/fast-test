package com.ys.apptest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        monochrome = true,
        features = "src/test/app_features",
        plugin = {"pretty", "html:target/cucumber-html-report"}
//        tags = "@testdiary"
)
public class PlayerTestngTest extends AbstractTestNGCucumberTests {

}

