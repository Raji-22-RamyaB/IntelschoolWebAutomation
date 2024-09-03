package com.xcel.qa.testcases.student;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class StudentAttendance extends BaseTest {
	
	@Test(priority = 0)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("kalips");
		driver.findElement(By.id("password")).sendKeys("Omguru@5");
		driver.findElement(By.id("user-login")).click();

	}

	@Test(priority = 1)
	public void studentAttendanceTest() {

		driver.findElement(By.xpath("//p[text()='ATTENDANCE']")).click();

		Select date = new Select(driver.findElement(By.id("get-attend-month")));
		date.selectByVisibleText("January - 2020");
		Select year = new Select(driver.findElement(By.id("get-attend-session")));
		year.selectByValue("130");

		// driver.findElement(By.id("add-complaints")).click();

	}

	/*@Test(priority= 2)
	public void feedBackTest() throws InterruptedException, AWTException {

		// driver.findElement(By.xpath("//*[@id=\"show_feedback\"]/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='show_feedback']/span"))).click();
		// driver.findElement(By.id("complaints")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complaints"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complaints"))).sendKeys("good");
		// driver.findElement(By.id("complaints")).sendKeys("good");
		WebElement file = driver.findElement(By.id("uploadBADocImg"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadBADocImg")));
		file.click();
		Thread.sleep(5000);
		String filepath = "";
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-complaints"))).click();
		driver.close();
	}*/
}
