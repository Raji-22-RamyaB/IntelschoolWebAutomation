package com.xcel.qa.testcases.student;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class StudentExamTest extends BaseTest {

	@Test(priority=-1)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("kalips");
		driver.findElement(By.id("password")).sendKeys("Omguru@5");
		driver.findElement(By.id("user-login")).click();
	}

	@Test(priority = 0)
	public void examTest() {
		driver.findElement(By.xpath("//p[text()='EXAM']")).click();
	}

	@Test(priority = 1)
	public void examScheduleTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Exam Schedule']")).click();
		String pagetext = driver.findElement(By.xpath("//p[text()='Exam Schedule']")).getText();
		System.out.println(pagetext);
		String expectedtext = properties.getProperty("Examtext");
		Assert.assertEquals(pagetext, expectedtext, "wrongText");
		Select exam = new Select(driver.findElement(By.id("exam-id")));
		exam.selectByVisibleText("Annual Exam");
		driver.findElement(By.xpath("//span[text()='Syllabus']")).click();
		Thread.sleep(2000);
		Select exam1 = new Select(driver.findElement(By.id("subject-exam-id")));
		exam1.selectByValue("1965");
		driver.findElement(By.xpath("//h4[@id='classModalCenterTitle']/following::span[1]")).click();
	}

	@Test(priority = 2)
	public void examResultTest() throws InterruptedException {
		driver.findElement(By.xpath("//p[text()='EXAM']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Exam Result']"))).click();
		Select result = new Select(driver.findElement(By.id("exam-id")));
		result.selectByValue("584");
		Thread.sleep(2000);
		driver.findElement(By.id("submit-event")).click();

	}
}
