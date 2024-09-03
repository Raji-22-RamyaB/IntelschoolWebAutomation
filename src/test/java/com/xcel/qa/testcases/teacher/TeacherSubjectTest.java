package com.xcel.qa.testcases.teacher;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherSubjectTest extends BaseTest {
	/*@Test(priority = 0)

	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}*/

	@Test(priority = 1)
	public void teacherSubjectTest() {
		WebElement ele1 = driver.findElement(By.xpath("//p[text()='SUBJECT']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele1);
		
		driver.findElement(By.xpath("//span[text()='Class Subjects']")).click();
		driver.findElement(By.xpath("//span[text()='Syllabus']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sessions-id")));
		Select date = new Select(driver.findElement(By.id("sessions-id")));
		date.selectByVisibleText("2021-2022");
		
		Select c = new Select(driver.findElement(By.id("classes-id")));
		c.selectByVisibleText("STD 4");
		
		Select subid = new Select(driver.findElement(By.id("subjects-id")));
		subid.selectByVisibleText("No subject found");
		driver.findElement(By.id("order_id")).sendKeys("1");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topics_id")));
		driver.findElement(By.id("topics_id")).sendKeys("english");
		
		driver.findElement(By.id("add-syllabus")).click();
		
	}
}
