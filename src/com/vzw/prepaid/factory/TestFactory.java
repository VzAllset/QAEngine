package com.vzw.prepaid.factory;

import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.dao.generated.QaData;
import com.vzw.prepaid.dao.generated.QaObject;
import com.vzw.prepaid.processor.WaitTillHiddenProcessor;
import com.vzw.prepaid.testflow.CompareDataProcessor;
import com.vzw.prepaid.testflow.TestExecutor;

public class TestFactory {
	public static TestExecutor getTestProcessor(String action,QaObject object,QaData data,WebDriver driver)
	{
		if(action != null)
		{
			if(action.equalsIgnoreCase("DATA_COMPARE"))
			{
				return new CompareDataProcessor(object,data,driver);
			}
			if(action.equalsIgnoreCase("WAIT_TILL_HIDDEN"))
			{
				return new WaitTillHiddenProcessor(object,driver);
			}
		}
		return null;
	}
}
