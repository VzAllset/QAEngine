package com.vzw.prepaid.processor;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.commonUtils.Utils;

public class ClickActionProcessor implements ActionExecutor {
	
	
	static Logger logger  = Logger.getLogger(ClickActionProcessor.class);
	
	
	private Object object;
	private WebDriver driver;
	
	
	public ClickActionProcessor(Object object, Data data, WebDriver driver) {
		
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction(){
		String xpath = object.getObjectXPath();
		Utils.getWebElement(driver,xpath).click();
	
	}

}
