package com.qajbk.testcases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TakeQuizViewAnsTest {
	
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
		String optNum = driver.findElement(By.name("count")).getAttribute("value");
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//input[@id='loginmobile']")).sendKeys("9867542310");
		driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		//driver.findElement(By.xpath("//*[@id=\"choices\"]/div[1]/label/div")).click();
		
		int num = Integer.parseInt(optNum);
		
		for(int i=1;i<=num-1;i++)
		{
			WebElement next = driver.findElement(By.cssSelector(".btn.quiz-btn.qnext"));
		    JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", next);
			Thread.sleep(2000);
			next.click();
			
		}
		driver.findElement(By.id("qsubmit")).click();
		driver.findElement(By.xpath("//div[@class='btn btn-outline-primary shadow text-center view-answer']")).click();
		
		String expResult = " My Account";
		String actResult = driver.findElement(By.xpath("//a[contains(@href,'/dashboard')]")).getText();
		Assert.assertEquals(expResult, actResult);
		System.out.println("View quiz answer test sucessfull.");
		
//		Thread.sleep(2000);
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
