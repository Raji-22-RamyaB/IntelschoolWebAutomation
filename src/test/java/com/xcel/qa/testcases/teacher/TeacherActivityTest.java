package com.xcel.qa.testcases.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherActivityTest extends BaseTest {
@Test(priority = 0)
	
	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}
  @Test(priority=1)
  public void activity()
  {
	Actions act=new Actions(driver);
	WebElement ele=driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
	act.moveToElement(ele).build().perform();

	 WebElement ele2 = driver.findElement(By.xpath("//a[text()='Message']"));
	 JavascriptExecutor jse = (JavascriptExecutor) driver;
	 jse.executeScript("arguments[0].click()", ele2);
	 
	 driver.findElement(By.id("msg-sms")).click();
	 driver.findElement(By.id("internal")).click();
	    
	// driver.findElement(By.id("msg-email")).click();
	 //driver.findElement(By.id("external")).click();
	 
	 Select opt=new Select(driver.findElement(By.id("choose-category")));
	 opt.selectByVisibleText("All Students");
	 
	 driver.findElement(By.id("msg-content")).click();
	 driver.findElement(By.id("msg-content")).sendKeys("students attend the practical exam without fail");
	  
	driver.findElement(By.xpath("//a[text()='Click to view Message History']")).click();
	driver.findElement(By.linkText("Click to view Message History")).click();
	// driver.navigate().back();
	
	
	 Set<String> windowHandles = driver.getWindowHandles();
     List<String> windowHandlesList = new ArrayList<>(windowHandles); 
     driver.switchTo().window(windowHandlesList.get(0));
	 
	
  }
  @Test(priority=2)
  public void msghistry()
  {
	    Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
		act.moveToElement(ele).build().perform();

        WebElement ele3 = driver.findElement(By.xpath("//a[text()='Message History']"));
		JavascriptExecutor jse3= (JavascriptExecutor) driver;
		jse3.executeScript("arguments[0].click()", ele3); 
		
		driver.findElement(By.xpath("(//a[text()='Message'])[2]")).click();
		
		driver.findElement(By.xpath("//a[text()='Subject']")).click();
		
		driver.findElement(By.xpath("//a[text()='Date']")).click();
		
		driver.findElement(By.xpath("//a[text()='Type']")).click();
		
		
  }
  @Test(priority=3)
  public void notice()
  {
	  Actions act=new Actions(driver);
      WebElement ele=driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
	  act.moveToElement(ele).build().perform();

      WebElement ele4 = driver.findElement(By.xpath("//a[text()='Notice']"));
	  JavascriptExecutor jse4= (JavascriptExecutor) driver;
	  jse4.executeScript("arguments[0].click()", ele4);   
	  
	  Select op=new Select(driver.findElement(By.id("choose-category")));
      op.selectByVisibleText("All Students");
      
      driver.findElement(By.id("title-content")).click();
      driver.findElement(By.id("title-content")).sendKeys("schools are reopen on wednesday");
      
      driver.findElement(By.id("msg-content")).click();
      driver.findElement(By.id("msg-content")).sendKeys("schools are reopen on wednesday,so students should come without fail");
	  
      driver.findElement(By.linkText("Click to view Notice History")).click();
 	  driver.navigate().back();
 	   
 	 //WINDOW HANDLING 
 	   Set<String>tabs = driver.getWindowHandles();
	     ArrayList<String> tabslist = new ArrayList(tabs);
			driver.switchTo().window(tabslist.get(0));//window handling
 	 
 	  WebElement ele6 = driver.findElement(By.xpath("//a[text()='Notice']"));
	  JavascriptExecutor jse6= (JavascriptExecutor) driver;
	  jse6.executeScript("arguments[0].click()", ele6);   
 	  
 	  WebElement ele5= driver.findElement(By.id("selectedStudMsgDet"));
	  JavascriptExecutor jse5= (JavascriptExecutor) driver;
	  jse5.executeScript("arguments[0].click()", ele5);   
  }
	 
  @Test(priority=4)
  public void noticehistry()
  {
	  Actions act=new Actions(driver);
      WebElement ele=driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
	  act.moveToElement(ele).build().perform();

      WebElement not = driver.findElement(By.xpath("//a[text()='Notice History']"));
	  JavascriptExecutor se= (JavascriptExecutor) driver;
	  se.executeScript("arguments[0].click()", not);   
	 
  }
	 
	 
  @Test(priority=5)
  public void gallery()
  {
	  Actions act=new Actions(driver);
      WebElement ele=driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
	  act.moveToElement(ele).build().perform();

      WebElement gal = driver.findElement(By.xpath("//a[text()='Gallery']"));
	  JavascriptExecutor galhis= (JavascriptExecutor) driver;
	  galhis.executeScript("arguments[0].click()", gal);   
	 
	 // driver.findElement(By.id("list-image-list")).sendKeys("17-01-2020 to 12-01-2022");
	  //driver.findElement(By.xpath("//span[text()='May']")).click();
}
	
	 
  @Test(priority=6)
  public void EventHoliday()
  {
	  Actions act=new Actions(driver);
      WebElement ele=driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
	  act.moveToElement(ele).build().perform();

      WebElement evt = driver.findElement(By.xpath("//a[text()='Event & Holiday']"));
	  JavascriptExecutor hld= (JavascriptExecutor) driver;
	  hld.executeScript("arguments[0].click()", evt);   
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("get-holiday-month")));

	 Select holiday=new Select(driver.findElement(By.id("get-holiday-month")));
	 holiday.selectByValue("1");
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("get-holiday-session")));
	 Select holidaymth=new Select(driver.findElement(By.id("get-holiday-session")));
	 holidaymth.selectByValue("0");
	 
	 driver.findElement(By.id("search_input")).sendKeys("pongal event");
	 
  }
  @Test(priority=7)
  public void TaskList()
  {
	  

	  Actions act=new Actions(driver);
      WebElement ele=driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
	  act.moveToElement(ele).build().perform();

      WebElement evt = driver.findElement(By.xpath("//a[text()='Task List']"));
	  JavascriptExecutor hld= (JavascriptExecutor) driver;
	  hld.executeScript("arguments[0].click()", evt);   
	 
	  driver.findElement(By.id("list-task-date")).sendKeys("25-01-2012 to 13-08-2014");
	  
	  Select scl=new Select(driver.findElement(By.id("list-assigned-to")));
	  scl.selectByValue("32933");
	  
	  Select okornot=new Select(driver.findElement(By.id("task-status")));
	  okornot.selectByValue("2307");

	 
  }

 @Test(priority=8)
 public void levmngment()
 {
	  Actions act=new Actions(driver);
      WebElement ele=driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
	  act.moveToElement(ele).build().perform();

      WebElement evt1 = driver.findElement(By.xpath("//a[text()='Leave Management']"));
	  JavascriptExecutor hld1= (JavascriptExecutor) driver;
	  hld1.executeScript("arguments[0].click()", evt1);   
	  
	  Select ses=new Select(driver.findElement(By.id("session-id")));
	  ses.selectByValue("34");
	  
	  Select sec=new Select(driver.findElement(By.id("class-sec-id")));
	  sec.selectByValue("0");
	  
	  Select nme=new Select(driver.findElement(By.id("name-id")));
	  nme.selectByValue("24576");
	  
	  driver.findElement(By.id("list-task-date")).sendKeys("02-02-2021 to 25-05-2021");
	  
	  
	  Select sts=new Select(driver.findElement(By.id("status-filter")));
	  sts.selectByValue("2501");
	  
	  Select aprv=new Select(driver.findElement(By.id("leave_dropdown")));
	  aprv.selectByValue("Approve Leave");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Search']"))).click();
	  
	   
	  
	  
	  
	  
	  
 }











}