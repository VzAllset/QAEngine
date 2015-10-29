package com.vzw.prepaid.processor;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.commonUtils.Utils;

public class FillActionProcessor implements ActionExecutor {
	
	static Logger logger  = Logger.getLogger(FillActionProcessor.class);
	
	private Data data;
	private Object object;
	private WebDriver driver;
	
	
	public FillActionProcessor(Object object, Data data, WebDriver driver) {
		
		this.data = data;
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction(){
		String xpath = object.getObjectXPath();
		String dataToBeFilled = data.getDataValue();
		Utils.getWebElement(driver, xpath).sendKeys(dataToBeFilled);
	}
	
	
	
	

}
