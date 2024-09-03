package com.xcel.qa.testcases.teacher;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherLibraryManagementTest extends BaseTest {

/*@Test(priority = 0)
	
	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}*/
   @Test(priority=1)
   public void libmanagement() throws InterruptedException
   {
	    WebElement ele1 = driver.findElement(By.xpath("//p[text()='LIBRARY MANAGEMENT']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele1);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_user_books"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_user_books"))).sendKeys("wings of fire");
		driver.findElement(By.id("search-modal-close")).click();
		Thread.sleep(1000);

		Actions act=new Actions(driver);
		WebElement ilink=driver.findElement(By.xpath("//span[@class='f_icons mr-0 ml-2 cursor_p']"));
		act.moveToElement(ilink).build().perform();
		
		WebElement ele2 = driver.findElement(By.id("due-tab"));
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("arguments[0].click()", ele2);
		
		WebElement ele3 = driver.findElement(By.id("reserve-tab"));
		JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		jse3.executeScript("arguments[0].click()", ele3);
		
		WebElement ele4 = driver.findElement(By.id("history-tab"));
		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("arguments[0].click()", ele4);
   
		 WebElement ele5 = driver.findElement(By.id("show_feedback"));
	     JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		 jse5.executeScript("arguments[0].click()", ele5);
		 
		/*WebElement ele6 = driver.findElement(By.id("complaints"));
	     JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		 jse6.executeScript("arguments[0].click()", ele6);
		 ele6.sendKeys("itsgood");*/
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complaints"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complaints"))).sendKeys("its useful");
		 Thread.sleep(1000);

		 
		WebElement ele7 = driver.findElement(By.id("add-complaints"));
	    JavascriptExecutor jse7 = (JavascriptExecutor) driver;
		jse7.executeScript("arguments[0].click()", ele7);
		 
	   

   } 
}
