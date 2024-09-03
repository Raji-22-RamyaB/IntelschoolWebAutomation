package com.xcel.qa.testcases.teacher;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;
public class TeacherAnalyticsTest extends BaseTest{
/*@Test(priority = 0)
	
	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
       }*/
  @Test(priority=1)
  public void analytics() throws AWTException, InterruptedException 
  {
	 Actions act=new Actions(driver);	
	 WebElement stud=driver.findElement(By.xpath("//p[text()='ANALYTICS']"));
	 act.moveToElement(stud).build().perform();
	
	WebElement ele1 = driver.findElement(By.xpath("//a[text()='Class Exam Report']"));
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].click()", ele1);
	//  driver.findElement(By.xpath("//a[text()='Class Exam Report']")).click();
	  
   // driver.findElement(By.id("session-id")).click();
    Select yr=new Select(driver.findElement(By.id("session-id")));
    yr.selectByValue("34");
    
    Select cs=new Select(driver.findElement(By.id("class-id")));
    cs.selectByValue("389");
    
    Select sec=new Select(driver.findElement(By.id("section-id")));
    sec.selectByValue("139");
    
    Select ex=new Select(driver.findElement(By.id("exam-id")));
    ex.selectByValue("1013");
    
    Select sub=new Select(driver.findElement(By.id("subject-id")));
    sub.selectByValue("1966");
    
    Select grd=new Select(driver.findElement(By.id("grade-id")));
    grd.selectByValue("A");
  
    Select sym=new Select(driver.findElement(By.id("symbols")));
    sym.selectByValue("=");
    
   driver.findElement(By.id("mark_number")).sendKeys("90");
    
    driver.findElement(By.xpath("//span[text()='Search']")).click();
     
    
      
	
  }
}

	

	
	

	
	

