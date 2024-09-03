package com.xcel.qa.testcases.teacher;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherTimetable extends BaseTest {
	/*@Test(priority = 0)

	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}*/

	@Test(priority=1)
	public void timetable()
	{
	driver.findElement(By.xpath("//p[text()='TIMETABLE']")).click();	
	}
    
	@Test(priority=2)
	public void Selectdate()
	{
	Select index=new Select(driver.findElement(By.xpath("//select[@id='session-id']")));
	index.selectByIndex(1);
	}
	
	@Test(priority=3)
	public void add()
	{
		driver.findElement(By.xpath("//span[text()='Add']")).click();
		Select date=new Select(driver.findElement(By.id("session-id")));
		date.selectByIndex(2);
		Select opt=new Select(driver.findElement(By.id("class-id")));
		opt.selectByIndex(0);
		
	}
	@Test(priority=4)
	public void edit()
	{
    driver.findElement(By.id("show_feedback")).click();		
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complaints"))).sendKeys("its good to use");
	}
	/*@Test(priority=5)
	public void fileuploaded() throws InterruptedException, AWTException
	{
	WebElement file=driver.findElement(By.id("uploadBADocImg"));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadBADocImg"))).click();
    Thread.sleep(2000);
    String filepath="C:\\\\XCEL\\\\nethra\\\\bbb.jpg";
    StringSelection selection=new StringSelection(filepath);
    
	//keyboard actions to select file
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-complaints"))).click();

	 
	}*/
	
	@Test(priority=6)
	public void submit()
	{
	driver.findElement(By.id("add-complaints")).click();	
	}
	
	
	
	
	
	
}
