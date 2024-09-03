package com.xcel.qa.testcases.branchadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xcel.qa.base.BaseTest;

public class BranchAdminMasterData extends BaseTest{
	@Test(priority = -1)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("premex");
		driver.findElement(By.id("password")).sendKeys("PremEXUseR@123");
		driver.findElement(By.id("user-login")).click();
	}
	@Test(priority=0)
	public void masterDataBranchTime() throws InterruptedException
	{
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		WebElement data=driver.findElement(By.xpath("//p[text()='MASTER DATA']"));
		act.moveToElement(data).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Branch Time']"))).click();

		driver.findElement(By.id("edit-timing")).click();
		Thread.sleep(2000);


		//WebElement ele=driver.findElement(By.id("branch-in-time"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branch-in-time"))).click();

		WebElement ele1 = driver.findElement(By.id("branch-in-time"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele1);
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='08:30 AM']"))).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(4000);
	}
	@Test(priority=1)
	public void outtime() throws InterruptedException
	{

		WebElement ele2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branch-out-time")));

		ele2.click();
		//ele2.clear();
		//Thread.sleep(2000);

		//driver.findElement(null)
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//li[contains(text(),'04:00 PM')]"))));
		WebElement lasttime= driver.findElement(By.xpath("//div[@class='ui-timepicker-wrapper'][2]//following::li[contains(text(),'04:00 PM')]"));
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click()", lasttime);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(normalize-space(),'05:15 PM')]//descendant::ul[15]"))).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(4000);


		driver.findElement(By.id("submitBranchTiming")).click();
		Thread.sleep(2000);

		//WebElement time=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'04:30 PM')]")));
		//	time.click();


		/* 
	    String searchText = "04:30 PM";
	    WebElement dropdown = driver.findElement(By.xpath("//li[contains(text(),'04:30 PM')]"));
	    dropdown.click(); // assuming you have to click the "dropdown" to open it
	    List<WebElement> options = dropdown.findElements(By.tagName("li"));
	    for (WebElement option : options)
	    {
	        if (option.getText().equals(searchText))
	        {
	            option.click(); // click the desired option
	            break;
	        }
	    }
		//List <WebElement> =(List<WebElement>) driver.findElement(By.xpath("//li[contains(text(),'04:30 PM')]"));


		driver.findElement(By.id("submitBranchTiming")).click();
		Thread.sleep(2000);
		//outtime.click();
		//driver.findElement(By.xpath("//li[text()='04:00 PM']")).click();
		//Thread.sleep(2000);

		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='04:00 PM']"))).click();
		//Thread.sleep(1000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.id("submitBranchTiming")).click();
		Thread.sleep(2000);https://youtu.be/InMVSc4AhfE?si=UOo_CS3u56by4oH8
		 */

		//ele.click();
		//ele.clear();
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("branch-in-time"))).click();
		//input[@id='branch-in-time']
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='08:30 AM']"))).click();
		//ele.sendKeys("//li[text()='08:30 AM']");

	}
	@Test(priority=2)
	public void selectClass() throws InterruptedException
	{
		Actions act1 = new Actions(driver);
		WebElement data=driver.findElement(By.xpath("//p[text()='MASTER DATA']"));
		act1.moveToElement(data).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Section'])[1]"))).click();


		//add
		driver.findElement(By.xpath("(//span[contains(text(),'Add')])[2]")).click();
		Thread.sleep(2000);

		List<WebElement> checkboxes = driver.findElements(By.className("egs-checkbox"));
		for(int i=0; i<checkboxes.size(); i++)
		{
			if(checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled())
			{
				System.out.println("Checkbox is displayed at index : " + i + " Clicking on it now");
				checkboxes.get(i).click();
			}
		}
	}


}
