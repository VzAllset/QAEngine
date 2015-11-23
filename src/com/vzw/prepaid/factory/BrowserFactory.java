package com.vzw.prepaid.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
	public static WebDriver getWebDriver(String browserType)
	{
		if(browserType.equalsIgnoreCase("Firefox"))
		{
			return new FirefoxDriver();
		}
		else if(browserType.equalsIgnoreCase("IE"))
		{
			return new InternetExplorerDriver();
		}
		return null;
	}
}
