package com.eurotech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class day2 {
    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //********** PS C:\Users\dator> adb devices
        //List of devices attached
        //emulator-5554   device
        //
        //PS C:\Users\dator> adb shell
        //generic_x86:/ $ dumpsys window windows | grep -E 'mCurrentFocus'

        // 1. yol desiredCapabilities.setCapability("platformName", "Android");

        //2.yol:
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "8.0.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 API 26");
        desiredCapabilities.setCapability("appPackage", "com.ebay.mobile");
//        desiredCapabilities.setCapability("appWaitActivity", "com.mango.activities.onboarding.presentation");
        desiredCapabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

/*        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ebay.mobile:id/button_classic")));
        MobileElement signBtn = driver.findElement(By.id("com.ebay.mobile:id/button_classic"));
        signBtn.click();*/
        MobileElement searchBox = driver.findElement(By.id("com.ebay.mobile:id/search_box"));

        searchBox.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ebay.mobile:id/search_src_text")));
        MobileElement searchBox2 = driver.findElement(By.id("com.ebay.mobile:id/search_src_text"));
        searchBox2.sendKeys("Apple Watch");
        //searchBox2.execute();


        Thread.sleep(3000);

        driver.closeApp();

    }
}
