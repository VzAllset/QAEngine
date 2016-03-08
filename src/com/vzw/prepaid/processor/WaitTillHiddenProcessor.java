package com.vzw.prepaid.processor;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;
import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.dao.generated.QaObject;
import com.vzw.prepaid.testflow.TestExecutor;

public class WaitTillHiddenProcessor implements TestExecutor
{
	static Logger logger = Logger.getLogger(WaitTillHiddenProcessor.class);

	private QaObject object;
	private WebDriver driver;
	
	public WaitTillHiddenProcessor(QaObject object,WebDriver driver){
		
		this.object = object;
		this.driver = driver;
		
	}
	@Override
	public boolean runTest() 
	{
		String xpath = object.getObjXpath();
		return Utils.waitTillElementHides(driver, xpath);
	}
}
