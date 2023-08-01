package com.ys.sample;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        monochrome = true,
        features = "src/test/features",
        plugin = {"pretty", "html:target/cucumber-html-report"}
//        tags = "@testdiary"
)
public class CheckoutTestngTest extends AbstractTestNGCucumberTests {

}

