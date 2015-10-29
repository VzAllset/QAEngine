package com.vzw.prepaid.processor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.listeners.AjaxListener;

public class AjaxClickActionProcessor implements ActionExecutor
{
	private Object object;
	private EventFiringWebDriver eventFiringWD;
	
	public AjaxClickActionProcessor(Object object, Data data, WebDriver driver)
	{
		this.object = object;
		eventFiringWD = new EventFiringWebDriver(driver);
		AjaxListener eventListener = new AjaxListener();
		eventFiringWD.register(eventListener);
	}
	
	@Override
	public void runAction() {
		String xpath = object.getObjectXPath();
		Utils.getWebElement(eventFiringWD, xpath).click();
	}

}
