package com.xcel.qa.testcases.techadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TechadminACL extends BaseTest{


 @Test(priority=1)
 public void acl()
 {
	driver.findElement(By.xpath("//p[text()='ACL']")).click();
	
 }
 @Test(priority=2)
 public void module()
 {
	driver.findElement(By.xpath("//a[text()='Module']")).click();
	driver.findElement(By.id("search_key")).sendKeys("online class");
	Select status=new Select(driver.findElement(By.id("module-status")));
	status.selectByValue("ACTIVE");
	driver.findElement(By.id("filter-btn")).click();
	

 }
 @Test(priority=3)
 public void moduleAdd()
 {
  driver.findElement(By.xpath("//span[text()='Add']")).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("module-name"))).click();
  driver.findElement(By.id("module-name")).sendKeys("teacher");
  //driver.findElement(By.xpath("//label[text()='new']")).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-module"))).click();
  
	
 }
 @Test(priority=4)
 public void moduleMenu()
 {   
	 driver.findElement(By.xpath("//p[text()='ACL']")).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Menu']"))).click();
	 Select menu=new Select(driver.findElement(By.id("filter_by_menu")));
	 menu.selectByValue("22");
	 Select submenu=new Select(driver.findElement(By.id("filter_by_sun_menu")));
	 submenu.selectByValue("25");
	 
 }
}
