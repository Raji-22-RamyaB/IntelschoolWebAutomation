package com.xcel.qa.testcases.techadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TechadminLogout extends BaseTest {
	 @Test(priority=3)
	   public void logout() {
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile_pic"))).click();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Logout']"))).click();
		   driver.findElement(By.xpath("//button[text()='YES']")).click();
	   }
}
