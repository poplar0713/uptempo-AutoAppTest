package com.test.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class OllehTvGuide extends BaseSetting {
	ExtentTest test;

	@Test(priority = 0)
	public void loginTest() throws InterruptedException {

		driver.findElement(By.id("com.kth.ollehtvguide:id/dialog_device_permission_tv_agree")).click();
		driver.findElement(By.id("com.kth.ollehtvguide:id/tv_tutorial_skip")).click();

		Thread.sleep(500);
		driver.findElement(By.id("com.kth.ollehtvguide:id/iv_main_image_new")).click();
		driver.findElement(By.id("com.kth.ollehtvguide:id/home_iv_user")).click();

		driver.findElement(By.id("com.kth.ollehtvguide:id/tv_mypage_login_join")).click();

		driver.findElement(By.id("com.kth.ollehtvguide:id/btn_ktidlogin")).click();

		driver.findElement(By.id("com.kth.ollehtvguide:id/et_id")).sendKeys("test");
		driver.findElement(By.id("com.kth.ollehtvguide:id/et_pwd")).sendKeys("test");

		driver.findElement(By.id("com.kth.ollehtvguide:id/ibtn_login")).click();

		Thread.sleep(3000);

	}
}