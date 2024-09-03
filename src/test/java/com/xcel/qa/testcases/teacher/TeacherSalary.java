package com.xcel.qa.testcases.teacher;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherSalary extends BaseTest {
/*@Test(priority = 0)
	
	public void teacherLoginTest  () {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}*/
  @Test(priority=1)
  public void salary()
  {
	
	 WebElement ele1 = driver.findElement(By.xpath("//p[text()='SALARY']"));
     JavascriptExecutor jse = (JavascriptExecutor) driver;
     jse.executeScript("arguments[0].click()", ele1);
  }
  
 @Test(priority=2)
 public void salaryoption()
 {

	 WebElement ele1 = driver.findElement(By.xpath("//p[text()='SALARY']"));
     JavascriptExecutor jse = (JavascriptExecutor) driver;
	 jse.executeScript("arguments[0].click()", ele1);
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Pay Date']"))).click();
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Start Period']"))).click();
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='End Period']"))).click();

	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Net Amount']"))).click();

	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Pay Slip']"))).click();
 }
 
 /*@Test(priority=3)
 public void payslip()
 {

	 WebElement ele1 = driver.findElement(By.xpath("//p[text()='SALARY']"));
     JavascriptExecutor jse = (JavascriptExecutor) driver;
	 jse.executeScript("arguments[0].click()", ele1);
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[5]/p/span"))).click();
	 
	 //driver.findElement(By.id("print-paySlip")).click();
	 
}*/
}
