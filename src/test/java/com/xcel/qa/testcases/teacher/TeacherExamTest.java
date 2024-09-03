package com.xcel.qa.testcases.teacher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class TeacherExamTest extends BaseTest {
	/*@Test(priority = 0)

	public void teacherLoginTest() {
		driver.findElement(By.id("username")).sendKeys("rajkamal");
		driver.findElement(By.id("password")).sendKeys("Guruom@5");
		driver.findElement(By.id("user-login")).click();
	}*/

	@Test(priority = 1)
	public void Examschedule() {
		Actions act = new Actions(driver);
		WebElement stud = driver.findElement(By.xpath("//p[text()='EXAM']"));
		act.moveToElement(stud).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Exam Schedule']"))).click();

	}

	@Test(priority = 2)
	public void Examsyllabus() {
		Actions act = new Actions(driver);
		WebElement stud = driver.findElement(By.xpath("//p[text()='EXAM']"));
		act.moveToElement(stud).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Exam Syllabus']"))).click();

	}

	@Test(priority = 3)
	public void ExamMarks() {
		Actions act = new Actions(driver);
		WebElement stud = driver.findElement(By.xpath("//p[text()='EXAM']"));
		act.moveToElement(stud).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Exam Mark']"))).click();

	}

}
