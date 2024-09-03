package com.xcel.qa.testcases.salesmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class SalesmanagerProfile extends BaseTest{
@Test(priority = 0)

   public void dashboard() {
	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile_pic"))).click();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Profile']"))).click();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empupd-fname"))).clear();
	   driver.findElement(By.id("empupd-fname")).sendKeys("sales");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empupd-lname"))).clear();
	   driver.findElement(By.id("empupd-lname")).sendKeys("manager");
	   
	   driver.findElement(By.id("empupd-mob")).clear();
	   driver.findElement(By.id("empupd-mob")).sendKeys("9852631475");
	   driver.findElement(By.id("empupd-offNo")).clear();
	   driver.findElement(By.id("empupd-offNo")).sendKeys("9852631475");
	   driver.findElement(By.id("empupd-mail")).clear();
	   driver.findElement(By.id("empupd-mail")).sendKeys("salesmanager@gmail.com");
	   driver.findElement(By.xpath("//label[text()='Male']")).click();
	   Select rel=new Select(driver.findElement(By.id("empupd-religions")));
	   rel.selectByValue("301");
	   }
   @Test(priority=1)
   public void dob(){
	   
   
	   
	   WebElement date = driver.findElement(By.id("empupd-dob"));
	   String dateVal = "10-06-1985"; 
	   selectDateByJS(driver,date,dateVal);
   }	 									
	   private void selectDateByJS(WebDriver driver, WebElement date, String dateVal) //1st write this method
	   {
	   JavascriptExecutor js= (JavascriptExecutor)driver;
	   js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", date);
	   }

	   @Test(priority=2)
	   public void submit()
	   {
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitUpdEmps"))).click();  
		   driver.findElement(By.id("close-upd-profile-admin")).click();
	   }
	
	   @Test(priority=3)
	   public void logout() {
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile_pic"))).click();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Logout']"))).click();
		   driver.findElement(By.xpath("//button[text()='YES']")).click();
	   }
   }


