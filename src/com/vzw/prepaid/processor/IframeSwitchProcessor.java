package com.vzw.prepaid.processor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.dao.generated.QaObject;

public class IframeSwitchProcessor implements ActionExecutor {
	
	static Logger logger  = Logger.getLogger(IframeSwitchProcessor.class);
	
	private QaObject object;
	private WebDriver driver;
	
	
	public IframeSwitchProcessor(QaObject object, WebDriver driver) {
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction(){
		String xpath = object.getObjXpath();
		driver.switchTo().frame(Utils.getWebElement(driver, xpath));
	}
}

