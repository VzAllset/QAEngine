package com.vzw.prepaid.factory;

import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.beans.Data;

public class TestFactory {
	public static TestExecutor getTestProcessor(String action,Object object,Data data,WebDriver driver)
	{
		if(action != null)
		{
			if(action.equalsIgnoreCase("DATA_COMPARE"))
			{
				return new CompareDataProcessor(object,data,driver);
			}
		}
		return null;
	}
}
