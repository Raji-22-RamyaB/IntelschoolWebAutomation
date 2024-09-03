package com.xcel.qa.testcases.teacher;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherMyWorksheet extends BaseTest {

	/*@Test(priority = 0)
	
		public void teacherLoginTest() {
			driver.findElement(By.id("username")).sendKeys("rajkamal");
			driver.findElement(By.id("password")).sendKeys("Guruom@5");
			driver.findElement(By.id("user-login")).click();
		}*/
	 
	@Test(priority=1)
	public void worksheet()
	{
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WORKSHEET']"))).click();		
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sheet-date"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sheet-date"))).sendKeys("20-02-2022");
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add ']"))).click();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-time"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-time"))).sendKeys("12:45AM");
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end-time"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end-time"))).sendKeys("adf");
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("Mathematics");
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-worksheet"))).click();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cancel-worksheet"))).click();
	}
	
	

}
