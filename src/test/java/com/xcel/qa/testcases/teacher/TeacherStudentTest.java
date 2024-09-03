package com.xcel.qa.testcases.teacher;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherStudentTest extends BaseTest {
	@Test(priority=0)

	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}

	@Test(priority=1)
	public void Studentllist() throws InterruptedException, AWTException
	{
		Actions act=new Actions(driver);	
		WebElement stud=driver.findElement(By.xpath("//p[text()='STUDENT']"));
		act.moveToElement(stud).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='List']"))).click();
		//driver.findElement(By.id("teac-stu-session-id")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("teac-stu-session-id"))).click();
		Thread.sleep(2000);
		Select date=new Select(driver.findElement(By.id("teac-stu-session-id")));
		//		date.selectByVisibleText("2021-2022");	  
		date.selectByValue("34");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("teac-stu-class-id"))).click();
		Select stdcls=new Select(driver.findElement(By.id("teac-stu-class-id")));
		stdcls.selectByValue("507");

		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("teac-stu-section-id"))).click();
		Select stdsec=new Select(driver.findElement(By.id("teac-stu-section-id")));
		stdsec.selectByValue("229");	  */

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name-id"))).click();

		//up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Search']"))).click();

		Thread.sleep(4000);

		driver.findElement(By.id("show_feedback")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complaints"))).sendKeys("its good to use");
		Thread.sleep(2000);

		WebElement file=driver.findElement(By.id("uploadBADocImg"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadBADocImg"))).click();
		Thread.sleep(2000);
		String filepath="C:\\Users\\XSC-10261\\Pictures\\raji\\mybdaypicxcel.png";
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

		driver.findElement(By.id("add-complaints")).click();	



	}
	@Test(priority=2)
	public void Studentattendence() throws InterruptedException
	{
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		WebElement stud=driver.findElement(By.xpath("//p[text()='STUDENT']"));

		act.moveToElement(stud).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Attendance'])[1]"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attend-session-id"))).click();
		Select ses=new Select(driver.findElement(By.id("attend-session-id")));
		ses.selectByValue("34");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attend-class-id"))).click();
		Select atcls=new Select(driver.findElement(By.id("attend-class-id")));
		atcls.selectByVisibleText("STD 2");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attend-section-id"))).click();

		Select sec=new Select(driver.findElement(By.id("attend-section-id")));
		sec.selectByVisibleText("A");  

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attendance-date"))).click();
		driver.findElement(By.id("attendance-date")).sendKeys("09-03-2020");
		// Select date=new Select(driver.findElement(By.id("attendance-date")));
		//date.selectByVisibleText("10");   
		//  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feb']"))).click();  
		//Select month=new Select(driver.findElement(By.xpath("//span[text()='Feb']")));
		//month.selectByVisibleText("Feb");
		//Select date=new Select(driver.findElement(By.xpath("//td[text()='12']")));
		//date.selectByVisibleText("12");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name-id"))).click();
		Select are=new Select(driver.findElement(By.id("name-id")));
		are.selectByValue("10704");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atn-type-id"))).click();
		Select all=new Select(driver.findElement(By.id("atn-type-id")));
		all.selectByVisibleText("Half-day Present");


	}
	@Test(priority=3)
	public void Studenthomework()
	{
		Actions act=new Actions(driver);
		WebElement stud=driver.findElement(By.xpath("//p[text()='STUDENT']"));
		act.moveToElement(stud).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Home Work')]"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("session-id"))).click();
		Select date=new Select(driver.findElement(By.id("session-id")));
		date.selectByVisibleText("2021-2022");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("class-id"))).click();
		Select clssid=new Select(driver.findElement(By.id("class-id")));
		clssid.selectByVisibleText("STD 3");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("section-id"))).click();
		Select norec=new Select(driver.findElement(By.id("section-id")));
		norec.selectByVisibleText("A");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("class-sec-sub-id"))).click();
		Select nore=new Select(driver.findElement(By.id("class-sec-sub-id")));
		nore.selectByVisibleText("Select Subject");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-date"))).click();
		driver.findElement(By.id("start-date")).sendKeys("10-03-2020");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end-date"))).click();
		driver.findElement(By.id("end-date")).sendKeys("10-05-2021");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status-id"))).click();
		Select sts=new Select(driver.findElement(By.id("status-id")));
		sts.selectByVisibleText("Completed");


	}
}

