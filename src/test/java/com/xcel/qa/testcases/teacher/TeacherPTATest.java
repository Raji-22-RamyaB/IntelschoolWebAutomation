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

public class TeacherPTATest extends BaseTest {
	/*@Test(priority = 0)
	
	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}*/
 


    @Test(priority=1)
     public void pta() throws AWTException, InterruptedException
    {
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='PTA']"))).click();
    
    WebElement ele1 = driver.findElement(By.xpath("//p[text()='PTA']"));
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].click()", ele1);
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-date"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-date"))).sendKeys("22-03-2000");
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("meeting-status"))).click();
    Select sts=new Select(driver.findElement(By.id("meeting-status")));
    sts.selectByVisibleText("Active");
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Search']"))).click();
    
    
    
    
       


    
    
    
    
 
    }

		 }