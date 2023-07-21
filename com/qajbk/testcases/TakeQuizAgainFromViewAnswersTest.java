package com.qajbk.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeQuizAgainFromViewAnswersTest {
	
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
	
	@Test
	public void takeQuizAgainFunc() throws InterruptedException
	{
		//String optNum;
		//driver.findElement(By.xpath("//a[normalize-space()='Test']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'Python')]")).click();
		driver.findElement(By.xpath("//div[@id='Python']//p[contains(text(),'String')]")).click();
		Thread.sleep(1500);
		
        List <WebElement> radio = driver.findElements(By.xpath("//input[@name='count' and @type='radio']"));
		
		for(int i=0;i<radio.size();i++)
		{
			WebElement button = radio.get(i);
			String value = button.getAttribute("value");
			System.out.println("Value of radio buttons: "+value);
			
			if(value.equalsIgnoreCase("20"))
			{
				button.click();
				driver.findElement(By.id("countbtn")).click();
				driver.findElement(By.xpath("//input[@id='loginmobile']")).sendKeys("9867542310");
				driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
				int num = Integer.parseInt(value);
				
				for(int j=1;j<=num-1;j++)
				{
					WebElement next = driver.findElement(By.cssSelector(".btn.quiz-btn.qnext"));
				    JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(true);", next);
					Thread.sleep(2000);
					next.click();
					
				}
				Thread.sleep(1000);
				driver.findElement(By.id("qsubmit")).click();
				driver.findElement(By.xpath("//div[@class='btn btn-outline-primary shadow text-center view-answer']")).click();
				WebElement quiz_again = driver.findElement(By.xpath("//div[@class='btn btn-outline-primary shadow take-again p-2']"));
				JavascriptExecutor jsc = (JavascriptExecutor)driver;
				jsc.executeScript("arguments[0].scrollIntoView(true);", quiz_again);
				quiz_again.click();
				
				for(int j=1;j<=num-1;j++)
				{
					WebElement next = driver.findElement(By.cssSelector(".btn.quiz-btn.qnext"));
				    JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(true);", next);
					Thread.sleep(2500);
					next.click();
					
				}
				Thread.sleep(1000);
				driver.findElement(By.id("qsubmit")).click();
			}
		
			
			
		}
		System.out.println("Take a Quiz Again and submit test is successfull.");
	}

}
