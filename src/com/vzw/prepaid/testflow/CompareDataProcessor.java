package com.vzw.prepaid.testflow;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.commonUtils.Utils;

public class CompareDataProcessor implements TestExecutor{
	
	static Logger logger = Logger.getLogger(CompareDataProcessor.class);

	private Data data;
	private Object object;
	private WebDriver driver;
	
	public CompareDataProcessor(Object object , Data data, WebDriver driver){
		
		this.object = object;
		this.data = data;
		this.driver = driver;
		
	}
	
	@Override
	public boolean runTest() {
		// TODO Auto-generated method stub
		String xpath = object.getObjectXPath();
		String dataToCompare = data.getDataValue();
		logger.debug("dataToCompare :::" +dataToCompare+"<----");
		logger.debug("actual data in screen ::::" + Utils.getWebElement(driver, xpath).getText().trim()+"<----");
		return Utils.getWebElement(driver, xpath).getText().trim().equals(dataToCompare);
	
	}
	
	
	
	

}
