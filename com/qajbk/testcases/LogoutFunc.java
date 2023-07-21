package com.qajbk.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutFunc {
	
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
	public void takeQuizLoginFunc() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//a[contains(@href,'#Testing')]")).click();
		driver.findElement(By.xpath("//div[@id='Testing']//p[contains(text(),'Maven')]")).click();
		//String optNum = driver.findElement(By.name("count")).getAttribute("value");
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//input[@id='loginmobile']")).sendKeys("9867542310");
		driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
	}
	
	@Test(dependsOnMethods = {"takeQuizLoginFunc"})
	public void logOutFuch()
	{
		driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
		String expResult = "Online Quiz to test your skills in Java,Python,MySQL,Testing";
		String actResult = driver.getTitle();
		Assert.assertEquals(expResult, actResult);
		System.out.println("Logout test sucessfull.");
		
	}
	
	// Practice Online Quiz | Take a Online Test - JavaByKiran
			//Online Quiz to test your skills in Java,Python,MySQL,Testing

}
