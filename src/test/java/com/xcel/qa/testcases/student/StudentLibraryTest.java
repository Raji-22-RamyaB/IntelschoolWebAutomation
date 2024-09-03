package com.xcel.qa.testcases.student;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class StudentLibraryTest extends BaseTest {
	@Test(priority = 0)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("kalips");
		driver.findElement(By.id("password")).sendKeys("Omguru@5");
		driver.findElement(By.id("user-login")).click();
	}

	@Test(priority = 1)
	public void libraryManagementTest() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//p[text()='LIBRARY MANAGEMENT']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
		String pagetext5 = driver.findElement(By.xpath("//p[text()='Library Management']")).getText();
		System.out.println(pagetext5);
		String expectedtext5 = properties.getProperty("librarytext");
		Assert.assertEquals(pagetext5, expectedtext5, "WrongText");
		driver.findElement(By.xpath("//h5[text()='Due Books']")).click();
		driver.findElement(By.xpath("//h5[text()='Requested']")).click();
		driver.findElement(By.xpath("//h5[text()='History']")).click();
		String number =driver.findElement(By.id("history-count")).getText();
		System.out.println(number);
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.id("search_user_books"))).build().perform();
		act.sendKeys("the selfish giant").build().perform();
		act.moveToElement(driver.findElement(By.partialLinkText("The Selfish Giant"))).click().build().perform();
		
	}

}
