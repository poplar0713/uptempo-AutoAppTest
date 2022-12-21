package com.test.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class KtMemberShip extends BaseSetting {
	ExtentTest test;

	@Test(priority = 0)
	public void loginTest() throws InterruptedException {
		driver.findElement(By.id("com.olleh.android.oc2:id/guide")).click();

		Thread.sleep(500);

		driver.findElement(By.id("com.olleh.android.oc2:id/dsp_tv_close")).click();

		driver.findElement(By.id("com.olleh.android.oc2:id/button_menu")).click();

		driver.findElement(By.id("com.olleh.android.oc2:id/Leftnavi_login")).click();

		// 로그인화면
		driver.findElement(By.id("com.olleh.android.oc2:id/spl_checkbox_login_keep")).click();
		driver.findElement(By.id("com.olleh.android.oc2:id/btn_hole")).click();
		driver.findElement(By.id("com.olleh.android.oc2:id/spl_edit_id")).sendKeys("test");
		driver.findElement(By.id("com.olleh.android.oc2:id/spl_edit_pwd")).sendKeys("test");

		driver.findElement(By.id("com.olleh.android.oc2:id/spl_btn_login")).click();

		Thread.sleep(2000);

	}
}