package com.test.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class GigagenieLoginTest extends BaseSetting {
	ExtentTest test;

	@Test(priority = 0)
	public void loginTest() throws InterruptedException {

		// 첫시작 스크롤 가이드화면
		Thread.sleep(6000);
		
		//접근권한 설정하기가 나오는경우(S10에 나옴)
		if (driver.findElements(By.id("com.kt.gigagenie.mobile:id/btnBottom"))
				.size() > 0) {
			System.out.println("FOUND!");
			driver.findElement(By.id(
					"com.kt.gigagenie.mobile:id/btnBottom"))
					.click();
			
			driver.findElement(By.id(
					"com.android.permissioncontroller:id/permission_allow_button"))
					.click();
			driver.findElement(By.id(
					"com.android.permissioncontroller:id/permission_allow_button"))
					.click();
		} else {
			System.out.println("NOT FOUND!");
		}
		

		// 1. 로그인
		// 로그인 버튼 클릭(케이티아이디)
		Thread.sleep(2000);
		driver.findElement(By.id("com.kt.gigagenie.mobile:id/btnKtIdLogin")).click();

		// 아이디 입력
		driver.findElement(By.id("com.kt.gigagenie.mobile:id/selectAutologin")).click();
		driver.findElement(By.id("com.kt.gigagenie.mobile:id/inputId")).sendKeys("test");

		driver.findElement(By.id("com.kt.gigagenie.mobile:id/inputPwd")).sendKeys("test");

		driver.findElement(By.id("com.kt.gigagenie.mobile:id/btnLogin")).click();

		Thread.sleep(6000);

	}
}