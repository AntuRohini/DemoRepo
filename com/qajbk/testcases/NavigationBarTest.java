package com.qajbk.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.Utility;

public class NavigationBarTest {
	

	WebDriver driver;

	@BeforeMethod
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
	public void navigationMenuTest()
	{
		List <WebElement> menuList = driver.findElements(By.xpath("(//a[@class='nav-link'])"));
		System.out.println("Number of Navigation bar menu before login is: "+menuList.size());
		System.out.println("List of Navigtion bar menu before Login: ");
		String name;
		for(int i = 0;i<menuList.size();i++)
		{
			WebElement navValue = menuList.get(i);
			name = navValue.getText();
			System.out.println(i+") "+name);
			
		}
		
		driver.findElement(By.xpath("//a[contains(@href,'Java-Certification')]")).click();
		driver.findElement(By.xpath("//div[@id='Java-Certification']//p[contains(text(),'Package')]")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//input[@id='loginmobile']")).sendKeys("9867542310");
		driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'https://www.qa.jbktest.com/dashboard')]")).click();
		
		List <WebElement> menuList2 = driver.findElements(By.xpath("(//a[@class='nav-link'])"));
		System.out.println("Number of Navigation bar menu after login is: "+menuList2.size());
		System.out.println("List of Navigtion bar menu after Login: ");
		for(int i = 0;i<menuList2.size();i++)
		{
			WebElement navValue = menuList2.get(i);
			name = navValue.getText();
			System.out.println(i+") "+name);
			
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Browser closed.");
		driver.quit();
		
	}

}
