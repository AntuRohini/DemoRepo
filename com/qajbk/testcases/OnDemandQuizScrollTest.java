package com.qajbk.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OnDemandQuizScrollTest {
	
	WebDriver driver;

	@Test
	public void browerLaunchTest()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rohini/Documents/Selenium-Software/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	
	@Test(dependsOnMethods = {"browerLaunchTest"})
	public void onDemandPgTest() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(@class,'nav-link border-bottom p-3 text-dark')]")).click();
		driver.findElement(By.xpath("//div[@id='On-Demand-Test']//div[49]//a[1]//div[1]")).click();
		Actions action = new Actions(driver);
		WebElement closeButton = driver.findElement(By.xpath("//button[normalize-space()='×']"));
		Thread.sleep(2000);
		action.click(closeButton).build().perform();
		WebElement e1 = driver.findElement(By.xpath("//a[contains(@href,'#Placement-Policy')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//WebElement placementTest = (WebElement) js.executeScript("document.querySelector(\".nav-link.border-bottom.p-3.text-dark.active\")");
	   // String button = "arguments[0]."
		
		js.executeScript("window.scrollBy(0,-2000);", e1);
		e1.click();
		//action.click(e1).build().perform();
		driver.findElement(By.xpath("//p[normalize-space()='Placement Quiz']")).click();
		System.out.println("Test sucessful");
		driver.quit();
	}

}
