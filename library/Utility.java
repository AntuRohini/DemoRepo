package library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void captureScreenshot(WebDriver driver,String screenshotName)
	{
		
		try 
		{
			TakesScreenshot ts = ((TakesScreenshot)driver);
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshots/"+screenshotName+".jpg"));
			System.out.println("Screenshot captured.");
		} catch (Exception e) 
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
			
		} 
		
	}
}
