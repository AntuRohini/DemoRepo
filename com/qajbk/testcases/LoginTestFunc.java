package com.qajbk.testcases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestFunc {
	
	WebDriver driver;

	@BeforeMethod
	public void browerLaunchTest()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rohini/Documents/Selenium-Software/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("JBK QA application launch sucessfully.");
		
	}
	
	@Test(description = "Application login with valid phone number")
	public void takeQuizValidLoginFunc() throws Exception
	{
		
		driver.findElement(By.xpath("//a[contains(@href,'#Testing')]")).click();
		driver.findElement(By.xpath("//div[@id='Testing']//p[contains(text(),'Maven')]")).click();
		String optNum = driver.findElement(By.name("count")).getAttribute("value");
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//input[@id='loginmobile']")).sendKeys("9867542310");
		driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		Thread.sleep(1000);
		String actResult = driver.findElement(By.xpath("//a[contains(@href,'/dashboard')]")).getText();
		String expResult = " My Account";
		Assert.assertEquals(expResult, actResult);
		System.out.println("Login test sucessfull.");
		
		
//		Thread.sleep(2000); My Account
//		driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
		
// Practice Online Quiz | Take a Online Test - JavaByKiran
		//Online Quiz to test your skills in Java,Python,MySQL,Testing

//		WebElement element =  driver.findElement(By.xpath("//a[contains(@href,'#MySQL')]"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", element);
//		driver.findElement(By.xpath("//p[text() ='SQL Beginner Level']")).click();
//		driver.findElement(By.xpath("//input[@value='20']")).click();
//		driver.findElement(By.id("countbtn")).click();
//		driver.findElement(By.xpath("//input[@id='loginmobile']")).sendKeys("9867542310");
//		driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		
	}
	
	@Test(description = "Application login with blank phone functionality")
	public void takeQuizInvalidLoginFunc() throws Exception
	{
		
		driver.findElement(By.xpath("//a[contains(@href,'#Testing')]")).click();
		driver.findElement(By.xpath("//div[@id='Testing']//p[contains(text(),'Maven')]")).click();
		String optNum = driver.findElement(By.name("count")).getAttribute("value");
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//input[@id='loginmobile']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		Thread.sleep(1000);
		String actResult = driver.findElement(By.xpath("//div[@id='loginerr']")).getText();
		String expResult = "Please enter valid mobile number, If you have not registered, please click signup tab to get registered.";
		Assert.assertEquals(expResult, actResult);
		System.out.println("Login failed message seen for Login with blank phone - test sucessfull.");
	}
	
	@Test(description = "Application login with invalid phone functionality")
	public void takeQuizInvalidLoginFunc1() throws Exception
	{
		
		driver.findElement(By.xpath("//a[contains(@href,'#Testing')]")).click();
		driver.findElement(By.xpath("//div[@id='Testing']//p[contains(text(),'Maven')]")).click();
		String optNum = driver.findElement(By.name("count")).getAttribute("value");
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//input[@id='loginmobile']")).sendKeys("1234*67890");
		driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		Thread.sleep(1000);
		String actResult = driver.findElement(By.xpath("//div[@id='loginerr']")).getText();
		String expResult = "Please enter valid mobile number, If you have not registered, please click signup tab to get registered.";
		Assert.assertEquals(expResult, actResult);
		System.out.println("Login failed message seen for Login with blank phone - test sucessfull.");
	}
	
	@AfterMethod(enabled=false)
	public void tearDown()
	{
		driver.quit();
	}
	
	

//	@Test(dependsOnMethods = {"loginTest"})
//	public void signUp()
//	{
//		driver.findElement(By.xpath("//a[contains(@href,'#MySQL')]")).click();
//		driver.findElement(By.xpath("//p[text() ='SQL Beginner Level']")).click();
//		driver.findElement(By.xpath("//button[@id='countbtn']")).click();
//		driver.findElement(By.xpath("//a[@id='signup-tab']")).click();
//		driver.findElement(By.id("name")).sendKeys("Darsh R");
//		driver.findElement(By.id("emailid")).sendKeys("dr1.rohankar@gmail.com");
//		driver.findElement(By.id("mobile")).sendKeys("9867542311");
//		driver.findElement(By.id("agree")).click();
//		driver.findElement(By.id("emailbtn")).click();
//	}
	
}
