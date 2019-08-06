package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserFactory 
{

	public static WebDriver LaunchBrowser(String Browser)
	{
		WebDriver driver=null;
		if (Browser.equalsIgnoreCase("Chrome")) 
		{
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		driver=new ChromeDriver();
		Reporter.log("Chrome Launched",true);
		} 
		else if(Browser.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.firefox.driver", "./exefiles/geckodriver.exe");
			driver=new FirefoxDriver();
			Reporter.log("Firefox Launched",true);
		}
		return driver;
		
	}
}
