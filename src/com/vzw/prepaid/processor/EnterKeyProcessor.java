package com.vzw.prepaid.processor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.commonUtils.Utils;

public class EnterKeyProcessor implements ActionExecutor{

	private Object object;
	private WebDriver driver;
	
	public EnterKeyProcessor(Object object, WebDriver driver)
	{
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction() {
		String xpath = object.getObjectXPath();
		Utils.getWebElement(driver, xpath).sendKeys(Keys.ENTER);
	}
}