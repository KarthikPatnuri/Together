package com.reuseability;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parentclass
{
	
	public static WebDriver Application(WebDriver driver,String browserName,String URL)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			System.out.println("Firefox");
		}
		else if(browserName.equals("IE"))
		{
			System.out.println("IE");
		}
		else
		{
			System.out.println("No browser");
		}
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
		
	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
