package com.vzw.prepaid.processor;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.dao.generated.QaData;
import com.vzw.prepaid.dao.generated.QaObject;

public class FillActionProcessor implements ActionExecutor {
	
	static Logger logger  = Logger.getLogger(FillActionProcessor.class);
	
	private QaData data;
	private QaObject object;
	private WebDriver driver;
	
	
	public FillActionProcessor(QaObject object, QaData data, WebDriver driver) {
		
		this.data = data;
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction(){
		String xpath = object.getObjXpath();
		String dataToBeFilled = data.getDataValue();
		Utils.getWebElement(driver, xpath).sendKeys(dataToBeFilled);
	}
	
	
	
	

}
