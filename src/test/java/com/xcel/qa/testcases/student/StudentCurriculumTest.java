package com.xcel.qa.testcases.student;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class StudentCurriculumTest extends BaseTest {
	
	@Test(priority = 0)
	public void CurriculumHomeWorkTest() {
		driver.navigate().back();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("/html/body/section/div[2]/ul/li[2]/div/a")));
		actions.perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/ul/li[2]/div/ul/li[1]/a"))).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/section/div[3]/div/div/div/div[1]/div[1]/div[1]/p")).getText(), "Home Work");
		
	}
	
	@Test(priority = 1)
	public void CurriculumTimeTableTest() {
		driver.navigate().back();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("/html/body/section/div[2]/ul/li[2]/div/a")));
		actions.perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/ul/li[2]/div/ul/li[2]/a"))).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/section/div[3]/div/div[1]/div/div/div[1]/div[1]/p")).getText(), "Time Table");

	}
	
	@Test(priority = 2)
	public void CurriculumSyllabusTest() {
		driver.navigate().back();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("/html/body/section/div[2]/ul/li[2]/div/a")));
		actions.perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/ul/li[2]/div/ul/li[3]/a"))).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div/div/div[1]/div/div[1]/h4")).getText(), "Syllabus");
		driver.navigate().back();
	}

}
