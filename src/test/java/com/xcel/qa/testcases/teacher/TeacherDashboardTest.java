package com.xcel.qa.testcases.teacher;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherDashboardTest extends BaseTest {
	/*@Test(priority = 0)

	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}*/

	@Test(priority = 0)
	public void teacherdashboard() throws InterruptedException {
		                                                       
		WebElement ele1 = driver.findElement(By.xpath("//p[text()='DASHBOARD']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele1);
		
		WebElement ele2 = driver.findElement(By.xpath("//small[contains(text(),'Leaves to be Approved')]"));
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele2);
		
		driver.findElement(By.id("list-task-date")).sendKeys("24-08-2020 to24-08-2020");
		Select leavestatus = new Select(driver.findElement(By.id("class-sec-id")));
		leavestatus.selectByVisibleText("STD 1 - F");
		
		Select leavestatus1 = new Select(driver.findElement(By.id("status-filter")));
		leavestatus1.selectByVisibleText("WAITING FOR APPROVAL");
		leavestatus1.selectByVisibleText("APPROVED");
		leavestatus1.selectByVisibleText("REJECTED");
		Select leavestatus2 = new Select(driver.findElement(By.id("leave_dropdown")));
		leavestatus2.selectByVisibleText("Approve Leave");
		leavestatus2.selectByVisibleText("My Leave");
		driver.findElement(By.xpath("//span[text()='Apply']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-date"))).click();
		Thread.sleep(2000);
		WebElement ele3 = driver.findElement(By.xpath("//th[text()='January 2022']/preceding::th[1]"));
		JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele3);
		WebElement ele4 = driver.findElement(By.xpath("//th[text()='We']/following::td[10]"));
		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele4);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end-date"))).click();
		WebElement ele5 = driver.findElement(By.xpath("//th[text()='Tu']/following::td[10]"));
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele5);
		Thread.sleep(2000);
		driver.findElement(By.id("leave_reason")).sendKeys("go to paper valuation");
		driver.findElement(By.id("apply-leave-button")).click();
		driver.findElement(By.id("close-modal")).click();
	}
		/*@Test(priority=1)
		public void student() throws InterruptedException {
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("\"//i[@id='emp-not-marked-icon']/following::div[3]\""))).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("//i[@id='emp-not-marked-icon']/following::div[3]"))).click();
		act.build().perform();
		WebElement ele = driver.findElement(By.id("//i[@id='emp-not-marked-icon']/following::div[3]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
		Thread.sleep(2000);
		driver.findElement(By.id("nm-attendance-date")).sendKeys("30-01-2022");
		Select leavestatus3 = new Select(driver.findElement(By.id("nm-class-id")));
		leavestatus3.selectByVisibleText("STD 1");
		leavestatus3.selectByVisibleText("STD 2");
		leavestatus3.selectByVisibleText("STD 4");
		driver.findElement(By.id("check_0")).isEnabled();
		
	}*/

}
