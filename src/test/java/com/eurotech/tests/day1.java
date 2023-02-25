package com.eurotech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class day1 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        // 1. yol desiredCapabilities.setCapability("platformName", "Android");

        //2.yol:
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "8.0.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 API 26");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "Calculator");
        //desiredCapabilities.setCapability("appWaitActivity", "com.google.android.calendar");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(1000);

        MobileElement digit2 = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        MobileElement digit3 = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
        MobileElement plus = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"plus\"]"));
        MobileElement equal = driver.findElement(By.id("com.android.calculator2:id/eq"));
        MobileElement result = driver.findElement(By.id("com.android.calculator2:id/result"));

        digit2.click();
        plus.click();
        digit3.click();
        equal.click();
        String  actualResult = result.getText();
        Assert.assertEquals("5", actualResult);

        Thread.sleep(3000);
        driver.closeApp();

    }
}
