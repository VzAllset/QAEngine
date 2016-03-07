package com.vzw.prepaid.processor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.dao.generated.QaData;
import com.vzw.prepaid.dao.generated.QaObject;
import com.vzw.prepaid.listeners.AjaxListener;

public class AjaxClickActionProcessor implements ActionExecutor
{
	private QaObject object;
	private EventFiringWebDriver eventFiringWD;
	
	public AjaxClickActionProcessor(QaObject object, QaData data, WebDriver driver)
	{
		this.object = object;
		eventFiringWD = new EventFiringWebDriver(driver);
		AjaxListener eventListener = new AjaxListener();
		eventFiringWD.register(eventListener);
	}
	
	@Override
	public void runAction() {
		String xpath = object.getObjXpath();
		Utils.getWebElement(eventFiringWD, xpath).click();
	}

}
