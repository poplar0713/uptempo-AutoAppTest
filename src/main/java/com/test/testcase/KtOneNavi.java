package com.test.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class KtOneNavi extends BaseSetting {
	ExtentTest test;

	@Test(priority = 0)
	public void loginTest() throws InterruptedException {

		driver.findElement(By.id("kt.navi:id/confirm")).click();

		Thread.sleep(500);
		// 이용약관동의
		driver.findElement(By.id("kt.navi:id/clauseAllAgree")).click();
		driver.findElement(By.id("kt.navi:id/rlOk")).click();
		Thread.sleep(500);

		// 팝업유무에 따라

		if (driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.TextView"))
				.size() > 0) {
			System.out.println("FOUND!");
			driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.TextView"))
					.click();
		} else {
			System.out.println("NOT FOUND!");
		}

		//메뉴클릭
		driver.findElement(By.id("kt.navi:id/iv_New_Badge")).click();

		Thread.sleep(500);

		driver.findElement(By.id("kt.navi:id/rlMyMenuDriveHistory")).click();

		driver.findElement(By.id("kt.navi:id/rlSocialLoginGoogle")).click();

		driver.findElement(By.id("com.google.android.gms:id/account_particle_disc")).click();

		Thread.sleep(2000);

	}
}