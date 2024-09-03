package com.xcel.qa.testcases.teacher;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherCertificateRequest extends BaseTest {

/*@Test(priority = 0)
	
	public void teacherLoginTest(){
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}*/
    @Test(priority=1)
    public void certifcaterequest() throws InterruptedException, AWTException
   {
	 WebElement ele1 = driver.findElement(By.xpath("//p[text()='CERTIFICATE REQUEST']"));
     JavascriptExecutor jse = (JavascriptExecutor) driver;
     jse.executeScript("arguments[0].click()", ele1);
    
     driver.findElement(By.id("search_certificate_name")).click();
     driver.findElement(By.id("search_certificate_name")).sendKeys("bronze medal certificate");
     
     Actions act=new Actions(driver);
	 WebElement ilink=driver.findElement(By.xpath("//span[@class='f_icons mr-0 ml-2 cursor_p']"));
   	 act.moveToElement(ilink).build().perform();
   	 
   	 driver.findElement(By.id("add-request-btn")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("certificate_type"))).click();
   	Select cername=new Select(driver.findElement(By.id("certificate_type")));
   	cername.selectByValue("3203");
   	
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).click();
     driver.findElement(By.id("description")).sendKeys("apply loan");
     Thread.sleep(1000);
     
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send_request_btn"))).click();
      Thread.sleep(1000);
     
     // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cancel_request"))).click();
     

		
    
     
     
   }
}
