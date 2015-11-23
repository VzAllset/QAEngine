package com.vzw.prepaid.processor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.commonUtils.Utils;

public class HoverProcessor implements ActionExecutor {
	
	static Logger logger  = Logger.getLogger(HoverProcessor.class);
	
	private Object object;
	private WebDriver driver;
	
	public HoverProcessor(Object object, WebDriver driver) {
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction(){
		String xpath = object.getObjectXPath();
		Actions actions = new Actions(driver);
		actions.moveToElement(Utils.getWebElement(driver, xpath));
		actions.perform();
	}
}

