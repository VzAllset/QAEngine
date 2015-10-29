package com.vzw.prepaid.factory;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.thoughtworks.selenium.BrowserConfigurationOptions;

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
			File file = new File("IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", BrowserFactory.class.getClassLoader().getResource("IEDriverServer.exe").getPath());
			WebDriver driver = new InternetExplorerDriver();
		}
		return null;
	}
}
