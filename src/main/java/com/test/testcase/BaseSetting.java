package com.test.testcase;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseSetting  {
    public        AndroidDriver<MobileElement> driver;

    @BeforeTest(alwaysRun = true)
    @Parameters({"deviceName", "udid", "systemPort", "appPackage", "appActivity"})
    public void setup(String deviceName, String udid, String systemPort, String appPackage, String appActivity) throws IOException  {

    	URL url = new URL("http://127.0.0.1:4444/wd/hub");


    	DesiredCapabilities capabilitiesUtil = new DesiredCapabilities();
    	capabilitiesUtil.setCapability("udid",udid);
    	capabilitiesUtil.setCapability("deviceName", deviceName);
    	capabilitiesUtil.setCapability("platformName", "Android");
    	capabilitiesUtil.setCapability("newCommandTimeout", 20000);
 //    	capabilitiesUtil.setCapability("platformVersion", "9");
 //   	capabilitiesUtil.setCapability("app", "D:\\appium\\signed_KT_GiGAGenie4_3.3.3(170)_211001-GoogleStore-release.apk");
    	capabilitiesUtil.setCapability("appPackage", appPackage);
    	capabilitiesUtil.setCapability("appActivity", appActivity);
    	capabilitiesUtil.setCapability("systemPort", systemPort);
    	capabilitiesUtil.setCapability("autoGrantPermissions", true);
    	capabilitiesUtil.setCapability("noReset", false);

    	driver = new AndroidDriver<>(url, capabilitiesUtil);

    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }



    @AfterTest(alwaysRun = true)
    public void teardown(){
        if(driver !=null) {

        	driver.quit();
        }
    }
}
