package com.qajbk.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignUpTest {
	
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
	public void signUpFuctionality()
	{
		driver.findElement(By.xpath("//a[contains(@href,'#Testing')]")).click();
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/ul[1]/li[2]/a[1]")).click();
		driver.findElement(By.id("name")).sendKeys("Darsh R");
		driver.findElement(By.id("emailid")).sendKeys("dr.rohankar@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("9867542310");
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();
	}

}
