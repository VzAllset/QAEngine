package com.vzw.prepaid.processor;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.dao.generated.QaData;
import com.vzw.prepaid.dao.generated.QaObject;

public class ClickActionProcessor implements ActionExecutor {
	
	
	static Logger logger  = Logger.getLogger(ClickActionProcessor.class);
	
	
	private QaObject object;
	private WebDriver driver;
	
	
	public ClickActionProcessor(QaObject object, QaData data, WebDriver driver) {
		
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction(){
		String xpath = object.getObjXpath();
		Utils.getWebElement(driver,xpath).click();
	
	}

}
