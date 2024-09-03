package com.xcel.qa.testcases.techadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TechadminDashboard extends BaseTest{
	/*@Test(priority=0)
	public void salesmanagerLoginTest() {
		driver.findElement(By.id("username")).sendKeys("techadmin");
		driver.findElement(By.id("password")).sendKeys("T!ECHadMi@123");
		driver.findElement(By.id("user-login")).click();
	}*/
	@Test(priority=1)
	public void dashboard()
	{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='DASHBOARD']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-settings"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empupd-fname"))).clear();
	driver.findElement(By.id("empupd-fname")).sendKeys("Tech");
	driver.findElement(By.id("empupd-lname")).clear();
	driver.findElement(By.id("empupd-lname")).sendKeys("Admin");
	/*driver.findElement(By.id("empMobNo")).clear();
	driver.findElement(By.id("empMobNo")).sendKeys("9566067812");
	driver.findElement(By.id("empupd-mail")).clear();
	driver.findElement(By.id("empupd-mail")).sendKeys("techadmin");
	driver.findElement(By.xpath("//label[text()='Male']")).click();
	Select relegion=new Select(driver.findElement(By.id("empupd-religions")));
	relegion.selectByValue("301");*/
	driver.findElement(By.id("submitUpdEmps")).click();
	//driver.findElement(By.id("close-upd-profile-admin")).click();
	
	
	}
   
}
