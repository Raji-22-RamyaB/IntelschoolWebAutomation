package com.xcel.qa.testcases.student;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class StudentActivityTest extends BaseTest {

	@Test(priority = 0)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("kalips");
		driver.findElement(By.id("password")).sendKeys("Omguru@5");
		driver.findElement(By.id("user-login")).click();

	}

	@Test(priority = 1)
	public void activityTest() {

		WebElement ele = driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);

		/*
		 * String actualtext =
		 * driver.findElement(By.xpath("//a[contains(text(),'Message History')]")).
		 * getText(); System.out.println(actualtext);
		 *  String expecttext ="Message History"; 
		 *  Ass? ert.assertEquals(actualtext, expecttext,
		 * "wrongtextcoming");
		 */
		WebElement ele1 = driver.findElement(By.xpath("//a[contains(text(),'Message History')]"));
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele1);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement ele2 = driver.findElement(By.partialLinkText("2"));
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele2);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement ele3 = driver.findElement(By.linkText("Last"));
		JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele3);

	}

	@Test(priority = 2)
	public void noticeHistoryTest() throws InterruptedException {

		WebElement ele = driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement ele4 = driver.findElement(By.xpath("//a[text()='Notice History']"));
		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele4);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	@Test(priority = 3)
	public void GalleryTest() throws InterruptedException {

		WebElement ele = driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement ele5 = driver.findElement(By.xpath("//a[text()='Gallery']"));
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele5);
		driver.findElement(By.id("list-image-list")).sendKeys("01-01-2022 to 10-01-2022");
		System.out.println("No record found");

	}

	@Test(priority = 4)
	public void eventHolidayTest() throws InterruptedException {

		WebElement ele = driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
		Thread.sleep(2000);
		WebElement ele6 = driver.findElement(By.xpath("//a[text()='Event & Holiday']"));
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele6);
		driver.findElement(By.id("search_input")).sendKeys("Annual day");
	}

	@Test(priority = 5)
	public void eventapplyLeaveTest() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//p[text()='ACTIVITY']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
		Thread.sleep(2000);
		WebElement ele7 = driver.findElement(By.xpath("//a[text()='Apply Leave']"));
		JavascriptExecutor jse7 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele7);

		Select leavestatus = new Select(driver.findElement(By.id("status-filter")));
		leavestatus.selectByVisibleText("APPROVED");
		leavestatus.selectByVisibleText("CANCELLED");
		leavestatus.selectByVisibleText("REJECTED");
		
		/* driver.findElement(By.xpath("//span[text()='Apply']")).click();
		 
		 driver.findElement(By.id("start-date")).sendKeys("03-06-2020");
		 driver.findElement(By.id("end-date")).sendKeys("04-06-2020");
		 driver.findElement(By.id("leave_reason")).sendKeys("go to workshop");
		 
		 driver.findElement(By.id("apply-leave-button")).click();*/
		 
	}
}
