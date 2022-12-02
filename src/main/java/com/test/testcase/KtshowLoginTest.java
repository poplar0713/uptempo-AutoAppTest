package com.test.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class KtshowLoginTest extends BaseSetting {
	ExtentTest test;

	@Test(priority = 0)
	public void loginTest() throws InterruptedException {

		// 1. 접근권한 확인
		Thread.sleep(500);
		driver.findElement(By.id("com.ktshow.cs:id/btn_confirm")).click();

		// 2. 가이드
		Thread.sleep(500);
		driver.findElement(By.id("com.ktshow.cs:id/btn_next")).click();
		driver.findElement(By.id("com.ktshow.cs:id/btn_next")).click();
		driver.findElement(By.id("com.ktshow.cs:id/btn_next")).click();
		driver.findElement(By.id("com.ktshow.cs:id/btn_next")).click();
		driver.findElement(By.id("com.ktshow.cs:id/btn_next")).click();
		driver.findElement(By.id("com.ktshow.cs:id/btn_next")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView"))
				.click();

		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView"))
				.click();
		//팝업 존재 확인
		if (driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.app.Dialog/android.view.View/android.view.View[2]/android.widget.Button[2]"))
				.size() > 0) {
			System.out.println("FOUND!");
			driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.app.Dialog/android.view.View/android.view.View[2]/android.widget.Button[2]"))
					.click();
		} else {
			System.out.println("NOT FOUND!");
		}

		driver.findElement(By.id("com.ktshow.cs:id/iv_my")).click();
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"로그인\"]")).click();

		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.CheckBox"))
				.click();

		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.EditText"))
				.sendKeys("specialist10");
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText"))
				.sendKeys("**********");
        //로그인버튼
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[1]/android.widget.Button"))
				.click();

		driver.findElement(By.id("com.ktshow.cs:id/btn_confirm")).click();
		//


		//driver.findElement(By.id("com.ktshow.cs:id/btn_confirm")).click();

		driver.findElement(By.id("com.ktshow.cs:id/tv_confirm")).click();

		driver.findElement(By.id("com.ktshow.cs:id/tv_confirm")).click();
		Thread.sleep(6000);

	}
}