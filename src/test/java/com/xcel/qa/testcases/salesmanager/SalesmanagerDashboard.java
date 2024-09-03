package com.xcel.qa.testcases.salesmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class SalesmanagerDashboard extends BaseTest{
@Test(priority = 0)
	
	public void salesmanagerLoginTest() {
		driver.findElement(By.id("username")).sendKeys("salesmanager");
		driver.findElement(By.id("password")).sendKeys("S@LE!!SMgr@123");
		driver.findElement(By.id("user-login")).click();
	}

   @Test(priority=1)
   public void dashboard() {
	   
	   driver.findElement(By.xpath("//p[text()='DASHBOARD']")).click();
   }
  
   @Test(priority=2)
   public void salesExecutive()
   {
	   driver.findElement(By.xpath("//small[text()='Total Executive']")).click();
	   driver.findElement(By.id("search_input")).sendKeys("sales executive");
	 //  driver.findElement(By.xpath("//button[text()='Change']")).click();
	  // driver.findElement(By.xpath("//img[@src='https://65.2.151.77:443/images/repairing.png']")).click();
	   
   }
   
   @Test(priority=3)
   public void add()
   {
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Add'])[1]"))).click();
	 
	 driver.findElement(By.id("executive-first-name")).sendKeys("Rajiv");
	 
	 driver.findElement(By.id("executive-last-name")).sendKeys("m");

	 driver.findElement(By.id("executive-mobile-number")).sendKeys("6598321470");

	 driver.findElement(By.id("executive-email")).sendKeys("rajiv@gmail.com");

	 driver.findElement(By.id("executive-userName")).sendKeys("salesmanager");

	 driver.findElement(By.id("executive-password")).sendKeys("S@LE!!SMgr@123");

	 driver.findElement(By.id("confPassword")).sendKeys("S@LE!!SMgr@123");
	 
	 driver.findElement(By.id("submitExecutiveDet")).click();
     
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@id='close-modal'])[5]"))).click();
	 
	    
   }
   
  
}

