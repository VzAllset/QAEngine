package com.vzw.prepaid.factory;

import java.io.File;

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
			File file = new File("To filll");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			WebDriver driver = new InternetExplorerDriver();
		}
		return null;
	}
}
