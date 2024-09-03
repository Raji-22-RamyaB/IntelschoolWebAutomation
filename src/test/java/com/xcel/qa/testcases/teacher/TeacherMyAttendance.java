  package com.xcel.qa.testcases.teacher;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherMyAttendance extends BaseTest {
	/*@Test(priority = 0)
	
	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}*/
	@Test(priority=1)
	public void attendence() throws InterruptedException
	
     {
		
		WebElement ele1 = driver.findElement(By.xpath("//p[.='MYATTENDANCE']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele1);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("get-attend-month"))).click();
		Select dt=new Select(driver.findElement(By.id("get-attend-month")));
		dt.selectByValue("2");
     
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Download']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-date"))).click();
		driver.findElement(By.id("start-date")).sendKeys("08-02-2021");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end-date"))).click();
		//driver.findElement(By.id("end-date")).sendKeys("08-02-2022");
		
		WebElement ele2 = driver.findElement(By.id("end-date"));
		ele2.sendKeys("08-02-2022");
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("arguments[0].click()", ele2);
		Thread.sleep(1000);
		
		driver.findElement(By.id("date-submit-btn")).click();
		
	
		
		
		
     }
}
