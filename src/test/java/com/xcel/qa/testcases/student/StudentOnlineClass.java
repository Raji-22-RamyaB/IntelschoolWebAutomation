package com.xcel.qa.testcases.student;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class StudentOnlineClass extends BaseTest {
	

	@Test(priority = 0)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("kalips");
		driver.findElement(By.id("password")).sendKeys("Omguru@5");
		driver.findElement(By.id("user-login")).click();
	}

	@Test(priority = 1)
	public void onlineClass() {
		WebElement ele1 = driver.findElement(By.xpath("//p[text()='ONLINE CLASSES']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele1);
		driver.findElement(By.id("start-date")).click();
		driver.findElement(By.id("start-date")).sendKeys("29-01-2022 to 22-02-2002");
		String text = driver.findElement(By.xpath("//div[contains(text(),'No record found')]")).getText();
		System.out.println(text);
	}
}