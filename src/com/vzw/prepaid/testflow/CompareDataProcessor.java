package com.vzw.prepaid.testflow;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;
import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.dao.generated.QaData;
import com.vzw.prepaid.dao.generated.QaObject;

public class CompareDataProcessor implements TestExecutor{
	
	static Logger logger = Logger.getLogger(CompareDataProcessor.class);

	private QaData data;
	private QaObject object;
	private WebDriver driver;
	
	public CompareDataProcessor(QaObject object , QaData data, WebDriver driver){
		
		this.object = object;
		this.data = data;
		this.driver = driver;
		
	}
	
	@Override
	public boolean runTest() {
		// TODO Auto-generated method stub
		String xpath = object.getObjXpath();
		String dataToCompare = data.getDataValue();
		logger.debug("dataToCompare :::" +dataToCompare+"<----");
		logger.debug("actual data in screen ::::" + Utils.getWebElement(driver, xpath).getText().trim()+"<----");
		return Utils.getWebElement(driver, xpath).getText().trim().equals(dataToCompare);
	
	}
	
	
	
	

}
