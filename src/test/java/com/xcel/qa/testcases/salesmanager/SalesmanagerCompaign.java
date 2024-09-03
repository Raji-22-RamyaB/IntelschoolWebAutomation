package com.xcel.qa.testcases.salesmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class SalesmanagerCompaign extends BaseTest {

   @Test(priority=0)
   public void compaign() {
	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='CAMPAIGN']"))).click();
	   driver.findElement(By.xpath("//span[text()='Create']")).click();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='E-mail'])[2]"))).click();
	   driver.findElement(By.id("campaign_name")).sendKeys("pongal");
	   driver.findElement(By.id("subject")).sendKeys("[pongal holiday");
	   driver.findElement(By.id("add-campaign-btn")).click();
	  // driver.findElement(By.xpath("//span[text()='+']")).click();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("schedule-discard-btn"))).click();
	   driver.findElement(By.xpath("//button[text()='NO']")).click();
   }

}
