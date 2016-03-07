package com.vzw.prepaid.processor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.dao.generated.QaObject;

public class HoverProcessor implements ActionExecutor {
	
	static Logger logger  = Logger.getLogger(HoverProcessor.class);
	
	private QaObject object;
	private WebDriver driver;
	
	public HoverProcessor(QaObject object, WebDriver driver) {
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction(){
		String xpath = object.getObjXpath();
		Actions actions = new Actions(driver);
		actions.moveToElement(Utils.getWebElement(driver, xpath));
		actions.perform();
	}
}

