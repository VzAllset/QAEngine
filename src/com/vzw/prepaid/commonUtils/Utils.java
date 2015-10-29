package com.vzw.prepaid.commonUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils 
{
	public static WebElement getWebElement(WebDriver driver, String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public static synchronized String getDate()
	{
		int nanoSeconds = 0;
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		nanoSeconds = ts.getNanos()/1000000;
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyHHmmss"+nanoSeconds);
		return format.format(date);
	}
	public static void closeDriver(WebDriver driver)
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
