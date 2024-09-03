package com.xcel.qa.testcases.student;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class StudentFess extends BaseTest {
	
	@Test(priority = 0)
	public void studentClassFeesTest() {
		driver.findElement(By.xpath("//p[text()='FEES']")).click();
		driver.findElement(By.xpath("//span[text()='Class Fee']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='View History']"))).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'View History')]//following::span[1]")))
				.click();
	}

	@Test(priority = 1)
	public void studentBusFeesTest() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Bus Fee']"))).click();
		Thread.sleep(2000);
		Select date = new Select(driver.findElement(By.id("session-id-busfees")));
		date.selectByVisibleText("2021-2022");
		String text = driver.findElement(By.xpath("//div[contains(text(),'No bus fees found')]")).getText();
		System.out.println(text);
		String expectedtext = properties.getProperty("textdata");
		Assert.assertEquals(text, expectedtext, "wrongtext");
	}
}
