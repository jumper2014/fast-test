package com.ys.apptest;


import com.ys.app.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerSteps {

    @Given("^appium is running$")
    public void startAppium() throws Throwable {
        Appiumer er = new Appiumer();
        er.startAppium();
        Thread.sleep(1000*2);
    }

    @When("^install apk$")
    public void installApk() throws Throwable {
        BPlayer player = new BPlayer();
        player.installPlayer();
        Thread.sleep(1000);

    }

    @When("^remove apk$")
    public void removeApk() throws Throwable {
        BPlayer player = new BPlayer();
        player.driver.removeApp(Constants.DEMO_PACKAGE_NAME);
        Thread.sleep(1000*2);

    }


    @When("^start apk$")
    public void startPlayer() throws Throwable {
        BPlayer player = new BPlayer();
        player.startPlayer();

    }

    @Then("^version is (.*)$")
    public void versionIs(String version) {
        Dashboard board = new Dashboard();
        String versionReal = board.getVersion();
        assertEquals(version, versionReal);
    }


    @Then("^player is installed")
    public void playerIsInstalled() throws Throwable {
        assertEquals(true, Global.driver.isAppInstalled(Constants.DEMO_PACKAGE_NAME));
    }

    @Then("^player is not installed")
    public void playerIsNotInstalled() throws Throwable {
        assertEquals(false, Global.driver.isAppInstalled(Constants.DEMO_PACKAGE_NAME));
    }

    @Then("^swipe menu")
    public void swipeMenu() {
        try {
            Thread.sleep(5000);  //wait for menu disappear
            Global.driver.swipe(50, 500, 800, 500, 1000);  // duration is ms
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("^select channel (\\d+)$")
    public void selectChannel(int id) {
        try {
            Thread.sleep(3000);
            System.out.println("Try to click channel " + id);
            List<WebElement> channels = Global.driver.findElementsById("com.cloutropy.bplayer:id/channel_name");
            System.out.println("There are " + channels.size() + " channels.");
            System.out.println(channels.get(id-1));
            System.out.println("Element is displayed: " + channels.get(id-1).isDisplayed());
            System.out.println(channels.get(0).getText());
            System.out.println(channels.get(1).getText());
            System.out.println(channels.get(2).getText());
            Global.driver.tap(1, channels.get(1), 200);
            channels.get(1).click();
//            channels.get(2).click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    @Then("^test done")
    public void testDone() throws Throwable {
        assertEquals(0, 0);
    }

//    @After("@player")
//    public void cleanDriver() {
//
////        Global.driver.quit();
//        new Appiumer().stopAppium();
//    }
}