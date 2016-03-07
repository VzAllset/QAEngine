package com.vzw.prepaid.processor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.dao.generated.QaObject;

public class EnterKeyProcessor implements ActionExecutor{

	private QaObject object;
	private WebDriver driver;
	
	public EnterKeyProcessor(QaObject object, WebDriver driver)
	{
		this.object = object;
		this.driver = driver;
	}
	
	@Override
	public void runAction() {
		String xpath = object.getObjXpath();
		Utils.getWebElement(driver, xpath).sendKeys(Keys.ENTER);
	}
}