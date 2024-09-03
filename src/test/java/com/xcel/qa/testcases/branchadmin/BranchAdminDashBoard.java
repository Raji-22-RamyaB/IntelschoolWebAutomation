package com.xcel.qa.testcases.branchadmin;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class BranchAdminDashBoard extends BaseTest{
	@Test(priority = -1)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("branchadmin");
		driver.findElement(By.id("password")).sendKeys("brAdm@iNT!!45");
		driver.findElement(By.id("user-login")).click();
	}
     @Test(priority=0)
    	 public void checkForPageLoaded() {
    			String pageTitle = driver.getTitle();
    			String expectedTitle = "IntelSchool";
    			Assert.assertEquals(pageTitle, expectedTitle, "Wrong page loaded");
     }
     @Test(priority=1)
     public void dashBoard()
     {
    	 driver.findElement(By.xpath("//P[text()='DASHBOARD']")).click();
    	 
     }
     
}