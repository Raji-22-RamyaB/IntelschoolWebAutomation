package com.xcel.qa.testcases.student;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xcel.qa.base.BaseTest;

public class StudentDashboardTest extends BaseTest {
	@Test(priority = -1)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("kalips");
		driver.findElement(By.id("password")).sendKeys("Omguru@5");
		driver.findElement(By.id("user-login")).click();
	}
	
	@Test(priority = 0)
	public void studentDashboardTest() throws InterruptedException {
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(driver.findElement(By.xpath("//*[@id='stu-notice-his']/div/div[1]/div/div[1]/p")).getText(), "Notice", "Notice section not available in dashboard page");
		softAssert.assertEquals(driver.findElement(By.xpath("//*[@id='stu-event-his']/div/div[1]/div/div[1]/p")).getText(), "Event", "Notice section not available in dashboard page");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		softAssert.assertEquals(driver.findElement(By.xpath("//*[@id='profile-header']/div[1]/h5")).getText(), "Profile", "Profile section not available in dashboard page");
		softAssert.assertEquals(driver.findElement(By.xpath("//*[@id='branch-profile-header']/div/h5")).getText(), "Institute Profile", "Institute Profile section not available in dashboard page");
		softAssert.assertEquals(driver.findElement(By.xpath("//*[@id='show-stu-flow-chart']/div/div[1]/div/div/p")).getText(), "Attendance", "Attendance section not available in dashboard page");
		
		js.executeScript("window.scrollBy(document.body.scrollHeight, 0)");
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 1)
	public void studentAllNoticeTest() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("view-more-notice"))).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='listing']/div[3]/div/div/div/div[1]/div/div/p")).getText(), "Notice History", " Student notice history failed to load");
	}
	 
	@Test(priority = 2)
	public void studentAllEventsTest() {            
		driver.navigate().back();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("view-more-events"))).click();
		//driver.findElement(By.id("view-more-events")).click();
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='event-width']/div/div/div[1]/div/div[1]/p"))).getText(), "Event Calendar", " Student event calendar failed to load");
	}
	
}                                                                                                                                                            
