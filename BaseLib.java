package com.actitime.generic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib 
{
public static WebDriver driver;

@BeforeMethod
@Parameters ({"Browser","BaseURL"})
public void precondition(String Browser,String BaseURL)
{
	driver=BrowserFactory.LaunchBrowser(Browser);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(BaseURL);
}

@AfterMethod
public void postCondition()
{
  driver.close();	
}
}
