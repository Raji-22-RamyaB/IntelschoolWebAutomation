package com.xcel.qa.testcases.salesmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.xcel.qa.base.BaseTest;

public class SalesmanagerSchools extends BaseTest{

   @Test(priority=1)
   public void schools() {
	   
	   driver.findElement(By.xpath("//p[text()='SCHOOLS']")).click();
   }
   @Test(priority=2)
   public void school()
   {
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filter_by_name"))).click();
	 driver.findElement(By.id("filter_by_name")).sendKeys("Rajiv");
	 driver.findElement(By.id("filter_by_city")).sendKeys("chennai");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status"))).click();
	 Select ele=new Select(driver.findElement(By.id("status")));
	 ele.selectByIndex(2);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Search']"))).click();

   }
   @Test(priority=3)
   public void add()
   {
    driver.findElement(By.id("add-schools")).click();  
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("school_name"))).click();
	driver.findElement(By.id("school_name")).sendKeys("aravind vidhyalaya");
	driver.findElement(By.id("address")).sendKeys("2nd Street,ganghi nagar,cennai");
	driver.findElement(By.id("pincode")).sendKeys("600056");
	driver.findElement(By.id("email")).sendKeys("aravindvidhyalaya@gmail.com");

	driver.findElement(By.id("contact_no")).sendKeys("9512634870");

	Select scl=new Select(driver.findElement(By.id("school-board")));
	scl.selectByIndex(2);
	
	Select scltype=new Select(driver.findElement(By.id("school-type")));
	scltype.selectByIndex(1);
	
    driver.findElement(By.id("no-of-branch")).sendKeys("5");

	Select state=new Select(driver.findElement(By.id("school_state")));
	state.selectByVisibleText("Tamil Nadu");	
	
	driver.findElement(By.id("city")).sendKeys("chennai");
	
//	driver.findElement(By.id("submitSchool")).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@id='close-modal'])[5]"))).click();

	
	
	   
	   
	   
	   
	   
	   
   }
}
