  package com.xcel.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xcel.qa.base.BaseTest;

public class AppLoginTest extends BaseTest {

	WebElement userNameBlankLabel;
	WebElement passwordBlankLabel;
	WebElement loginButton;
	WebElement userNameInput, passwordInput;

	@BeforeClass
	public void initWebElements() {
		userNameBlankLabel = driver.findElement(By.id("username-error"));
		passwordBlankLabel = driver.findElement(By.id("password-error"));
		loginButton = driver.findElement(By.id("user-login"));
		userNameInput = driver.findElement(By.id("username"));
		passwordInput = driver.findElement(By.id("password"));
		System.out.println("Before method called");
	}

	@Test
	public void checkForPageLoaded() {
		String pageTitle = driver.getTitle();
		String expectedTitle = properties.getProperty("browserTitle");
		Assert.assertEquals(pageTitle, expectedTitle, "Wrong page loaded");
	}

	@Test(priority = 0, groups = "Login")
	public void checkLoginForEmptyCredential() {
		SoftAssert softAssert = new SoftAssert();
		loginButton.click();
		softAssert.assertTrue(userNameBlankLabel.isDisplayed(), "Username empty message not displayed");
		softAssert.assertTrue(passwordBlankLabel.isDisplayed(), "Password empty message not displayed");
		softAssert.assertAll();

	}

	@Test(priority = 1, groups = "Login")
	public void checkLoginForEmptyPassword() throws InterruptedException {
		userNameInput.sendKeys("admin");
		SoftAssert softAssert = new SoftAssert();
		loginButton.click();
		softAssert.assertEquals(userNameBlankLabel.isDisplayed(), false,
				"Username empty message displayed for input username");
		softAssert.assertEquals(passwordBlankLabel.isDisplayed(), true, "Password empty message not displayed");
		softAssert.assertAll();

	}

	@Test(priority = 2, groups = "Login")
	public void checkLoginForEmptyUserName() {
		userNameInput.clear();
		passwordInput.sendKeys("admin");
		SoftAssert softAssert = new SoftAssert();
		loginButton.click();
		softAssert.assertEquals(userNameBlankLabel.isDisplayed(), true, "Username empty message not displayed");
		softAssert.assertEquals(passwordBlankLabel.isDisplayed(), false,
				"Password empty message displayed for input password");
		softAssert.assertAll();
	}

	@Test(priority = 3, groups = "Login")
	public void checkLoginForWrongCredential() {
		SoftAssert softAssert = new SoftAssert();
		userNameInput.sendKeys("abcd");
		
		passwordInput.sendKeys("abcd");
		loginButton.click();
		softAssert.assertTrue(!userNameBlankLabel.isDisplayed() && !passwordBlankLabel.isDisplayed());

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) // Fluent Wait
				.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
				.withMessage("Login with wrong credential").ignoring(NoSuchElementException.class);
		softAssert.assertTrue(wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div"))).isDisplayed());

		softAssert.assertAll();
	}

	@Parameters({ "userType" })
	@Test(priority = 4, groups = "Login")
	public void checkLoginForCorrectCredential(String userType) {
		userNameInput.clear();
		passwordInput.clear();
		String userName = "";
		String password = "";
		System.out.println(userType);
		switch (userType) {
		case "student":
			userName = properties.getProperty("studentUserName");
			password = properties.getProperty("studentPassword");
			break;
		case "teacher":
			userName = properties.getProperty("teacherUserName");
			password = properties.getProperty("teacherPassword");
			break;
		case "staff":
			userName = properties.getProperty("staffUserName");
			password = properties.getProperty("staffPassword");
			break;
		case "salesmanager":
			userName = properties.getProperty("salesmanagerUserName");
			password = properties.getProperty("salesmanagerPassword");
			break;
		case "techadmin":
			userName = properties.getProperty("techadminUserName");
			password = properties.getProperty("techadminPassword");
			break;
		case "branchadmin":
			userName =properties.getProperty("branchadminUserName");
			password=properties.getProperty("branchadminPassword");
			break;

		}
		userNameInput.sendKeys(userName);
		passwordInput.sendKeys(password);
		loginButton.click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) // Fluent Wait
				.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
				.withMessage("Invalid Username or password").ignoring(NoSuchElementException.class);
		Assert.assertTrue(wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[@id='header_content']/div/h5/span[1]")))
				.getText().contains("Welcome"));

	}

}
