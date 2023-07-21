package com.qajbk.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.Utility;

public class ProfileUpdateTest {
	
	
	WebDriver driver;

	@Test
	public void browerLaunchTest()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rohini/Documents/Selenium-Software/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Utility.captureScreenshot(driver, "BrowserLaunch");
		
	}
	
	@Test
	public void profileUpdateTest() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//a[contains(@href,'Testing')]")).click();
		driver.findElement(By.xpath("//p[text()='Selenium WebDriver']")).click();
		driver.findElement(By.xpath("//button[text() = 'Next']")).click();
		//driver.findElement(By.xpath("//a[@id='signin-tab']")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("7756789026");
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.partialLinkText("Account")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/profile')]")).click();
		Utility.captureScreenshot(driver, "ProfilenameBeforeupdate");
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Rohini Rohankar");
		Utility.captureScreenshot(driver, "NameupdateText");
		driver.findElement(By.id("updatebtn")).click();
		Thread.sleep(1500);
		Utility.captureScreenshot(driver, "ProfilenameAfterupdate");
		String actUpdateMsg = driver.findElement(By.xpath("//div[@id='msg']")).getText();
		String expUpdateMsg = "Profile successfully updated";
		Assert.assertEquals(actUpdateMsg, expUpdateMsg);
		System.out.println("Profile update test sucessfull.");
		Thread.sleep(1000);
		
		String actUpdatedName = "Welcome Ro Rohankar,";
		String expUpdatedName = driver.findElement(By.xpath("//span[contains(text(),'Rohankar')]")).getText();
		Assert.assertEquals(actUpdatedName, expUpdatedName,"Profile name field does updated under welcome message.");
		Thread.sleep(1000);
		Utility.captureScreenshot(driver, "ProfilenameFailedupdate");

		
		
	}

}
