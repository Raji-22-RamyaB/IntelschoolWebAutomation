package com.xcel.qa.testcases.student;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class StudentCertificateTest extends BaseTest {
	@Test(priority = 0)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("kalips");
		driver.findElement(By.id("password")).sendKeys("Omguru@5");
		driver.findElement(By.id("user-login")).click();
	}

	@Test(priority = 1)
	public void certificateRequestTest() throws InterruptedException {
		WebElement ele1 = driver.findElement(By.xpath("//p[text()='CERTIFICATE REQUEST']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele1);
		String pagetext6 = driver.findElement(By.xpath("//p[text()='Certificate Request']")).getText();
		System.out.println(pagetext6);
		String expectedtext6 = properties.getProperty("certific");
		Assert.assertEquals(pagetext6, expectedtext6, "WrongText");
		driver.findElement(By.id("add-request-btn")).click();
		Thread.sleep(2000);
		Select certify = new Select(driver.findElement(By.id("certificate_type")));
		certify.selectByVisibleText("Bonafide Certificate");
		driver.findElement(By.id("description")).click();
		driver.findElement(By.id("description")).sendKeys("please give me bonafide certificate");
		driver.findElement(By.id("send_request_btn")).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.id("search_certificate_name"))).build().perform();
		act.sendKeys("Bonafide Certificate").build().perform();
		Thread.sleep(2000);
		driver.findElement(By.id("cancel-request_2")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='YES']")).click();
		/*
		 * //Alert aler = driver.switchTo().alert(); aler.accept();
		 */
	}

}
