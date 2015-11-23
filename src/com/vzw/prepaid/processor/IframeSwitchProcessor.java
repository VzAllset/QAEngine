package com.vzw.prepaid.processor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.commonUtils.Utils;

public class IframeSwitchProcessor implements ActionExecutor {
	
	static Logger logger  = Logger.getLogger(IframeSwitchProcessor.class);
	
	private Object object;
	private WebDriver driver;
	
	
	public IframeSwitchProcessor(Object object, WebDriver driver) {
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction(){
		String xpath = object.getObjectXPath();
		driver.switchTo().frame(Utils.getWebElement(driver, xpath));
	}
}

