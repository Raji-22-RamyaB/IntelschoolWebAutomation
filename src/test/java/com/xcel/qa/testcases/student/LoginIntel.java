package com.xcel.qa.testcases.student;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class LoginIntel extends BaseTest {

	@Test(priority = 0)

	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("kalips");
		driver.findElement(By.id("password")).sendKeys("Omguru@5");
		driver.findElement(By.id("user-login")).click();

	}

	@Test(priority = 1)
	public void checkPageLoad() throws InterruptedException {
		Thread.sleep(2000);
		String pagename = driver.findElement(By.xpath("//span[contains(text(),'Welcome, ')]")).getText();
		System.out.println(pagename);
		String expectpagename = properties.getProperty("studentpagename");
		Assert.assertEquals(pagename, expectpagename, "wrong");

		// String pageTitle = driver.getTitle();
		// String expectedTitle = properties.getProperty("browserTitle");
		// Assert.assertEquals(pageTitle, expectedTitle, "Wrong page loaded");

	}

	@Test(priority = 2)
	public void dashboardTest() {
		driver.findElement(By.xpath("//p[text()='DASHBOARD']")).click();

	}

	@Test(priority = 3)
	public void curriculumTest() {
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//p[text()='CURRICULUM']")).click();

		driver.findElement(By.xpath("//a[text()='Homework']"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Homework']"))).click();

		driver.findElement(By.xpath("//p[text()='CURRICULUM']")).click();

		driver.findElement(By.xpath("//a[text()='Timetable']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Timetable']"))).click();

		driver.findElement(By.xpath("//p[text()='CURRICULUM']")).click();

		driver.findElement(By.xpath("//a[text()='Syllabus']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Syllabus']"))).click();
		act.build().perform();

	}
}