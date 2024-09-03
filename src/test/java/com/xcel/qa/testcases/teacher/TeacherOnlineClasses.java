package com.xcel.qa.testcases.teacher;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherOnlineClasses extends BaseTest{
	/*@Test(priority = 0)
	
	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}
	*/
	@Test(priority=1)
	public void onlinecls() throws InterruptedException, AWTException
	{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-date"))).click();
		 WebElement ele1 = driver.findElement(By.xpath("//p[text()='ONLINE CLASSES']"));
		    JavascriptExecutor jse = (JavascriptExecutor) driver;
		    jse.executeScript("arguments[0].click()", ele1);
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-date"))).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-date"))).sendKeys("24-02-2022 to 24-02-2022");
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sessions_list"))).click();
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("class_list"))).click();
		    Select classlist=new Select(driver.findElement(By.id("class_list")));
		    classlist.selectByValue("528");
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("section_list"))).click();
		    Select seclist=new Select(driver.findElement(By.id("section_list")));
		    seclist.selectByValue("229");
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Search']"))).click();
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-session"))).click();
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title"))).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title"))).sendKeys("onlineclass");
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date"))).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date"))).sendKeys("24-02-2022");
		   
		   /* 
		    WebElement elle2 = driver.findElement(By.id("start_time"));
		    JavascriptExecutor jsse2 = (JavascriptExecutor) driver;
		    jsse2.executeScript("arguments[0].click()", elle2);
		    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_time"))).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_time"))).sendKeys("05:00 PM");
		    
		    
		    WebElement ellle2 = driver.findElement(By.id("end_time"));
		    JavascriptExecutor jssse2 = (JavascriptExecutor) driver;
		    jssse2.executeScript("arguments[0].click()", ellle2);
		   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end_time"))).click();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end_time"))).sendKeys("05:30PM");
		*/
		   
		    WebElement ele2 = driver.findElement(By.id("class_list_modal"));
		    JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		    jse2.executeScript("arguments[0].click()", ele2);
		    Select clsmdl=new Select(driver.findElement(By.id("class_list_modal")));
		    clsmdl.selectByValue("529");
		
		    WebElement ele3 = driver.findElement(By.id("section_list_modal"));
		    JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		    jse3.executeScript("arguments[0].click()", ele3);
		    Select secmdl=new Select(driver.findElement(By.id("section_list_modal")));
		    secmdl.selectByValue("231");
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("student must attend the onlineclass");
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_session"))).click(); 
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fas fa-times-circle']"))).click(); 

		  

		    
	} 
}
