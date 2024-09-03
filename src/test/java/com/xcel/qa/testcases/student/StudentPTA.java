package com.xcel.qa.testcases.student;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class StudentPTA extends BaseTest {
	@Test(priority = 0)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("kalips");
		driver.findElement(By.id("password")).sendKeys("Omguru@5");
		driver.findElement(By.id("user-login")).click();
	}

	@Test(priority = 1)
	public void studentPTA() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//p[text()='PTA']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
		driver.findElement(By.id("start-date")).click();
		driver.findElement(By.id("start-date")).sendKeys("01-07-2020");
		Select status = new Select(driver.findElement(By.id("meeting-status")));
		status.selectByVisibleText("Active");
		driver.findElement(By.id("view-document")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='show-all-docs']/following::span[1]")).click();

	}

}
