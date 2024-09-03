package com.xcel.qa.testcases.student;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class StudentExtraCurricular extends BaseTest {

	@BeforeTest
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("kalips");
		driver.findElement(By.id("password")).sendKeys("Omguru@5");
		driver.findElement(By.id("user-login")).click();
	}

	@Test(priority = 0)
	public void studentExtracurricularTest() {
		driver.findElement(By.xpath("//p[text()='EXTRA CURRICULAR']")).click();
		String pagetext3 = driver.findElement(By.xpath("//p[text()='ExtraCurricular']")).getText();
		System.out.println(pagetext3);
		String expectedtext3 = properties.getProperty("Extratext");
		Assert.assertEquals(pagetext3, expectedtext3, "WrongText");
		Select extra = new Select(driver.findElement(By.id("session-id")));
		extra.selectByVisibleText("2021-2022");
		String pagetext4 = driver.findElement(By.xpath("//a[text()='Addl Info']/following::div[7]")).getText();
		System.out.println(pagetext4);
		String expectedtext4 = properties.getProperty("Extratext2");
		Assert.assertEquals(pagetext4, expectedtext4, "WrongText");
	}

}
