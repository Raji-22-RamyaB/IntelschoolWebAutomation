package com.xcel.qa.testcases.branchadmin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xcel.qa.base.BaseTest;

public class BranchAdminStudent extends BaseTest{

	WebElement sdateerr;
	WebElement edateerr;
	WebElement sdate;
	WebElement edate;
	WebElement submit;

	@Test(priority = -1)
	public void loginTest() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("premex");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("PremEXUseR@123");
		Thread.sleep(2000);;
		driver.findElement(By.id("user-login")).click();
		Thread.sleep(2000);
	}
	@Test(priority=0, enabled=false)
	public void stud()
	{
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//p[text()='STUDENT']"));
		act.moveToElement(ele).build().perform();

	}
	@Test(priority=1, groups="Regform", enabled=false)
	public void admission()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Admission']"))).click();
	}

	@Test(priority=2, groups="Regform", enabled=false)
	public void registerStudeDetails() throws InterruptedException, AWTException
	{

		driver.findElement(By.id("first_Name")).sendKeys("Ramya");
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Timeout.ofSeconds(20));
		driver.findElement(By.id("last_Name")).sendKeys("Raji");

		//dob

		WebElement startdate = driver.findElement(By.id("stud_dob"));
		startdate.click();
		String date="22";
		String month="November 2019";
		//String year ="2019";

		while(true) {
			String monthyear = driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]")).getText();
			//String ar[] = monthyear.split("");
			//String mon=ar[0];
			//String yr=ar[0];
			if (monthyear.equalsIgnoreCase(month)) 
				break;
			else
				driver.findElement(By.xpath("(//th[@class='prev'])[1]")).click();

		}

		List<WebElement> alldate = driver.findElements(By.xpath("//table/tbody/tr[4]/td[6]"));
		for (WebElement day : alldate) {
			String text = day.getText();
			if (text.equals(date)) {
				day.click();
			}
		}

		driver.findElement(By.id("role_numb")).sendKeys("INT5001");
		Thread.sleep(2000);

		driver.findElement(By.id("admission_no")).sendKeys("INTSL20001");
		Thread.sleep(2000);

		//admission date


		WebElement startdate1 = driver.findElement(By.id("admission_date"));
		startdate1.click();
		String date1="4";
		String month1="November 2020";
		//String year ="2019";

		while(true) {
			String monthyear1 = driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]")).getText();
			//String ar[] = monthyear.split("");
			//String mon=ar[0];
			//String yr=ar[0];
			if (monthyear1.equalsIgnoreCase(month1)) 
				break;
			else
				driver.findElement(By.xpath("(//th[@class='prev'])[1]")).click();

		}

		List<WebElement> alldate1 = driver.findElements(By.xpath("//table/tbody/tr[2]/td[4]"));
		for (WebElement day1 : alldate1) {
			String text = day1.getText();
			if (text.equals(date1)) {
				day1.click();
			}
		}

		driver.findElement(By.id("className")).click();
		Thread.sleep(2000);
		Select section=new Select(driver.findElement(By.id("className")));
		section.selectByValue("528");
		Thread.sleep(2000);

		driver.findElement(By.id("sectionName")).click();
		Thread.sleep(2000);
		Select sec=new Select(driver.findElement(By.id("sectionName")));
		sec.selectByIndex(1);
		Thread.sleep(2000);

		WebElement radiobtn = driver.findElement(By.xpath("(//label[text()='Female'])[2]"));
		if(radiobtn.isSelected())
		{
			System.out.println("isselected");
		}
		else
		{
			radiobtn.click();
			System.out.println("Selected Female option now");
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("StudReligion"))).click();
		Thread.sleep(2000);

		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(50,document.body.scrollHeight)");
		Thread.sleep(4000);
		 */


		WebElement religion=driver.findElement(By.id("StudReligion"));
		Select rel=new Select(driver.findElement(By.id("StudReligion")));
		rel.selectByVisibleText("Hinduism");
		boolean  status=religion.isDisplayed();
		Thread.sleep(2000);


		WebElement e1 = driver.findElement(By.id("nationalityStud"));
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript ("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", e1);

		WebElement nationality=driver.findElement(By.id("nationalityStud"));
		nationality.click();
		nationality.sendKeys("Indian");
		WebElement adhar=driver.findElement(By.id("aadhar"));
		adhar.click();
		adhar.sendKeys("852014563215");
		WebElement father=driver.findElement(By.id("father_name"));
		father.click();
		father.sendKeys("Balasubramani");
		WebElement mother=driver.findElement(By.id("mother_name"));
		mother.click();
		mother.sendKeys("Kalavathy");
		WebElement sisters=driver.findElement(By.id("no_of_sisters"));
		sisters.click();
		sisters.sendKeys("1");
		WebElement brothers=driver.findElement(By.id("no_of_brothers"));
		brothers.click();
		brothers.sendKeys("1");

		//scrollintoview
		WebElement e = driver.findElement(By.id("upload-stImg"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript ("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", e);

		//upload file
		driver.findElement(By.id("upload-stImg")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("upload-stImg"))).click();
		Thread.sleep(3000);

		String filepath="C:\\Users\\XSC-10261\\Pictures\\profilepic.png";
		//String filepath="Pictures\\profilepic.png";
		StringSelection selection=new StringSelection(filepath);
		Thread.sleep(2000);

		//keyboard actions to select file using robot
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot rb = new Robot();

		/*robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);*/

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}
	@Test(priority=3, groups="Regform", enabled=false)
	public void communicationDetails() throws InterruptedException, AWTException
	{

		//scroll
		WebElement details=driver.findElement((By.id("studAddress1")));
		JavascriptExecutor addr=(JavascriptExecutor)driver;
		addr.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", details);
		//address
		WebElement add=driver.findElement(By.id("studAddress1"));
		add.click();
		add.sendKeys("2nd Main road, Rajaji street,tiruvallur");
		//city
		WebElement city=driver.findElement(By.id("stud_reg_City"));
		city.click();
		city.sendKeys("Tiruvallur");
		//select state
		Select state =new Select(driver.findElement(By.id("stud_reg_state")));
		state.selectByValue("1531");
		Thread.sleep(2000);
		//pin
		WebElement pin=driver.findElement(By.id("stud_reg_zip"));
		pin.click();
		pin.sendKeys("602023");
		//mob
		driver.findElement(By.id("stud_reg_mob")).sendKeys("9089940879");	
		//email
		WebElement email=driver.findElement(By.id("stud_reg_Email"));
		email.click();
		email.sendKeys("rajixcel@gmail.com");


	}

	@Test(priority=4, groups="Regform", enabled=false)
	public void document() throws AWTException, InterruptedException
	{ 
		//select
		Select doc=new Select(driver.findElement(By.id("stud_doc_type")));
		doc.selectByIndex(1);
		//doc des
		WebElement desc=driver.findElement(By.id("doc_Desc"));
		desc.click();
		desc.sendKeys("Here, I've attached my Aadhar");

		//upload file
		//driver.findElement(By.id("upload-doc")).click();
		driver.findElement(By.xpath("//textarea[@id='doc_Desc']/following::img[@id='upload-doc']")).click();
		Thread.sleep(2000);

		//pathlocation
		String path="C:\\Users\\XSC-10261\\Pictures\\Saved Pictures\\aadhar.png";
		StringSelection pathloc=new StringSelection(path);
		Thread.sleep(2000);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pathloc, null);
		Robot robot = new Robot();



		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		//submit

		/*WebElement sub=driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[2]"));
		JavascriptExecutor button=(JavascriptExecutor)driver;

		button.executeScript("aruguments[0],scrollIntoView{(block: 'center', inline:'nearest')}", sub);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[2]")).click();
		Thread.sleep(2000);
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[2]")).click();
		Thread.sleep(2000);

	}



	@Test(priority=5, groups="studIndo", enabled=false)
	public void verifyStudInfo() throws InterruptedException 
	{
		//verify title
		String actualTitle=driver.findElement(By.xpath("(//h4[contains(text(),'Student Info')])[2]")).getText();
		Thread.sleep(2000);
		System.out.println(actualTitle);
		String expectedTitle = "Student Info";
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong page");
		String title = actualTitle;
		if (title.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Not a match");
		}
		Thread.sleep(2000);
		//scroll down
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(4000);

		//scroll page up
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(4000);

	}

	@Test(priority=6, groups="list", enabled=true)
	public void list() throws InterruptedException
	{
		Thread.sleep(2000);
		Actions act1=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//p[text()='STUDENT']"));
		act1.moveToElement(ele).build().perform();
		Thread.sleep(2000);		

		WebElement ele2 = driver.findElement(By.xpath("//p[text()='STUDENT']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele2);

		driver.findElement(By.id("stu-list-sidebar")).click();
		Thread.sleep(2000);


	}

	@Test(priority=7, groups="list", enabled=true)
	public void search() throws InterruptedException
	{
		driver.findElement(By.id("class-id")).click();
		Thread.sleep(2000);
		Select section=new Select(driver.findElement(By.id("class-id")));
		section.selectByValue("528");
		Thread.sleep(2000);
		//click the search person name
		driver.findElement(By.xpath("//p[text()='Ramya Raji']")).click();
		Thread.sleep(2000);





		/*	//scroll page up
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(2000);

		//scroll bottom
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);


		//scroll page to a webelement
		JavascriptExecutor js1e = (JavascriptExecutor) driver;
        //eg: 
        WebElement element = driver.findElement(By.linkText("Google.com.ph"));
		js1e.executeScript("arguments[0].scrollIntoView();", element);
		 */


	}

	@Test(priority=8, enabled=true)
	public void checkDocument() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='Document']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'VIEW')]")).click();
		Thread.sleep(3000);

		//handling window0
		/*Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles); 
		driver.switchTo().window(windowHandlesList.get(0));*/

		Set<String> handle = driver.getWindowHandles();
		List<String> childtab=new ArrayList<>(handle);
		driver.switchTo().window(childtab.get(0));

		//edit
		driver.findElement(By.id("update-doc")).click();
		Thread.sleep(2000);

		WebElement desc=driver.findElement(By.id("up_desc"));
		desc.click();
		desc.clear();
		Thread.sleep(1000);
		desc.sendKeys("Here I've attached the proof");

		driver.findElement(By.id("ba-up-doc-sub")).click();
		Thread.sleep(2000);

	}

	@Test(priority=9, enabled=true)
	public void fee() throws InterruptedException
	{
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//p[text()='STUDENT']"));
		act.moveToElement(ele).build().perform();


		driver.findElement(By.id("egs-fees")).click();
		Thread.sleep(2000);

		List<WebElement> checkboxes = driver.findElements(By.className("egs-radiobutton"));

		//way 1
		/*	for(WebElement checkbox:checkboxes)
		{
			if(!checkbox.isSelected())
			{
			checkbox.click();
			Thread.sleep(2000);
			}
		}

		for(WebElement checkbox:checkboxes)
		{
		  assert checkbox.isSelected();
		  Thread.sleep(2000);
		}

		 */
		//way 2

		for(int i=0; i<checkboxes.size(); i++)
		{
			if(checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled())
			{
				System.out.println("Checkbox is displayed at index : " + i + " Clicking on it now");
				checkboxes.get(i).click();
			}
		}

		//way3

		/*for(int i=0; i<checkboxes.size(); i++)        
		{   
			String value = checkboxes.get(i).getAttribute("value");

			if (value.equalsIgnoreCase("6088 && 6086"))

			{       
				//perform action on checkbox which have value as orange
				break;
			}
		}*/
	}

	@Test(priority=10, enabled=true, groups="bus")
	public void attendance() throws InterruptedException
	{
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//p[text()='STUDENT']"));
		act.moveToElement(ele).build().perform();


		WebElement bus=driver.findElement(By.id("egs-bus"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", bus);


		Thread.sleep(2000);

		WebElement addbutton=driver.findElement(By.xpath("(//a[@class='egs-add-details add-student-bus-btn'])[1]"));
		WebElement add= driver.findElement(By.xpath("(//span[@style='background: url(https://portal.intelschool.in:443/images/white-icons/edit.png);'])[5]"));
		if(addbutton.isDisplayed())
		{
			addbutton.click();
			Thread.sleep(2000);
			System.out.println("now only added");

			//select option
			driver.findElement(By.id("student-bus-route")).click();
			Select addbus= new Select(driver.findElement(By.id("student-bus-route")));
			addbus.selectByIndex(2);
			Thread.sleep(2000);
			driver.findElement(By.id("student-bus-submit-btn")).click();
			Thread.sleep(2000);


		}


		else
		{
			add.click();
			Thread.sleep(2000);
			System.out.println("additionally added");
			driver.findElement(By.id("student-bus-route")).click();
			Thread.sleep(2000);
			Select addbus= new Select(driver.findElement(By.id("student-bus-route")));
			addbus.selectByIndex(3);
			Thread.sleep(2000);
			driver.findElement(By.id("student-bus-submit-btn")).click();
			Thread.sleep(2000);
		}

		driver.findElement(By.id("add-student-bus-fee-btn")).click();
		Thread.sleep(2000);
	}

	@Test(priority=11, enabled=true, groups="bus")
	public void payinitwebElements() throws InterruptedException
	{


		//sdate=driver.findElement(By.id("bus-fees-sDate"));
		//edate=driver.findElement(By.id("bus-fees-eDate"));
		//submit=driver.findElement(By.xpath("(//button[text()='Submit'])[12]"));
		//edateerr=driver.findElement(By.id("bus-fees-eDate-error"));

		SoftAssert softAssert=new SoftAssert();
		submit=driver.findElement(By.xpath("(//button[text()='Submit'])[12]"));
		submit.click();
		Thread.sleep(2000);
		sdateerr=driver.findElement(By.id("bus-fees-sDate-error"));

		softAssert.assertTrue(sdateerr.isDisplayed(), "Startdate Empty message not displayed");
		//softAssert.assertTrue(edateerr.isDisplayed(), "End date empty message not displayed");
		softAssert.assertAll();

		sdate=driver.findElement(By.id("bus-fees-sDate"));
		sdate.click();
		sdate.sendKeys("01-09-2024");
		submit=driver.findElement(By.xpath("(//button[text()='Submit'])[12]"));
		submit.click();
		Thread.sleep(2000);
		edateerr=driver.findElement(By.id("bus-fees-eDate-error"));
		softAssert.assertTrue(edateerr.isDisplayed(), "End date empty message not displayed");
		softAssert.assertAll();

		edate=driver.findElement(By.id("bus-fees-eDate"));
		edate.click();
		edate.sendKeys("05-09-2024");
		submit=driver.findElement(By.xpath("(//button[text()='Submit'])[12]"));
		submit.click();
	}
	@Test(priority=12, enabled=true)
	public void loading() throws InterruptedException
	{
		SoftAssert softAssert=new SoftAssert();
		try {
			// Locate the submit button
			WebElement submitButton = driver.findElement(By.xpath("(//button[text()='Submit'])[12]"));
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Submit'])[12]")));

			// Click the submit button
			submitButton.click();

			// Check for loading indicator
			WebElement loadingIndicator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='loading...']")));
			softAssert.assertTrue(loadingIndicator.isDisplayed(),
					"Loading indicator should be displayed after clicking the submit button");

			// Wait for a reasonable amount of time to see if the loading completes
			try 
			{
				Thread.sleep(2000); // Adjust time as needed
			}
			catch (InterruptedException e) 
			{
				softAssert.fail("Thread was interrupted during sleep.");
			}

			// Check if the loading indicator is still visible after waiting
			softAssert.assertTrue(loadingIndicator.isDisplayed(),
					"Loading indicator should be hidden after some time, but it is still displayed");

			// Optionally, check for other actions or states if applicable
			WebElement resultMessage = driver.findElement(By.id("resultMessage"));
			softAssert.assertTrue(resultMessage.isDisplayed(),"Result message should be displayed, but it is not.");

		} 
		catch (Exception e) 
		{
			// Handle exceptions
			softAssert.fail("Test failed due to an exception: " + e.getMessage());
			driver.findElement(By.xpath("//button[@class='close'])[14]")).click();
			Thread.sleep(4000);	
		} 
		finally 
		{
			// Assert all soft assertions
			softAssert.assertAll();
		}
			
	}
	@Test(priority=13, enabled=true)
	public void homework() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Home Work']")).click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//p[text()='STUDENT']"));
		act.moveToElement(ele).build().perform();

	}
	@Test(priority=14, enabled=true)
	public void assignbus() throws InterruptedException
	{ 
		driver.findElement(By.xpath("//a[text()='Assign Bus']")).click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//p[text()='STUDENT']"));
		act.moveToElement(ele).build().perform();

	}
	@Test(priority=15, enabled=true)
	public void alumni() throws InterruptedException
	{ 
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//p[text()='STUDENT']"));
		act.moveToElement(ele).build().perform();

		driver.findElement(By.xpath("//a[text()='Alumni']")).click();
		Thread.sleep(2000);



	}


}








