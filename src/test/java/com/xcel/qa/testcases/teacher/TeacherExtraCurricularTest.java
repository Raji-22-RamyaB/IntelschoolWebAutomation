package com.xcel.qa.testcases.teacher;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherExtraCurricularTest extends BaseTest {
	/*@Test(priority = 0)
	
	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}*/
  @Test(priority=1)
  public void extraccr()
  {
	 
	    WebElement ele1 = driver.findElement(By.xpath("//p[text()='EXTRA CURRICULAR']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele1);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("session-id"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("session-id"))).sendKeys("2021-2022");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Search']"))).click();
		
	    driver.findElement(By.id("show_feedback")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complaints"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complaints"))).sendKeys("its useful");
	     
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Name']"))).click();
	     
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-complaints"))).click();
 
	    
	    
	    
	  
  }
}
